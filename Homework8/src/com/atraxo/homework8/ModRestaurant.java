package com.atraxo.homework8;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ModRestaurant {
	ModMeal meal;
	List<ModWaitPerson> waitPerson = new ArrayList<>();
	List<ModChef> chef = new ArrayList<>();

	ExecutorService exec;

	BlockingQueue<Integer> incoming;
	BlockingQueue<Integer> outgoing;

	public ModRestaurant(int nrWaitPersons, int nrChefs) {
		exec = Executors.newFixedThreadPool(nrChefs + nrWaitPersons);

		incoming = new ArrayBlockingQueue<>(nrWaitPersons);
		outgoing = new ArrayBlockingQueue<>(nrWaitPersons);
		
		for (int i = 0; i < nrWaitPersons; i++)
			waitPerson.add(new ModWaitPerson(this, i));
		for (int i = 0; i < nrChefs; i++)
			chef.add(new ModChef(this, i));
		for (ModWaitPerson wp : waitPerson)
			exec.execute(wp);
		for (ModChef cf : chef)
			exec.execute(cf);
	}

	public static void main(String[] args) {
		new ModRestaurant(4, 4);
	}

	class ModMeal {
		private final int orderNum;

		public ModMeal(int orderNum) {
			this.orderNum = orderNum;
		}

		public String toString() {
			return "Meal " + orderNum;
		}
	}

	class ModWaitPerson implements Runnable {
		private ModRestaurant restaurant;
		public int id;

		public ModWaitPerson(ModRestaurant r, int id) {
			restaurant = r;
			this.id = id;
		}

		public void run() {
			try {
				while (!Thread.interrupted()) {
					Thread.sleep(1000);
					synchronized (this) {
						while (restaurant.meal == null)
							wait(); // ... for the chef to produce a meal
					}
					print(this.id + ": Waitperson got " + restaurant.meal + "\n");
					synchronized (restaurant.chef.get(id)) {
						restaurant.meal = null;
						restaurant.chef.get(id).notify(); // Ready for another
					}
				}
			} catch (InterruptedException e) {
				print("WaitPerson interrupted");
			}
		}
	}

	class ModChef implements Runnable {

		private ModRestaurant restaurant;
		public int id;
		int count = 0;
		
		public ModChef(ModRestaurant r, int id) {
			restaurant = r;
			this.id = id;
		}

		public void run() {
			
			
			try {
				while (!Thread.interrupted()) {
					Thread.sleep(1000);
					synchronized (this) {
						while (restaurant.meal != null)
							wait(); // ... for the meal to be taken
					}
						if (++count == 10) {
							print("Out of food, closing");
							restaurant.exec.shutdownNow();
						}
					printnb(this.id + ": Order up! \n");
					synchronized (restaurant.waitPerson.get(id)) {
						restaurant.meal = new ModMeal(count);
						restaurant.waitPerson.get(id).notify();
					}

					TimeUnit.MILLISECONDS.sleep(100);
				}
			} catch (InterruptedException e) {
				print("Chef interrupted");
			}
		}
	}
}