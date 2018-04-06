package leetcode;

public class Leetcode434 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "Of all world,   ";
		System.out.println(countSegments(S));;
	}
	
	
	public static int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int count=0;
        int i=0;
        
        String trimmedString = trimString(s.toCharArray());
        
        if(trimmedString.length() == 0) return 0;
        
        while(i < trimmedString.length()){
            if(trimmedString.charAt(i) ==' '){
                count++;
            }
            i++;
        }
        
        
        return count+1;
    }
    
    //Remove leading and trailing spaces and make multiple middle spaces as 1
    private static String trimString(char[] str){
        int n = str.length;
    	int i=0;
    	int j=0;
    	
    	while (j < n) {
			while (j < n && str[j] == ' ')
				j++; // skip spaces
			while (j < n && str[j] != ' ')
				str[i++] = str[j++]; // keep non spaces
			while (j < n && str[j] == ' ')
				j++; // skip spaces
			if (j < n)
				str[i++] = ' '; // keep only one space
		}
        
    	return new String(str).substring(0,i);
        
    	
    }

}
