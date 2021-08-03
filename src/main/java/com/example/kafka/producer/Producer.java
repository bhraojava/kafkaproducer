package com.example.kafka.producer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC= "TestTopic";
	
//	@Value("${csvpath}")
//	private  String csvpath;

	 @Value("classpath:cycle_gpx.csv")
	 private Resource res;
	
	public void publishMessages() {
		
		logger.info("sending messages to kafka topic "+ TOPIC);
//		for (int i = 0; i < 5; i++) {
//			kafkaTemplate.send(TOPIC, "hello world");
//		}
		
		try{
            Stream<String> stream = Files.lines(Paths.get(res.getURI()));
            stream.forEach(line -> {
            logger.info("message******* " + line);
            try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            kafkaTemplate.send(TOPIC, line);
            });
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		
	}

	@Bean
	public NewTopic adviceTopic() {
		return new NewTopic(TOPIC,1,(short)1);
	}
}
