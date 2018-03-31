package com.infotech.client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.infotech.sort.CityComparator;

public class ClientTest2 {

	public static void main(String[] args) {
		String[] cityNames = { "Delhi", "Mumbai", "Chennai", "Bangalore", "Hyderabad", "Lucknow","Kolkata" };
		// initializing PriortiyBlockingQueue
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>(10, new CityComparator());

		// Producer thread
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < cityNames.length; i++) {
					try {
						queue.put(cityNames[i]);
					} catch (InterruptedException e) {
						System.out.println("Error while putting values in the Queue " + e.getMessage());
					}
				}
			}
		}.start();

		// Consumer thread
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < cityNames.length; i++) {
					try {
						System.out.println("Consumer Consumed - " + queue.take());
					} catch (InterruptedException e) {
						System.out.println("Error while retrieving value from the Queue " + e.getMessage());
					}
				}
			}
		}.start();
	}
}
