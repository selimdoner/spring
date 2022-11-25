package com.tpe.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tpe.domain.Message;

@Component("fileRepository")
//@Qualifier("fileRepo")
public class FileRepository implements Repository {

	@Override
	public void saveMessage(Message message) {
		System.out.println("Message is saving via FileRepository:"+message.getMessage());
	}

}
