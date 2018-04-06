package leetcode;

public class Leetcode791 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "cba";
		String T = "abcd";
		
		System.out.println(customSortString(S, T));
	}
	
	
	public static String customSortString(String S, String T) {
        StringBuilder result = new StringBuilder();
        if(S == null || T == null || S.length() == 0 || T.length() == 0){
            return result.toString();
        }
        
        int[] charCount = new int[26];
        
        //Record char count for T
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            
            charCount[c - 'a']++;
        }
        
        //Parse S to build string in custom alphabet order
        for(int i=0;i<S.length();i++){
            int currCharCount = charCount[S.charAt(i) - 'a'];
            
            while(currCharCount > 0){
                result.append(S.charAt(i));
                currCharCount--;
            }
            
            charCount[S.charAt(i) - 'a']=0;
        }
        
        //Parse charCount to include characters not in the custom order
        for(int i=0;i<charCount.length;i++){
            if(charCount[i] > 0){
                while(charCount[i] > 0){
                    result.append((char)('a' + i));
                    charCount[i]--;
                }
            }
        }
        
        return result.toString();
    }

}
