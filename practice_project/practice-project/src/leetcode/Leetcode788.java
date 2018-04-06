package leetcode;

public class Leetcode788 {

	public static void main(String[] args) {
		System.out.println(rotatedDigits(10));
	}

	public static int rotatedDigits(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (isValid(i)) {
				count++;
				// System.out.println(i);
			}
		}

		return count;
	}

	private static boolean isValid(int num) {
		// 3,4,7
		boolean irreversibleDigits = false;
		// 0,1,8
		boolean nonChangeableDigits = false;
		// 2,5,6,9
		boolean changeableDigits = false;

		while (num > 0) {
			int currDigit = num % 10;
			if (currDigit == 3 || currDigit == 4 || currDigit == 7) {
				return false;
			} else if (currDigit == 0 || currDigit == 1 || currDigit == 8) {
				nonChangeableDigits = true;
			} else if (currDigit == 2 || currDigit == 5 || currDigit == 6 || currDigit == 9) {
				changeableDigits = true;
			}

			num /= 10;
		}

		return nonChangeableDigits == true ? nonChangeableDigits && changeableDigits : changeableDigits;
	}

}
