package leetcode;

public class Leetcode686 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "a";
		String B= "aa";
		System.out.println(repeatedStringMatch(A,B));
	}

	public static int repeatedStringMatch(String A, String B) {

		if (A == null && B == null || A.length() == 0 && B.length() == 0) {
			return 0;
		}

		if (A == null || A.length() == 0) {
			return -1;
		}

		if (B == null || B.length() == 0) {
			return -1;
		}

		if(A.length() == 1) return B.length()/A.length();

		int aIndex = 0;
		int bIndex = 0;
		int count = 0;
		int numOfRepeats = 0;

		while (bIndex < B.length()) {
			if (A.charAt(aIndex) == B.charAt(bIndex)) {
				aIndex++;
				if (aIndex == A.length() - 1) {
					numOfRepeats++;
					aIndex = 0;
				}
			} else {
				aIndex = 0;
			}
			bIndex++;
		}

		return aIndex == 0 ? numOfRepeats : numOfRepeats + 2;
	}
}
