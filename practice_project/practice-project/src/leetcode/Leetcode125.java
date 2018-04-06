package leetcode;

public class Leetcode125 {

	public static void main(String[] args) {
		Leetcode125 lc125 = new Leetcode125();
		System.out.println(lc125.isPalindrome("A man, a plan, a canal: Panama"));
		
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (isCharacterAlphanumeric(s.charAt(start)) == -1) {
				start++;
				continue;
			}
			if (isCharacterAlphanumeric(s.charAt(end)) == -1) {
				end--;
				continue;
			}

			if (isCharacterAlphanumeric(s.charAt(start)) == isCharacterAlphanumeric(s.charAt(start))
					&& isEqual(s.charAt(start), s.charAt(end))) {
				start++;
				end--;
			} else {
				return false;
			}

		}
		return true;

	}

	// returns 0 - alphabet, 1 - number, -1 - non alphanumeric character
	private int isCharacterAlphanumeric(char c) {
		int ascii = (int) c;

		if (ascii >= 'a' && ascii <= 'z' || ascii >= 'A' && ascii <= 'Z')
			return 0;

		if (ascii >= '0' && ascii <= '9')
			return 1;

		return -1;
	}

	private boolean isEqual(char a, char b) {
		if (a == b)
			return true;

		int aOffset = a >= 'a' && a <= 'z' ? a - 'a' : a - 'A';
		int bOffset = b >= 'a' && b <= 'z' ? b - 'a' : b - 'A';

		return aOffset == bOffset;
	}
}
