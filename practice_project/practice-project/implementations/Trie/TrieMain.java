package Trie;

public class TrieMain {
	
	public static void main(String[] args){
		
		Trie t = new Trie();
//		t.add("monish");
//		t.add("anand");
//		t.add("amma");
//		t.add("christie");
//		t.add("ananda");
		
//		System.out.println(t.contains("monish"));;
//		System.out.println(t.contains("moni"));;
//		System.out.println(t.contains("m"));;
//		System.out.println(t.contains("mo"));;
		
//		t.remove("monish");
//		System.out.println(t.contains("monish"));;
		
//		t.remove("ana");
//		t.remove("ananda");
//		
//		System.out.println(t.contains("anand"));;
		
		t.add("abc");
		t.add("bcf");
		String result="";
		System.out.println(t.traverseTrieNode(t.root, result));;
	}

}
