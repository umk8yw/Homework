package com.atraxo.homework8;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {
	Meal meal;
	  ExecutorService exec = Executors.newCachedThreadPool();
	  WaitPerson waitPerson = new WaitPerson(this);
	  WaitPerson otherPerson = new WaitPerson(this);
	  Chef chef = new Chef(this);
	  public Restaurant() {
	    exec.execute(chef);
	    exec.execute(waitPerson);
	    exec.execute(otherPerson);
	  }
	  public static void main(String[] args) {
	    new Restaurant();
}

class Meal {
	  private final int orderNum;
	  public Meal(int orderNum) { this.orderNum = orderNum; }
	  public String toString() { return "Meal " + orderNum; }
	}

	class WaitPerson implements Runnable {
	  private Restaurant restaurant;
	  public WaitPerson(Restaurant r) { restaurant = r; }
	  public void run() {
	    try {
	      while(!Thread.interrupted()) {
	        synchronized(this) {
	          while(restaurant.meal == null)
	            wait(); // ... for the chef to produce a meal
	        }
	        print("WaitPerson got " + restaurant.meal);
	        synchronized(restaurant.chef) {
	          restaurant.meal = null;
	          restaurant.chef.notifyAll(); // Ready for another
	        }
	        print("OtherWaitPerson got " + restaurant.meal);
	        synchronized(restaurant.chef) {
		          restaurant.meal = null;
		          restaurant.chef.notifyAll(); // Ready for another
		        }
	      }
	    } catch(InterruptedException e) {
	      print("WaitPerson interrupted");
	    }
	  }
	}

	class Chef implements Runnable {
	  private Restaurant restaurant;
	  private int count = 0;
	  public Chef(Restaurant r) { restaurant = r; }
	  public void run() {
	    try {
	      while(!Thread.interrupted()) {
	        synchronized(this) {
	          while(restaurant.meal != null)
	            wait(); // ... for the meal to be taken
	        }
	        if(++count == 10) {
	          print("Out of food, closing");
	          restaurant.exec.shutdownNow();
	        }
	        printnb("Order up1! ");
	        synchronized(restaurant.waitPerson) {
	          restaurant.meal = new Meal(count);
	          restaurant.waitPerson.notifyAll();
	        }
	        printnb("Order up2! ");
	        synchronized(restaurant.otherPerson) {
		          restaurant.meal = new Meal(count);
		          restaurant.otherPerson.notifyAll();
		        }
	        TimeUnit.MILLISECONDS.sleep(100);
	      }
	    } catch(InterruptedException e) {
	      print("Chef interrupted");
	    }
	  }
	}
}