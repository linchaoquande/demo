package com.lcq.thread;

public class Tread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1();
		t1.setName("线程1");
		t1.start();
		
		for(int i=0 ; i<100 ; i++) {
			if(i%2 == 0) {
				Thread.currentThread().yield();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}

}
class Thread1 extends Thread {
	public void run() {
		
		for(int i=0 ; i<100 ; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}