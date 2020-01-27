package KafkaDevDemo;

public interface IKafkaDevConstants {

    public static String KAFKA_BROKERS = "kafka-oo-358735162-12-370567870.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-10-370567864.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-3-370567843.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-15-370567879.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-4-370567846.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-2-370567840.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-6-370567852.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-1-370567837.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-11-370567867.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-13-370567873.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-8-370567858.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-5-370567849.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-9-370567861.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-7-370567855.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092,kafka-oo-358735162-14-370567876.non-prod-5-az-scus.kafka-cluster-shared.ms-df-messaging.stg-az-southcentralus-1.prod.us.walmart.net:9092";
    public static Integer MESSAGE_COUNT=3;
    public static String CLIENT_ID="client1";
    public static String TOPIC_NAME="gm-sku-data-dv";
    public static String GROUP_ID_CONFIG="local.dev.consumer";
    public static Integer MAX_NO_MESSAGE_FOUND_COUNT=100;
    public static String OFFSET_RESET_LATEST="latest";
    public static String OFFSET_RESET_EARLIER="earliest";
    public static Integer MAX_POLL_RECORDS=1;
}
