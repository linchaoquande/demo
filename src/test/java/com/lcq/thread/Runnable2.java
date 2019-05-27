package com.lcq.thread;

import org.omg.Messaging.SyncScopeHelper;

public class Runnable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People1 p1 =new People1();
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p1);
		t1.start();
		t2.start();
	}


}
class People1 implements Runnable{
	private int account;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i = 0;i<3;i++) {
				account+=1000;
				System.out.println(Thread.currentThread().getName()+"存了1000，余额为"+ account);
			}
			
		}
	}
	
}

//class People1 implements Runnable{
//
//	private Account a;
//	public People1 (Account a){
//		this.a= a;
//	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		if(a.getBalance()>0) {
//			
//		}
//	}
//	
//}
//
//class Account {
//	private int balance;
//
//	public int getBalance() {
//		return balance;
//	}
//
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
//	
//}