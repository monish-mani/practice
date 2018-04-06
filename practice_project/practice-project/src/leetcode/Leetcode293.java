package leetcode;

import java.util.*;

public class Leetcode293 {

	public static void main(String[] args) {
		String s = "++++";
		System.out.println(generatePossibleNextMoves(s));

	}

	public static List<String> generatePossibleNextMoves(String s) {

		// replace(int start, int end, String str)
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder(s);
		int i = 1;

		while (i < s.length()) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				sb.replace(i - 1, i + 1, "--");
				result.add(sb.toString());
				sb.replace(i - 1, i + 1, "++");
			}
			i++;
		}

		return result;
	}

}
