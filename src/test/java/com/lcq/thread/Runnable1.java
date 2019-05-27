package com.lcq.thread;

public class Runnable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People p =new People();
		Thread t1 =new Thread(p);
		Thread t2 =new Thread(p);
		Thread t3 =new Thread(p);

		t1.start();
		t2.start();
		t3.start();

	}

}

class People implements Runnable{

	private int ticket =100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ticket >0) {
			System.out.println(Thread.currentThread().getName()+"卖出第:"+ticket -- +"张票");
		}
	}
	
}