package kafkademo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


public class EnvioKafka {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , StringSerializer.class.getName());

		// producer esse cara se conecta ao kafka para enviar os registros
		
		try(KafkaProducer<String, String> producer = new KafkaProducer<>(properties)){
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("testejava", "Hello World Kafka");
			producer.send(record);
		}
		finally {
			System.out.println("--- End ---");
		}
	}
}
