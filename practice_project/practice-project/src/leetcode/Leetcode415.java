package leetcode;

public class Leetcode415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode415 lc415 = new Leetcode415();
		String num1="1";
		String num2="9";
		
		System.out.println(lc415.addStrings(num1, num2));

	}
	
	public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null) return num1;
        
        if(num1 == null || num1.length()==0) return num2;
        
        if(num2 == null || num2.length()==0) return num1;
        
        int i=num1.length()-1;
        int j=num2.length()-1;
        
        StringBuilder result = new StringBuilder();
        int carry=0;
        
        while(i >= 0 || j >= 0){
            int digit=0;
            if(i >=0){
                digit+=num1.charAt(i) - '0';
            }
            i--;
            
            if(j >=0){
                digit+=num2.charAt(j)-'0';
            }
            j--;
            
            digit+=carry;
            carry = digit >= 10 ? 1: 0;
            digit%=10;
            result.insert(0, Integer.toString(digit));
        }
        
        if(carry > 0){
            result.insert(0, Integer.toString(carry));
        }
        
        return result.toString();
    }

}
