package remitly;
import java.util.*;

public class Phone {

	public static void main(String[] args) {
		String input = "ilike";

		System.out.println(isStringSplittable(input));

	}

	public static boolean isStringSplittable(String input) {
		if (input == null || input.length() == 0) {
			return true;
		}

		StringBuilder inputSB = new StringBuilder(input);

		// endIndex starts 1
		// Check if input greater than length 1
		if (input.length() == 1 && isWord(input)) {
			return true;
		}

		return parseSubString(0, 1, inputSB);

	}

	private static boolean parseSubString(int startIndex, int endIndex, StringBuilder inputSB) {
		if((endIndex == inputSB.length() + 1) && startIndex == inputSB.length()) return true;
		
		if (endIndex > inputSB.length())
			return false;
		System.out.println("startIndex,endIndex: " + startIndex + " " + endIndex);

		if (startIndex == inputSB.length() + 1 && endIndex == inputSB.length() + 1) {
			return true;
		}

		String subString = inputSB.substring(startIndex, endIndex);
		System.out.println("startIndex,endIndex: " + startIndex + " " + endIndex);
		System.out.println("Current substring: " + subString);

		if (isWord(subString)) {
			return parseSubString(endIndex, endIndex + 1, inputSB) || parseSubString(startIndex, endIndex + 1, inputSB);

		} else {
			return parseSubString(startIndex, endIndex + 1, inputSB);

		}

	}

	public static boolean isWord(String candidate) {
		Set<String> words = new HashSet<String>();
		String[] a = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
			  "cream", "icecream", "man", "go", "mango"};
		List<String> wordList = Arrays.asList(a);
		words.addAll(wordList);
		
		return words.contains(candidate);
	}

}
