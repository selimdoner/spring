package com.tpe.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tpe.domain.Message;

@Component("dbRepository")
public class DbRepository implements Repository {

	@Override
	public void saveMessage(Message message) {
		System.out.println("Message is saving via DbRepository:"+message.getMessage());
	}

}
