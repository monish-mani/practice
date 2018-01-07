package leetcode;

import java.util.Arrays;

public class Leetcode286 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms1 = {
						{2147483647,-1,0,2147483647},
						{2147483647,2147483647,2147483647,-1},
						{2147483647,-1,2147483647,-1},
						{0,-1,2147483647,2147483647}
						};	
		
		
		int[][] rooms2 = {
				{2147483647,-1},
				{2147483647,0},
				{2147483647,-1}
				};
		wallsAndGates(rooms1);
		for(int i=0;i<rooms1.length;i++){
			System.out.println(Arrays.toString(rooms1[i]));;
		}
		//System.out.println();
		
	}
	
	public static void wallsAndGates(int[][] rooms) {
        
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0){
                    distanceToNearestGate(i,j,rooms,0);
                }
            }
        }
        
    }
    
    
    
    public static void distanceToNearestGate(int i,int j,int[][]rooms,int distanceSoFar){
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distanceSoFar){
            return;
        }
        
        rooms[i][j]=distanceSoFar;
        distanceToNearestGate(i-1,j,rooms,distanceSoFar+1);
        distanceToNearestGate(i,j+1,rooms,distanceSoFar+1);
        distanceToNearestGate(i+1,j,rooms,distanceSoFar+1);
        distanceToNearestGate(i,j-1,rooms,distanceSoFar+1);
        
    }
	
	

}
