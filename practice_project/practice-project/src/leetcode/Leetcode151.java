package leetcode;

import java.util.Arrays;

public class Leetcode151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String result = reverseWords(" ");
		System.out.println(result);
	}

	public static String reverseWords(String s) {
		char[] str = s.toCharArray();
		int start = 0;
		int end = str.length - 1;

		reverseSingleWord(str, start, end);

		// Reverse word by word
		int index = 0;
		int lastSpace = 0;
		while (index < str.length) {
			if (str[index] == ' ') {
				lastSpace = index;
				reverseSingleWord(str, start, index - 1);
				start = index + 1;
			}
			index++;
		}

		if (lastSpace != 0) {
			reverseSingleWord(str, lastSpace + 1, str.length - 1);
		} else {
			reverseSingleWord(str, start, end);
		}

		String result = new String(str);

		// Removing leading and trailing spaces and middle spaces
		// trimString(result);
		return trimString(result.toCharArray(), result.length());
	}

	private static void reverseSingleWord(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;

			start++;
			end--;
		}
	}

	private static String trimString(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			if (j < n)
				a[i++] = ' '; // keep only one space
		}

		return new String(a).substring(0, i);
	}
}
