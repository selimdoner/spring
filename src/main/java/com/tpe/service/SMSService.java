package com.tpe.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

@Component("smsService")
public class SMSService implements MessageService {
	
	@Autowired
	@Qualifier("fileRepository")
	private Repository repository;
	
	@Value("${app.count}")
	private Integer count;
	
	@Autowired
	private Properties properties;
	
	@Override
	public void sendMessage(Message message) {
		System.out.println("I am an SMS service, I am sending a message to "+count+ " user "+message.getMessage());
		repository.saveMessage(message);
		
		System.out.println("Email:"+properties.get("email"));
		System.out.println("JAVA_HOME:"+properties.get("MYJAVA_HOME"));
	}
}
