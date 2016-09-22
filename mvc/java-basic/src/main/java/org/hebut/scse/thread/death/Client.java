package org.hebut.scse.thread.death;
public class Client {
	public static void main(String[] args) {
		DeadThread1 dt1 = new DeadThread1();
		DeadThread2 dt2 = new DeadThread2();
		
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);

		t1.start();
		t2.start();
		
	}	
}