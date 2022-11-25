package com.tpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

@Component("myMailService")
//@Scope("singleton")
@Scope("prototype")
public class MailService implements MessageService {
	
	//Field Injection
//	@Autowired
//	@Qualifier("fileRepo")
//	private Repository repository;
	//this.repository=repository;
	
	
	//Setter Injection
//	private Repository repository;
//	@Autowired
//	@Qualifier("dbRepository")
//	public void setRepository(Repository repository) {
//		this.repository=repository;
//	}
	
	@Value("${app.email}")
	private String email;
	
	
	public MailService() {
		// TODO Auto-generated constructor stub
	}
	
	//-----
	private Repository repository;

	@Autowired
	public MailService(@Qualifier("dbRepository") Repository repository) {
		this.repository=repository;
	}
	//----
	
	
	
	@Override
	public void sendMessage(Message message) {
		System.out.println("I am an email service, I am sending a message to "+email+" "+message.getMessage());
		repository.saveMessage(message);
	}

}
