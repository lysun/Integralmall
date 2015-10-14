package com.doublev2v;

import org.junit.Test;

import com.doublev2v.foundation.shortmessage.MessageSender;
import com.doublev2v.foundation.shortmessage.SendMessageException;

public class MessageTest {

	private MessageSender sender=new MessageSender();
	
	@Test
	public void sendMessage(){
		String[] data={"123466"};
		try {
			sender.sendMessage("18612444099", "40950", data);
		} catch (SendMessageException e) {
			e.printStackTrace();
		}
	}
}
