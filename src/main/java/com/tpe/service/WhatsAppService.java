package com.tpe.service;

import java.awt.Point;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tpe.domain.Message;
import com.tpe.thirdparty.ThirdPartyRepository;

@Component("whatsAppService")
@Scope("prototype")
public class WhatsAppService implements MessageService {
	
	@PostConstruct
	private void init() {
		System.out.println("Initializing.......");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("Destroying......");
	}
	
	@Autowired
	@Qualifier("myThirdParty")
	private ThirdPartyRepository thirdPartyRepository;
	
	@Autowired
	private Point point;
	
	@Override
	public void sendMessage(Message message) {
		System.out.println("I am an WhatsAppService, I am sending a message "+message.getMessage());
		thirdPartyRepository.save(message.getMessage());
		System.out.println("MyLocation:"+point.x+":"+point.y);
	}

}
