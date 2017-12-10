package Trie;

public class TrieNode {
	private char character;
	private boolean isEnd;
	private int count;
	private TrieNode[] children;
	
	
	TrieNode(char c){
		character = c;
		isEnd = false;
		count=1;
		children = new TrieNode[26];
		
		for(int i=0;i<26;i++){
			children[i] = null;
		}
	}
	
	TrieNode(){
		children = new TrieNode[26];
	}

	
	public void setChild(int index,TrieNode newChild){
		children[index] = newChild;
	}

	public TrieNode getChild(char c){
		return children[c - 'a'];
	}
	
	public char getCharacter() {
		return character;
	}


	public void setCharacter(char character) {
		this.character = character;
	}


	public boolean isEnd() {
		return isEnd;
	}


	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public TrieNode[] getChildren() {
		return children;
	}


	public void setChildren(TrieNode[] children) {
		this.children = children;
	}
	
	

}
