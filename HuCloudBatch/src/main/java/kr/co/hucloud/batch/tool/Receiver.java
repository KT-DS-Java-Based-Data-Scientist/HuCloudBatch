package kr.co.hucloud.batch.tool;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Receiver {

   private KafkaConsumer<String, String> consumer;

   public Receiver(String groupId, String bootstrapServers, String keyDeserializer, String valueDeserializer) {
      Properties props = new Properties();
      props.put("group.id", groupId);
      props.put("bootstrap.servers", bootstrapServers);
      props.put("key.deserializer", keyDeserializer);
      props.put("value.deserializer", valueDeserializer);
      props.put("enable.auto.commit", "false");

      consumer = new KafkaConsumer<>(props);
   }

   public ConsumerRecords<String, String> receive(String topic) {
      consumer.subscribe(Arrays.asList(topic));
      ConsumerRecords<String, String> record = consumer.poll(1000);
      consumer.commitSync();
      return record;
   }

   public void pause() {
      if (consumer != null) {
         
      }
   }
   
}