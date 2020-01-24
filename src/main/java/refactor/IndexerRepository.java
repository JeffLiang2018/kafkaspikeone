package refactor;

import java.util.List;

public class IndexerRepository {
    public void saveAll(List<Product> list) {
        for (Product p : list) {
            System.out.println("Product p " + p.sku + " is saved");
        }
    }

    public void save(Product p) {
        System.out.println("Product p " + p.sku + " is saved");
    }
}
