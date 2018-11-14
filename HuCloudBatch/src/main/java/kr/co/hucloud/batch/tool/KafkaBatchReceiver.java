package kr.co.hucloud.batch.tool;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaBatchReceiver {

	private static KafkaConsumer<String, String> consumer;

	private static Properties makeProps() {
		Properties props = new Properties();
		props.put("group.id", "kafka-consumer-group-batch");
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer", StringDeserializer.class);
		props.put("value.deserializer", StringDeserializer.class);
		return props;
	}

	private static void makeConsumer() {
		consumer = new KafkaConsumer<>(makeProps());
		consumer.subscribe(Arrays.asList("BatchTopic"));
	}

	public static ConsumerRecords<String, String> receive() {
		if (consumer == null) {
			makeConsumer();
		}
		return consumer.poll(3000);
	}

	public static void close() {
		if (consumer != null) {
			consumer.close();
		}
	}

}