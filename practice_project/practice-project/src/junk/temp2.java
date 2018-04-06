package junk;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class temp2 {

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
    /*
     * Complete the contacts function below.
     */
     static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        TrieNode root = new TrieNode();
        int[] result = new int[queries.length];
        int index=0;
        
        for(int i=0;i<queries.length;i++){
            String operation = queries[i][0];
            String word = queries[i][1];
            
            if(operation.equals("add")){
                root.insert(word);
                result[index++]=0;
            }else{
                result[index++]=root.getAllWordsWithPrefix(word).size();
            }
        }
        
       return result; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        
        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
	}
}
