package leetcode;

public class Leetcode186 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = ("mon").toCharArray();
		System.out.println(str);
		reverseWords(str);
		System.out.println(str);
	}
	
	
	public static void reverseWords(char[] str) {
        //Reverse whole array
        int start=0;
        int end=str.length-1;
        
        reverseSingleWord(str,start,end);
        
        //Reverse word by word
        int index=0;
        int lastSpace=0;
        while(index < str.length){
        	if(str[index] == ' '){
        		lastSpace=index;
        		reverseSingleWord(str,start,index-1);
        		start = index+1;
        	}
        	index++;
        }
        
        if(lastSpace!=0){
        	reverseSingleWord(str,lastSpace+1,str.length-1);
        }else{
        	reverseSingleWord(str,start,end);
        }
        
    }
    
    
    private static void reverseSingleWord(char[] str,int start,int end){
        while(start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            
            start++;
            end--;
        }
    }

}
