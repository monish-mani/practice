package leetcode;

public class Leetcode651 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxA(int N) {
		int maxACount=0;
		if(N<=3){
			return N;
		}
		
		/*
		 * You need a minimum of 3 a's on the board to make an SCP(select + copy +paste) to make to have an increase in number of A's
		 * as compared to the traditional way(Simply adding N a's).
		 */
		
		int remainingCountAfterPreReq = N-3;
		maxACount=3;
		int bufferCount=3;
		
		if(remainingCountAfterPreReq < 3){
			return N;
		}
		
		while(remainingCountAfterPreReq >= 3){
			maxACount +=bufferCount;
			remainingCountAfterPreReq-=3;
		}
		
		return maxACount;
	}

}
