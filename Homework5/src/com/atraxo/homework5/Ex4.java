package com.atraxo.homework5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

//[ZP] - 10
public class Ex4 {

	public static void main(String[] args) {

		Collection<Message> collection = new ArrayList<>();
		int[] subscribers = new int[6]; 
		
		for (int i = 0; i < 1000; i++) {

			Random random = new Random();
			collection.add(new Message(random.nextInt(5) + 1));
		}
		
		for (IMessage m : collection) {
			switch (m.getTopic()) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
			}
			subscribers[m.getTopic()] ++;
		}
		
		for(int i = 1; i < subscribers.length; i++){
			System.out.println("subscriber " + i + " has received " + subscribers[i] + " messages");
		}
	}
}

interface IMessage {

	int getTopic();

	void setTopic(int topic);

}

class Message implements IMessage {
	private int topic;

	public Message(int topic) {
		this.topic = topic;
	}

	@Override
	public int getTopic() {
		return topic;
	}

	@Override
	public void setTopic(int topic) {
		this.topic = topic;
	}
}

