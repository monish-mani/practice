package leetcode;

import java.util.*;
import java.util.ArrayList;

import Trie.Trie;
import Trie.TrieNode;

public class Leetcode720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = { "w", "wo", "wor", "worl", "world" };
		String[] words2 ={"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(longestWord(words2));;

	}

	public static String longestWord(String[] words) {
		String longestWord="";
		int lengthOfLongestWord=0;
		TreeSet<String> longestWords = new TreeSet<>();
		
		//Add all words from input to Trie
		Trie t = new Trie();
		for(String word : words){
			t.add(word);
		}
		
		//Iterate through all the words and keep track of the longest string.
		for(String word : words){
			int wordEndCount=0;
			
			TrieNode child = t.getRoot();
			
			int index=0;
			while(child!=null && index < word.length()){
				child = child.getChild(word.charAt(index));
				if(child.isEnd()){
					wordEndCount++;
					index++;
				}else{
					break;
				}
			}
			if(wordEndCount == word.length()){
				if(word.length() > lengthOfLongestWord){
					longestWords = new TreeSet<>();
					longestWords.add(word);
					lengthOfLongestWord = word.length();
					
				}else if(word.length() == lengthOfLongestWord){
					longestWords.add(word);
				}
				
			}
		}//End of for loop
		
		System.out.println();
		
		return longestWords.pollFirst();

	}

}
