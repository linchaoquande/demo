package com.lcq.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProAndConsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clerk ck=new clerk();
		Productor p = new Productor(ck);
		Consumor c  = new Consumor(ck);
		
		new Thread(p, "生产者1").start();
		new Thread(c, "消费者1").start();
		new Thread(p, "生产者2").start();
		new Thread(c, "消费者2").start();
	}

}
class Productor implements Runnable{
	
	clerk ck ;
	public Productor(clerk ck ) {
		this.ck=ck;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			try {
				ck.product();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Consumor implements Runnable{
	
	clerk ck ;
	public Consumor(clerk ck ) {
		this.ck=ck;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			try {
				ck.consum();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class clerk{
	private int  product =0;
	Lock lk = new ReentrantLock();
	Condition condition=lk.newCondition();
	
	public  void product() throws InterruptedException {
		lk.lock();
		try {
			while(this.product>=1) {
				System.out.println("产品已满");
				//this.wait();
				condition.await();
			}
			System.out.println(Thread.currentThread().getName()+":"+ ++this.product);
			//this.notifyAll();
			condition.signalAll();
		}finally {
			lk.unlock();
		}
	}
	public  void consum() throws InterruptedException {
		lk.lock();
		try {
			while(this.product<=0) {
				System.out.println("产品缺货");
				//this.wait();
				condition.await();
			}
			System.out.println(Thread.currentThread().getName()+":"+ --this.product);
			//this.notifyAll();
			condition.signalAll();
		}finally {
			lk.unlock();
		}
	}
}