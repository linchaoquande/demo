package com.lcq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABC {
	public static void main(String[] args) {
		ABC abc =new ABC();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<20;i++) {
					abc.loopA(i);
					
				}
			}
		},"A").start();
		new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(int i=1;i<20;i++) {
							abc.loopB(i);
							
						}
					}
				},"B").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<20;i++) {
					abc.loopC(i);
					
				}
			}
		},"C").start();
	}

}

class ABC {
	private int flag=1;
	Lock lk = new ReentrantLock();
	Condition con1= lk.newCondition();
	Condition con2= lk.newCondition();
	Condition con3= lk.newCondition();
	
	public void loopA(int totalLoop) {
		lk.lock();
		try {
			while(flag!=1) {
					con1.await();
			}
			for(int i=1;i<6;i++) {
				System.out.println(Thread.currentThread().getName()+"--"+i+"--"+totalLoop);
			}
			flag=2;
			con2.signal();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lk.unlock();
		}
	}
	public void loopB(int totalLoop) {
		lk.lock();
		try {
			while(flag!=2) {
					con2.await();
			}
			for(int i=1;i<11;i++) {
				System.out.println(Thread.currentThread().getName()+"--"+i+"--"+totalLoop);
			}
			flag=3;
			con3.signal();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lk.unlock();
		}
	}
	public void loopC(int totalLoop) {
		lk.lock();
		try {
			while(flag!=3) {
					con3.await();
			}
			for(int i=1;i<21;i++) {
				System.out.println(Thread.currentThread().getName()+"--"+i+"--"+totalLoop);
			}
			System.out.println("---------------------");
			flag=1;
			con1.signal();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lk.unlock();
		}
	}
}
