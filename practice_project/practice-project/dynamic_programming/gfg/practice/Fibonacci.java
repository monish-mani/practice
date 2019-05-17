package gfg.practice;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 5;
		int[] lookup = new int[n+1];
		
		for(int i=0;i<lookup.length;i++) {
			lookup[i] = -1;
		}
		
		Fibonacci fib = new Fibonacci();
		
		System.out.println(fib.fibTopDown(n,lookup));
		System.out.println(fib.fibBottomUp(n,lookup));
		System.out.println();
	}
	
	public int fibTopDown(int n,int[] lookup) {
		if(lookup[n]!=-1) {
			return lookup[n];
		}
		
		if(n<=1) {
			lookup[n] = 1;
		}else {
			int x = fibTopDown(n-1,lookup);
			int y = fibTopDown(n-2,lookup);
			lookup[n] =  x + y;
		}
		
		return lookup[n];
	}
	
	
	public int fibBottomUp(int n,int[] lookup) {
		if(n==0 || n == 1) {
			return 1;
		}
		lookup[0]=1;
		lookup[1]=1;
		
		for(int i=2;i<lookup.length;i++) {
			lookup[i] = lookup[i-1] + lookup[i-2];
		}
		
		return lookup[n-1];
	}

}
