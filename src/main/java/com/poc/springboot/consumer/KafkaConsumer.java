package com.poc.springboot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.poc.springboot.constant.ApplicationConstant;
import com.poc.springboot.entity.Book;

@RestController
public class KafkaConsumer {

@KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING, topics = ApplicationConstant.TOPIC_NAME, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
public String getMsgFromTopic(String data) {
	System.out.println(data);
	return data;
}
@KafkaListener(groupId = "group-id-string-2", topics = "poc", containerFactory = "bookKafkaListenerContainerFactory")
public Book getJsonMsgFromTopic(Book book) {
	System.out.println("book..." + book.getBookName());

	return book;
}

}
