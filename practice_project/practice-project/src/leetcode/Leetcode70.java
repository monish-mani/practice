package leetcode;

public class Leetcode70 {

	public static void main(String[] args) {
		Leetcode70 lc70 = new Leetcode70();
		int n = 2;
		System.out.println(lc70.climbStairsBottomUp(n));

		int[] subproblems = new int[n+1];
		for(int i =0;i<n+1;i++) {
			subproblems[i]=-1;
		}
		System.out.println(lc70.climbStairsTopDown(n,subproblems));
		
	}

	public int climbStairsBottomUp(int n) {
		if(n == 1) {
			return 1;
		}
		int[] noOfWays = new int[n+1];
		noOfWays[0] = 1;
		noOfWays[1] = 1;
		//noOfWays[2] = 1;
		
		//Using tabulation(bottom up) method to calculate no of ways of climbing n stairs
		for(int i=2;i<n+1;i++) {
			noOfWays[i] = noOfWays[i-1] + noOfWays[i-2];
		}
		
		return noOfWays[n];
	}
	
	public int climbStairsTopDown(int n,int[] subproblems) {
		if(n == 0 || n == 1) {
			return 1;
		}else if(subproblems[n]!=-1) {
			return subproblems[n];
		}
		
		subproblems[n] = climbStairsTopDown(n-1,subproblems) + climbStairsTopDown(n-2,subproblems);
		return subproblems[n];
	}

}
