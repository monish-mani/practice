package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	TrieNode root;

	
	
	public Trie(){
		root = new TrieNode();
	}
	
	
	
	/*
	 * Methods:
	 * 1) contains
	 * 2) Delete word
	 * 3) Traverse(print all words)
	 */
	
	
	public TrieNode getRoot() {
		return root;
	}



	public void setRoot(TrieNode root) {
		this.root = root;
	}



	//Contains
	public boolean contains(String word){
		if(word == null || word.length()==0){
			System.out.println("Not a valid word. Null or size is 0");
			return false;
		}
		
		TrieNode child = root;
		
		int index=0;
		while(child!=null && index < word.length()){
			child = child.getChild(word.charAt(index));
			if(child == null){
				return false;
			}
			index++;
		}
		
		return child.isEnd();
	}
	
	
	//Adding word to dictionary
	public String add(String word){
		if(word == null || word.length()==0){
			System.out.println("Not a valid word. Null or size is 0");
			return word;
		}
		
		boolean isPresent = contains(word);
		if(isPresent){
			System.out.println("Word " + word + " is alreday preset in dictionary!");
			return word;
		}
		
		TrieNode parent = root;
		TrieNode child;
		int index=0;
		while(index < word.length()){
			child = parent.getChild(word.charAt(index));
			if(child == null){
				child = new TrieNode(word.charAt(index));
				parent.setChild(word.charAt(index) - 'a', child);
			}else{
				child.setCount(child.getCount()+1);
			}
			parent = child;
			index++;
		}
		
		parent.setEnd(true);
		System.out.println("Word " + word + " is added to dictionary!");
		return word;
	}
	
	
	//Remove word from dictionary
	public String remove(String word){
		if(word == null || word.length()==0){
			System.out.println("Not a valid word. Null or size is 0");
			return word;
		}
		
		boolean isPresent = contains(word);
		if(!isPresent){
			System.out.println("Word " + word + " is not present in dictionary.");
			return null;
		}
		
		int index=0;
		TrieNode parent = root;
		TrieNode child = root;
		while(index < word.length()){
			child = parent.getChild(word.charAt(index));
			if(child!=null && child.getCount() == 1){
				parent.setChild(word.charAt(index) - 'a', null);
				System.out.println(word + " is removed from dictionary.");
				return word;
			}else{
				child.setCount(child.getCount()-1);
			}
			parent = child;
			index++;
		}
		child.setEnd(false);
		System.out.println(word + " is removed from dictionary.");
		return word;
	}
	
	//Prints all the words in the dictionary(NOT YET DONE. WORK IN PROGRESS!)
	public void traverse(){
		List<String> listOfWords = new ArrayList<>();
		StringBuilder wordHolder = new StringBuilder();
		
		//Parse all of the children of root to get words by starting letter alphabetically
		TrieNode[] rootChildren = root.getChildren();
		for(int i=0;i<rootChildren.length;i++){
			TrieNode child;
			if(rootChildren[i]!=null){
				child = rootChildren[i];
				while(child!=null){
					wordHolder.append(child.getCharacter());
					if(child.isEnd()){
						//Add word to list of words
						listOfWords.add(wordHolder.toString());
					}
					
				}
			}
		}
	}
	
	//(NOT YET DONE. WORK IN PROGRESS!)
	public String traverseTrieNode(TrieNode root,String result){
		if(root == null){
			return result;
		}
		
		StringBuilder temp = new StringBuilder(result);
		temp.append(root.getCharacter());
		for(TrieNode c : root.getChildren()){
			if(c!=null){
				temp.append(traverseTrieNode(c,temp.toString()));
				temp.append(",");
			}
		}
		
		return temp.toString();
	}
}
