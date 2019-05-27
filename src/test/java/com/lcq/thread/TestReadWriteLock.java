package com.lcq.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadWrite rw = new ReadWrite();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rw.set(20);
			}
		},"寫線程").start();
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					rw.get();
				}
			}).start();
		}
		
		
		
		
	}

}

class ReadWrite {
	private int i=11;
	ReadWriteLock lk = new ReentrantReadWriteLock();
	public void set(int i) {
		lk.writeLock().lock();
		try {
			Thread.currentThread().sleep(1000);
			this.i=i;
			System.out.println(Thread.currentThread().getName()+":"+this.i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lk.writeLock().unlock();
		}
		
	}
	public void get() {
		//return this.i;
		lk.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+":"+this.i);
		}finally {
			lk.readLock().unlock();
		}
	}
	
}