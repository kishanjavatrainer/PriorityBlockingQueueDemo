package com.infotech.client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ClientTest1 {

	public static void main(String[] args) {
		String[] cityNames = { "Delhi", "Mumbai", "Chennai", "Bangalore", "Hyderabad", "Lucknow","Kolkata" };
		// Initializing PriortiyBlockingQueue
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();

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
						System.out.println("Consumer consumed - " + queue.take());
					} catch (InterruptedException e) {
						System.out.println("Error while retrieving value from the Queue " + e.getMessage());
					}
				}
			}
		}.start();
	}
}