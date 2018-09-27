package leetcode;

public class Leetcode409 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode409 lc409 = new Leetcode409();
		String s= "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		
		System.out.println(lc409.longestPalindrome(s));
	}
	
	public int longestPalindrome(String s) {
        int[] charCount = new int[256];
        int result=0;   //Longest Palindrome result
        
        if(s == null || s.length() == 0) return 0;
        
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)]++;
        }
        
        for(int i=0;i<charCount.length;i++){
            if(charCount[i]%2==0){
                result+=charCount[i];
            }else{
                result+=charCount[i]-1;
            }
        }
        
        return result == s.length() ? result : result+1;
    }

}
