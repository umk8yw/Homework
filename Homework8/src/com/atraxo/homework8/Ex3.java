package com.atraxo.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex3 {

	Producer producer = new Producer(this);
	Consumer consumer = new Consumer(this);

	Thread t1 = new Thread(producer);
	Thread t2 = new Thread(consumer);

	List<Integer> list = new ArrayList<>();

	public Ex3() {
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new Ex3();
	}
}

class Producer implements Runnable {

	Ex3 ex;

	public Producer(Ex3 ex) {
		this.ex = ex;
	}

	@Override
	public void run() {

		int i = 6;
		Random random = new Random();

		while (!Thread.interrupted()) {
			try {
				synchronized (this) {
					while (!ex.list.isEmpty())
						wait();
				}

				synchronized (ex.consumer) {
					for (int j = 0; j < random.nextInt(20); j++)
						ex.list.add(i++);

					System.out.println("producer produces: " + ex.list);
					ex.consumer.notify();
				}

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	Ex3 ex;

	public Consumer(Ex3 ex) {
		this.ex = ex;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {
			try {
			synchronized (this) {
				while (ex.list.isEmpty()) 
					
						wait();
					
				
			}
			synchronized (ex.producer) {
				System.out.println("consumer gets: " + ex.list.get(0));
				ex.list.remove(0);
				ex.producer.notify();
			}
			
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
