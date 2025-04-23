package practice;

public class GenericMethedPractice {

	public static void main(String[] args) { //Calling Function/Caller Function
		
		//hardcoding
//		int a = 20;
//		int b = 30;
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(20,30);
		
		System.out.println(sum);
		System.out.println(add(sum,78));
		System.out.println(add(100,sum));
		
		int diff = sub(20,30);
		System.out.println(diff);
		System.out.println(sub(diff,50));
		System.out.println(sub(diff,20));
		
	}
	
	public static int add(int a, int b) { //called Function - Generic Method
		int c=a+b; //login
		return c;
//		System.out.println(c);
	}
	
	public static int sub(int x, int y) {
		int z = x-y;
		return z;
	}
}
