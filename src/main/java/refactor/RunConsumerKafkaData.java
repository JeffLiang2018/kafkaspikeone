package refactor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RunConsumerKafkaData implements Runnable {

    public MyConsumer myconsumer;

    public IndexerRepository indexerRepository;

    public void run() {

        Supplier<List<Product>> productsSupplier = getProductsSupplier();

        List<Product> productsToSave = new ArrayList<>();
        int productsNotFound = 0;
        while (true) {
            List<Product> products = productsSupplier.get();
            productsToSave.addAll(products);
            if (isBulkReady(productsToSave)) {
                saveAll(productsToSave);
            }

            productsNotFound = !products.isEmpty() ? 0 : productsNotFound + 1;

            if (productsNotFound >= 5) {
                saveAll(productsToSave);
                waitMillis(2000);
                productsNotFound = 0;
            }
        }


    }

    private Supplier<List<Product>> getProductsSupplier() {
        final MyConsumer myConsumer = MyConsumer.createConsumer();
        return () -> {
            MyConsumerRecords records = myConsumer.poll();
            return toProducts(records.recordList);
        };
    }

    private void waitMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveAll(List<Product> list) {
        this.indexerRepository.saveAll(list);
        list.clear();
    }

    private boolean isBulkReady(List<Product> list) {
        return list.size() >= 10;
    }

    private ArrayList<Product> toProducts(List<MyConsumeRecord> consumeRecords) {
        ArrayList<Product> products = new ArrayList<>();
        for (MyConsumeRecord record : consumeRecords) {
            products.add(toProduct(record));
        }
        return products;
    }

    private Product toProduct(MyConsumeRecord record) {
        String message = record.getValue();
        System.out.println("Received Message: " + message);
        String[] values = message.split(" ");
        try {
            return new Product(values[0], Integer.parseInt(values[1]));
        } catch (Exception e) {
            System.out.println("Error: Unable to add product to Product list" + message);
        }
        return null;
    }
}
