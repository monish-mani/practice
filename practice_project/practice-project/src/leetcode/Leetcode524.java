package leetcode;

import java.util.*;

public class Leetcode524 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abpcplea";
		List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");

		System.out.println(findLongestWord(s, d));
	}

	public static String findLongestWord(String s, List<String> d) {

		HashMap<Character, ArrayList<Integer>> charPositionMap = new HashMap<Character, ArrayList<Integer>>();

		// NOTE: Got this in google phone interview!

		// 1.Populate charPositionMap
		for (int i = 0; i < s.length(); i++) {
			ArrayList<Integer> charPositions = charPositionMap.getOrDefault(s.charAt(i), new ArrayList<Integer>());
			charPositions.add(i);
			charPositionMap.put(s.charAt(i), charPositions);
		}

		// 2. Iterate through d to find longest word
		TreeSet<String> longestWords = new TreeSet<>();
		longestWords.add(""); // Because the program expects an empty string if
								// there are no words that can be formed.
		int longestWordLength = 0;

		for (String dictWord : d) {
			int lastCharPositionInMap = Integer.MIN_VALUE;
			int charIndex = 0;

			// Do not process words whose length is lesser than an already
			// compute valid from from d
			if (dictWord.length() < longestWordLength)
				continue;
			while (charIndex < dictWord.length()) {
				ArrayList<Integer> charPositions = charPositionMap.get(dictWord.charAt(charIndex));
				if (charPositions == null || charPositions.size() == 0)
					break;

				// Introduce binary search optimization here to find the first
				// position greater than lastCharPositionInMap
				int prevValue_lastCharPosition = lastCharPositionInMap;
				for (int position : charPositions) {
					if (position > lastCharPositionInMap) {
						lastCharPositionInMap = position;
						break;
					}
				}

				// If there is no secondary character to fulfill needs, word
				// does not exit
				// i.e. lastCharPosition value has not changed
				if (prevValue_lastCharPosition == lastCharPositionInMap) {
					break;
				}
				charIndex++;
			}

			if (charIndex == dictWord.length()) {
				if (dictWord.length() == longestWordLength) {
					longestWords.add(dictWord);
				} else if (dictWord.length() > longestWordLength) {
					longestWords.clear();
					longestWords.add(dictWord);
				}

				longestWordLength = dictWord.length();
			}

		}

		return longestWords.pollFirst();

	}
}
