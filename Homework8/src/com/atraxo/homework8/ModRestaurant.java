package com.atraxo.homework8;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ModRestaurant {
	Meal meal;
	  ExecutorService exec = Executors.newCachedThreadPool();
	  ModWaitPerson waitPerson = new ModWaitPerson(this);
	  ModWaitPerson otherPerson = new ModWaitPerson(this);
	  ModChef chef = new ModChef(this);
	  public ModRestaurant() {
	    exec.execute(chef);
	    exec.execute(waitPerson);
	  }
	  public static void main(String[] args) {
	    new ModRestaurant();
}

class ModMeal {
	  private final int orderNum;
	  public ModMeal(int orderNum) { this.orderNum = orderNum; }
	  public String toString() { return "Meal " + orderNum; }
	}

	class ModWaitPerson implements Runnable {
	  private ModRestaurant restaurant;
	  public ModWaitPerson(ModRestaurant r) { restaurant = r; }
	  public void run() {
	    try {
	      while(!Thread.interrupted()) {
	        synchronized(this) {
	          while(restaurant.meal == null)
	            wait(); // ... for the chef to produce a meal
	        }
	        print("Waitperson got " + restaurant.meal);
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

	class ModChef implements Runnable {
	  private ModRestaurant restaurant;
	  private int count = 0;
	  public ModChef(ModRestaurant r) { restaurant = r; }
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
	        printnb("Order up! ");
	        synchronized(restaurant.waitPerson) {
	          restaurant.meal = new Meal(count);
	          restaurant.waitPerson.notifyAll();
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