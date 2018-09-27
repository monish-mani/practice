package leetcode;

public class Leetcode408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "hi";
		String abbr = "h2";
		
		String word2 = "monish";
		String abbr2 = "mo4";
		
		String word3 = "anand";
		String abbr3 = "5";
		
		String word4 = "sath";
		String abbr4 = "10";
		
		String word5 = "internationalization";
		String abbr5 ="i12iz4n";
//		
//		System.out.println(validWordAbbreviation4(word, abbr));
//		System.out.println(validWordAbbreviation4(word2, abbr2));
//		System.out.println(validWordAbbreviation4(word3, abbr3));
//		System.out.println(validWordAbbreviation4(word4, abbr4));
		System.out.println(validWordAbbreviation4(word5, abbr5));
		
		
		
	}

	public static boolean validWordAbbreviation1(String word, String abbr) {
		
		//a-z --> 97 - 122
		//0-9 --> 48 - 57
		int i=0;
		int j=0;
		
		while(i < word.length() && j < abbr.length()){
			StringBuilder number = new StringBuilder();
			if(abbr.charAt(j) <= 57){
				while(j < abbr.length() && abbr.charAt(j) <= 57){
					number.append(abbr.charAt(j));
					j++;
				}
				int count = Integer.parseInt(number.toString());
				i=i+count;
			}else if(word.charAt(i)!= abbr.charAt(j)){
				return false;
			}
			
			if(i == word.length() || j == word.length()){
				break;
			}
			i++;
			j++;
		}
		//Beacause of the last i++ and j++ they will be 1 more than word and abbr length
		if(i == word.length() && j == abbr.length())
			return true;
		
		return false;

	}

	
	public static boolean validWordAbbreviation(String word,String abbr){
		
		int start1=0;
		int start2=0;
		int end1 = word.length()-1;
		int end2 = abbr.length()-1;
		StringBuffer jumpCount = new StringBuffer();
		
		while(start1 <= end1 && start2 <= end2){
			while((start1 <= end1 && start2 <= end2) && word.charAt(start1) == abbr.charAt(start2)){
				start1++;
				start2++;
				
			}
			
			if (abbr.charAt(start2) <= '0' || abbr.charAt(start2) > '9') {
                return false;
            }
			//2 end scenarios - word and abbr are exactly the same and start1 = end1 && start2 = end2
			//Or you parse abbr(in case number is present at the end) till the end to get the jump count. 
			//In this case start1 = end1 + 1, start2 = end2 + 1
			
			while(start2 <= end2 && abbr.charAt(start2) >= 48 && abbr.charAt(start2) <= 57){
				jumpCount.append(abbr.charAt(start2));
				start2++;
				
			}
			start1 = start1 + Integer.parseInt(jumpCount.toString());
			jumpCount = new StringBuffer();
			
			
		}
		
		return (start1 - end1 == start2 - end2); 
	}
	
	
	public static boolean validWordAbbreviation3(String word,String abbr){
		if(word == null & abbr == null ||(word.length() == 0 && abbr.length() == 0)){
			return true;
		}
		
		int start1=0;
		int end1=word.length()-1;
		
		int start2=0;
		int end2=abbr.length()-1;
		
		//Step 1: Parse out equal characters from start and from end
		while(start1 <= end1 && start2<=end2){
			if(word.charAt(start1) == abbr.charAt(start2)){
				start1++;
				start2++;
			}else{
				break;
			}
		}
		
		while(start1 <= end1 && start2<=end2){
			if(word.charAt(end1) == abbr.charAt(end2)){
				end1--;
				end2--;
			}else{
				break;
			}
		}
		
		
		
		//In case where word and abbr are exactly the same
		if(start1==end1+1 && start2==end2+1){
			return true;
		}
		
		//Step 2: Evaluate the remaining part
		while(start2 <= end2){
			if(abbr.charAt(start2) >= 48 && abbr.charAt(start2) <= 57){
				char c = abbr.charAt(start2);
				int add=((int)c-'0');
				start1=start1 + add;
				if(start1 == end1+1 && start2==end2){
					return true;
				}else if(start1 > end1){
					return false;
				}
			}else{
				if(word.charAt(start1) == abbr.charAt(start2)){
					start1++;
				}else{
					return false;
				}
			}
			start2++;
		}
		
		
		
		return start1==end1;
	}
	
	
	public static boolean validWordAbbreviation4(String word, String abbr) {
        if(word == null && abbr == null || word.length()==0 && abbr.length()==0) return true;
        
        int i=0;
        int j=0;
        char a = 'a';
        char b = 'b';
        StringBuilder number = new StringBuilder();
        
        while(i < word.length() && j < abbr.length()){
            a = word.charAt(i);
            b = abbr.charAt(j);
            
            if(a == b){
                i++;
                j++;
            }else if(b >= '0' && b <= '9'){
                while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    number.append(abbr.charAt(j));
                    j++;
                }
                i = i + Integer.parseInt(number.toString());
                number = new StringBuilder();
            }else{
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length() ? true : false;
    
	}
	
}
