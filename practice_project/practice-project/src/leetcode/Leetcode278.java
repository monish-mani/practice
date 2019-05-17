package leetcode;

public class Leetcode278 {

	public static void main(String[] args) {
		Leetcode278 lc278 = new Leetcode278();
		int n = 2126753390;
		boolean[] badVersion = new boolean[n];
		//2126753390
		//1702766719
		for(int i =1702766719;i<badVersion.length;i++) {
			badVersion[i] = true;
		}
		
		System.out.println(lc278.firstBadVersion(n,badVersion));

	}
	
	public int firstBadVersion(int n,boolean[] badVersion) {
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			int mid = start + (end - start)/2;
			if(badVersion[mid] == false) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		
		return start;
		
	}

}
