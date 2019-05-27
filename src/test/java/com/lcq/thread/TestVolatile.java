package com.lcq.thread;

public class TestVolatile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vol v =new Vol();
		Thread t1 =new Thread(v);
		t1.start();

		while(true) {
		if(v.isFlag()) {
			System.out.println("------------");
		}
		}

	}

}

class Vol implements Runnable{

	private volatile boolean flag=false;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setFlag(true);
		System.out.println(Thread.currentThread().getName()+":"+this.flag);
	}
	
}