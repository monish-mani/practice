package leetcode;

public class Leetcode292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode292 lc292 = new Leetcode292();
		System.out.println(lc292.canWinNim(8));
	}

	public boolean canWinNim(int n) {
		if(n<=3) return true;
		Boolean[] canWin = new Boolean[n+1]; //Array is in the perspective of player 1
		
		canWin[0] = true;
		canWin[1] = true;
		canWin[2] = true;
		canWin[3] = true;
		canWin[4] = false;
		
		Boolean result = canWinNimDP(n,canWin);
		return result.booleanValue();
	}
	
	private Boolean canWinNimDP(int n,Boolean[] canWin) {
		if(n < 0) return new Boolean(false);
		if(canWin[n]!=null) return canWin[n];
		
		Boolean firstPossibility = canWinNimDP(n-1,canWin);
		Boolean secondPossibility = canWinNimDP(n-2,canWin);
		Boolean thirdPossibility = canWinNimDP(n-3,canWin);
		
		return firstPossibility.booleanValue() || secondPossibility.booleanValue() || thirdPossibility.booleanValue();
	}

}
