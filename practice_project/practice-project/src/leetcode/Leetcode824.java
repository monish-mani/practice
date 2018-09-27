package leetcode;

public class Leetcode824 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode824 lc824 = new Leetcode824();
		String S ="I speak Goat Latin";
		System.out.println(lc824.toGoatLatin(S));
	}
	
	public String toGoatLatin(String S) {
	    if(S == null || S.length() == 0) return S;
	    String[] words = S.split(" ");
	    StringBuilder result = new StringBuilder();
	    
	    for(int i=0;i<words.length;i++) {
	    	StringBuilder goatLatinWord = new StringBuilder();
	    	char firstChar = words[i].charAt(0);
	    	if(firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') {
	    		goatLatinWord.append(words[i]);
	    	}else {
	    		goatLatinWord.append(words[i].toCharArray(),1,words[i].length()-1);
	    		goatLatinWord.append(words[i].charAt(0));
	    	}
	    	goatLatinWord.append("ma");
    		goatLatinWord.append(generateA(i+1));
	    	
    		result.append(goatLatinWord);
    		if(i < words.length-1) result.append(" ");
	    }
	    
	    return result.toString();
    }
	
	
	private String generateA(int index) {
		StringBuilder aWord = new StringBuilder();
		for(int i=0;i<index;i++) {
			aWord.append("a");
		}
		
		return aWord.toString();
	}

}
