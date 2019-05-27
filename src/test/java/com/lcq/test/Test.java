package com.lcq.test;

public class Test {

	public static void main(String[] args) {
		System.out.println("tests");
		int a=10;
		int b=20;
		System.out.println("main--a:"+a+",b:"+b);
		change(a,b);
		System.out.println("main--a:"+a+",b:"+b);
		
		int[] arr= {1,2,3,4,5};
		change(arr);
		System.out.println("main--:"+arr[1]);
	}
	public static void change(int a,int b) {
		System.out.println("change--a:"+a+",b:"+b);
		change3();
		a=b;
		b=a+b;
		System.out.println("change--a:"+a+",b:"+b);
	}
	public static void change(int[] arr) {
		for(int x=0; x<arr.length; x++) {
			if(arr[x]%2==0) {
				arr[x]*=2;
			}
		}
	}
	public static void change3() {
		System.out.println("----");
	}
	
}
