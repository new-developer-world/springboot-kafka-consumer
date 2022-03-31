package com.poc.springboot.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.poc.springboot.constant.ApplicationConstant;
import com.poc.springboot.entity.Book;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {
	
	@Bean
	public ConsumerFactory<String,String> consumerFactory(){
		Map<String, Object>configMap=new HashMap<>();
		//Kafka Local Server Configuration
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.KAFKA_LOCAL_SERVER_CONFIG);
		
		//Defining which type of the data(key,value) going to deserialized
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id-string-1");
		
		return new DefaultKafkaConsumerFactory<>(configMap);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory1(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory=
				new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, Book> bookConsumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), 
				new JsonDeserializer<>(Book.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Book> bookKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Book> factory = new ConcurrentKafkaListenerContainerFactory<String, Book>();
		factory.setConsumerFactory(bookConsumerFactory());
		return factory;
	}
	
}
