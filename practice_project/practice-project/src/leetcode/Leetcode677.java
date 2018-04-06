package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode677 {

	HashMap<String, Integer> wordMap;
	TrieNode root;

	class TrieNode {
		char c;
		int count;
		boolean isEnd;
		TrieNode[] children;

		TrieNode() {
			c = '0';
			count = 0;
			isEnd = false;
			children = new TrieNode[26];
		}

		TrieNode(char c) {
			this.c = c;
			count = 1;
			isEnd = false;
			children = new TrieNode[26];
		}

		/*
		 * Methods: insert() getAllWordsWithPrefix() isPresent getNextChild()
		 */

		public TrieNode getNextChild(char c) {
			return children[c - 'a'];
		}

		public void insert(String word) {
			boolean isWordInTrie = isPresent(word);
			if (isWordInTrie) {
				System.out.println("Word " + word + " already in trie!");
			}
			TrieNode currentNode = root;
			if (word == null || word.length() == 0) {
				System.out.println("Cant insert empty word in trie!");
				return;
			}
			int index = 0;
			while (index < word.length()) {
				TrieNode childNode = currentNode.getNextChild(word.charAt(index));
				if (childNode == null) {
					childNode = new TrieNode(word.charAt(index));
					currentNode.children[word.charAt(index) - 'a'] = childNode;
				} else {
					childNode.count++;
				}
				currentNode = childNode;
				index++;
			}
			currentNode.isEnd = true;

			return;
		}

		public boolean isPresent(String word) {
			if (word == null || word.length() == 0) {
				System.out.println("Empty word");
				return false;
			}

			int index = 0;
			TrieNode currentNode = root;
			while (index < word.length()) {
				TrieNode childNode = currentNode.getNextChild(word.charAt(index));
				if (childNode == null) {
					return false;
				}
				currentNode = childNode;
				index++;
			}
			return currentNode.isEnd;
		}

		public List<String> getAllWordsWithPrefix(String prefix) {
			List<String> allWordsWithPrefix = new ArrayList<>();
			if (prefix == null || prefix.length() == 0) {
				return allWordsWithPrefix;
			}

			int index = 0;
			TrieNode currentNode = root;
			while (index < prefix.length()) {
				TrieNode childNode = currentNode.getNextChild(prefix.charAt(index));
				if (childNode == null) {
					return allWordsWithPrefix;
				}
				currentNode = childNode;
				index++;
			}

			// Need to get all words formed with children of currentNode
			StringBuilder wordSoFar = new StringBuilder(prefix);
			allWordsWithPrefix = getAllWordsFromNode(currentNode, wordSoFar, allWordsWithPrefix);

			return allWordsWithPrefix;
		}

		private List<String> getAllWordsFromNode(TrieNode currentNode, StringBuilder wordSoFar, List<String> words) {
			if (currentNode == null) {
				return words;
			}

			if (currentNode.isEnd) {
				words.add(wordSoFar.toString());
			}

			for (int i = 0; i < currentNode.children.length; i++) {
				if (currentNode.children[i] != null) {
					wordSoFar.append(currentNode.children[i].c);
					if (currentNode.children[i].isEnd && currentNode.count < 2) {
						words.add(wordSoFar.toString());
					} else {
						getAllWordsFromNode(currentNode.children[i], wordSoFar, words);
					}
					wordSoFar.deleteCharAt(wordSoFar.length() - 1);
				}
			}

			return words;
		}

	}

	public Leetcode677() {
		wordMap = new HashMap<String, Integer>();
		root = new TrieNode();
	}

	public static void main(String[] args) {

		Leetcode677 lc677 = new Leetcode677();

		lc677.wordMap.put("apple", 3);
		lc677.wordMap.put("app", 2);
		//lc677.wordMap.put("airplane", 22);

		lc677.root.insert("apple");
		lc677.root.insert("app");
		//lc677.root.insert("airplane");

		List<String> prefixWords = lc677.root.getAllWordsWithPrefix("ap");
		int result = 0;
		for (String s : prefixWords) {
			result += lc677.wordMap.get(s);
		}

		System.out.println(result);
	}

}
