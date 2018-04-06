package leetcode;

public class Leetcode165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(compareVersionV2("0","1"));;
		//System.out.println(compareVersionV2("1.1","1"));;
		System.out.println(compareVersionV2("01","1"));;
		//System.out.println(compareVersionV2("1.2.3.4.5","1.2.3.4"));;
		//System.out.println(compareVersionV2("12.23","12.24"));;
		//System.out.println(compareVersionV2("0.3.4","0.6"));;
		//System.out.println(Integer.parseInt("01"));
		
	}
	
	
	public static int compareVersionV2(String version1,String version2){
		if(version1 == null && version2 == null | version1.length()==0 && version2.length() ==0) return 0;
		
		if(version1 == null || version1.length() == 0) return -1;
		if(version2 == null || version2.length() == 0) return 1;
		
		int v1Index=0;
		int v2Index=0;
		
		while(v1Index < version1.length() || v2Index < version2.length()){
			StringBuilder subVersion1 = new StringBuilder();
			while(v1Index < version1.length() && version1.charAt(v1Index)!='.'){
				subVersion1.append(version1.charAt(v1Index));
				v1Index++;
			}
			v1Index++;
			
			StringBuilder subVersion2 = new StringBuilder();
			while(v2Index < version2.length() && version2.charAt(v2Index)!='.'){
				subVersion2.append(version2.charAt(v2Index));
				v2Index++;
			}
			v2Index++;
			
			int sb1= atoi(subVersion1.toString());
			int sb2 = atoi(subVersion2.toString());
			
			if(sb1 > sb2){
				return 1;
			}else if(sb1 < sb2){
				return -1;
			}
		}
		if(v1Index > version1.length()-1 && v2Index > version2.length()-1) return 0;
		
		return v1Index > version1.length()-1 ? -1 : 1;
	}
	
	private static int atoi(String num){
		if(num == null || num.length() == 0) return 0;
		
		return Integer.parseInt(num);
		
	}

}
