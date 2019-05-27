package com.lcq.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Call1 c1 =new Call1();
		FutureTask<Integer> result = new FutureTask<>(c1);
		new Thread(result).start();
		
		try {
			Integer j=result.get();
			System.out.println(j);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

class Call1 implements Callable<Integer>{
	
	private int sum;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			sum+=i;
		}
		return sum;
	}
	
}