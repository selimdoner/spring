package com.tpe.app;

import java.awt.Point;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MessageService;

public class MyApplication {
	
	public static void main(String[] args) {
		Message message=new Message();
		message.setMessage("Order was sent.....");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
		MessageService service= context.getBean("whatsAppService",MessageService.class);
		
		MessageService service2= context.getBean("whatsAppService",MessageService.class);
		service.sendMessage(message);
		
		
		

		
		
//		Point point= context.getBean("point",Point.class);
//		
//		System.out.println("In Main Point:"+point.getX()+":"+point.getY());
		
		
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
//		MessageService service1= context.getBean("myMailService",MessageService.class);
//		MessageService service2= context.getBean("myMailService",MessageService.class);
//		
//		if(service1==service2) {
//			System.out.println("Same Reference");
//		}else {
//			System.out.println("Different Refrence");
//		}
		

		
//		String[] beanNames = context.getBeanDefinitionNames();
//		
//		for (String beanName : beanNames) {
//			System.out.println("Bean Name:"+beanName);
//		}
		
		
		context.close();
	}

}
