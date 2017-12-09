package leetcode;

public class Leetcode605 {
	
	public static void main(String[] args){
		
		int[] flowerBed = {1,0,0,0,1,0,0};
		int[] flowerBed1 = {0,1,0};
		int n=1;
		System.out.println(canPlaceFlowers1(flowerBed1,n));
	}
	
	
	public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
		int nextAvailablePosition=0;
		while(nextAvailablePosition < flowerbed.length){
			if(nextAvailablePosition == 0){
				if(flowerbed[nextAvailablePosition+1] == 0){
					n--;
				}
			}
			nextAvailablePosition++;
		}
		
		
		return n == 0? true : false;
		
		
	}
	
	
	public static boolean canPlaceFlowers(int[] flowerbed,int n){
		int i,j,k;
		i=-1;
		j=1;
		k=2;
		
		while(j < flowerbed.length){
			
		}
		
		return false;
	}

}
