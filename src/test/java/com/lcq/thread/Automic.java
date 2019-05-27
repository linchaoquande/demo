package com.lcq.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Automic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAutoMic t = new TestAutoMic();
		for(int i=0 ; i<2;i++) {
			new Thread(t).start();
		}
	}

}
class TestAutoMic implements Runnable{

	private  int i =0;
	Lock lk =new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			lk.lock();
			for(int j=0; j<100;j++) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+ i++);
			}
		}finally {
			lk.unlock();
		}
	}
	
}