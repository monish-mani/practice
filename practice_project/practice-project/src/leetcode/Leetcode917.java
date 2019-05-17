package leetcode;

public class Leetcode917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode917 lc917 = new Leetcode917();
		String S = "a-bC-dEf-ghIj";
		System.out.println(lc917.reverseOnlyLetters(S));
	}
	
	public String reverseOnlyLetters(String S) {
        char[] reversedString = new char[S.length()];
        
        for(int i=0;i<S.length();i++){
            if(isAlphabet(S.charAt(i))){
            	System.out.println(S.length());
            	System.out.println(reversedString.length);
            	System.out.println(S.length()-i-1);
                reversedString[S.length()-i-1] = S.charAt(i);
            }else{
                reversedString[i] = S.charAt(i);
            }
        }
        
        return new String(reversedString);
    }
    
    private boolean isAlphabet(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z');
    }

}
