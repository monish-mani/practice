package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrammer {
	/**
	 * Problem: Given a list of words initially, write a method that takes in a
	 * word, and returns all known anagrams. Two words are anagrams if they have
	 * the same characters, but not necessarily in the same order. You can do
	 * whatever setup you want in order to make the method fast.
	 */

	private List<String> knownWords;

	public Anagrammer(List<String> knownWords) {
		this.knownWords = knownWords;
	}

	public List<String> findAnagrams(String inputWord) {

		if (inputWord == null || inputWord.length() == 0) {
			return new ArrayList<String>();
		}

		Map<String,ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();

		for (String knownWord : knownWords) {
			String hash = constructHash(knownWord);

			ArrayList<String> anagramList = (ArrayList<String>) anagramMap.getOrDefault(hash, new ArrayList<String>());
			anagramList.add(knownWord);
			anagramMap.put(hash, anagramList);

		}

		ArrayList<String> result = new ArrayList<>();

		String inputHash = constructHash(inputWord);

		result.addAll(anagramMap.get(inputHash));

		return result;

	}

	public String constructHash(String w) {

		int[] charCount = new int[26];
		for (char c : w.toCharArray()) {
			// A - 65,90
			// a - 97,122
			if ((int) c >= 65 && (int) c <= 90) {
				charCount[(int) c - 65]++;
			}

			if ((int) c >= 97 && (int) c <= 122) {
				charCount[(int) c - 97]++;
			}

		}

		StringBuilder hash = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			if (charCount[i] > 0) {
				char c = (char)(97+i);
				hash.append(c);
				hash.append(charCount[i]);
			}
		}

		return hash.toString();

	}

	public String constructHashUsingSorting(String word) {

		char[] sortedCharacters = word.toCharArray();
		Arrays.sort(sortedCharacters);

		String hash = new String(sortedCharacters);

		return hash;
	}
	
	
	public static void main(String args[]){
		String inputWord = "monish";
		
		String[] kw = {"amma","mmaa","anand","anaa","ishnom","hsinom"};
		List<String> knownWords = Arrays.asList(kw);
		
		Anagrammer a = new Anagrammer(knownWords);
		
		//System.out.println(a.constructHash("amma"));
		System.out.println(a.findAnagrams(inputWord));
		
	}

}
