package paypal;

import java.util.Arrays;

public class Hackerrank {
	
	public static void main(String[] args){
		String[] a = {"tea","tea","act"};
		String[] b = {"ate","toe","acts"};
		
		
		String[] a1 = {"tea","tea","act"};
		String[] b1 = {"ate","toe","acts"};
		
		System.out.println(Arrays.toString(getMinimumDifference(a,b)));
		}
	
	
	static int[] getMinimumDifference(String[] a, String[] b) {
        int[] result = new int[a.length];
        
        for(int i=0;i<a.length;i++){
            if(Math.abs(a[i].length() - b[i].length()) > 0){
                result[i] = -1;
                continue;
            }
            int[] charMap = new int[26];
            //Add 1 to position for characters in word 1 
            //Add -1 to position for characters in word 2
            for(int j=0;j<a[i].length();j++){
                charMap[a[i].charAt(j) - 'a']+=1;
            }
            
            for(int j=0;j<b[i].length();j++){
                charMap[b[i].charAt(j) - 'a']-=1;
            }
            
            int aExtraCharCount=0;
            int bExtraCharCount=0;
            for(int j=0;j<charMap.length;j++){
                if(charMap[j] > 0){
                    aExtraCharCount+=charMap[j];
                }else{
                    bExtraCharCount+=charMap[j];
                }
            }
            
            if(aExtraCharCount + bExtraCharCount == 0){
                result[i] = aExtraCharCount;
            }else{
                result[i] = -1;
            }
        }
        
        return result;

    }

}
