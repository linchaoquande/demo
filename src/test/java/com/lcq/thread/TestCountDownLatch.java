package com.lcq.thread;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cdl =new CountDownLatch(2);
		Count1 c1=new Count1(cdl);
		Count2 c2=new Count2(cdl);
		long start =System.currentTimeMillis();
		new Thread(c1).start();
		new Thread(c2).start();
		
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end =System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+(end-start));
	}

}
class Count1 implements Runnable{
	CountDownLatch cdl;
	public Count1(CountDownLatch cdl) {
		this.cdl=cdl;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<100;i++) {
				System.out.println(Thread.currentThread().getName());
			}
			System.out.println(Thread.currentThread().getName()+"结束了-----------");
		}finally {
			cdl.countDown();
		}
		
	}
	
}
class Count2 implements Runnable{

	CountDownLatch cdl;
	public Count2(CountDownLatch cdl) {
		this.cdl=cdl;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<200;i++) {
				System.out.println(Thread.currentThread().getName());
			}
			System.out.println(Thread.currentThread().getName()+"结束了-----------");
		}finally {
			cdl.countDown();
		}
	}
	
}