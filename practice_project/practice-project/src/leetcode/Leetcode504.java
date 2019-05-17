package leetcode;

public class Leetcode504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode504 lc504 = new Leetcode504();
		System.out.println(lc504.convertToBase7(-7));
	}
	
	public String convertToBase7(int num) {
        if(num == 0) return "0";
        
        StringBuilder base7 = new StringBuilder();
        boolean negative = false;
        
        if(num < 0){
            negative = true;
            num=-num;
        }
        
        while(num > 0){
            base7.insert(0,num%7);
            num/=7;
        }
        
        if(negative){
            base7.insert(0,'-');
        }
        
        return base7.toString();
    }

}
