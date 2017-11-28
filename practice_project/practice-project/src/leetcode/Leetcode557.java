package leetcode;

public class Leetcode557 {
	
	public static void main(String args[]){
		
		String s="Let's take LeetCode contest";
		String s1="god is late";
		System.out.println(reverseWords(s));
		
	}
	
	//god is late
	//etal si dog
	//late is god
	
	public static String reverseWords(String s) {
        //String reversedSentence = reverseSingleWord(s,0,s.length()-1);
        int start=0;
        int end=0;
        
        StringBuilder result = new StringBuilder();
        
        while(end <= s.length()-1){
        	if(s.charAt(end)==' '){
        		result.append(reverseSingleWord(s,start,end-1));
        		result.append(s.charAt(end));
        		start=++end;
        	}else{
        		end++;
        	}
        	
        }
        
        result.append(reverseSingleWord(s,start,end-1));
        
        return result.toString();
        
    }
    
    //Utility function not needed
    public static String reverseSingleWord(String s,int start,int end){
        StringBuilder result = new StringBuilder();
        for(int i=end;i>=start;i--){
            result.append(s.charAt(i));
        }
        return result.toString();
        
    }

}
