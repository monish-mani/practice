package leetcode;

import java.util.Arrays;

public class Leetcode733 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode733 lc733 = new Leetcode733();
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] image2 = {{0,0,0},{0,1,0}};
		int[][] image3 = {{0,0,0},{0,1,1}};
		lc733.floodFill(image3, 1, 1, 1);
		System.out.println(Arrays.deepToString(image3));
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        doDFSFloodFill(image,sr,sc,oldColor,newColor);
        
        return image;
    }
    
    private void doDFSFloodFill(int[][] image, int row, int col, int oldColor, int newColor){
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) return;
        if(image[row][col] == oldColor){
            image[row][col] = newColor;
        }
        
        doDFSFloodFill(image,row,col-1,oldColor,newColor);
        doDFSFloodFill(image,row-1,col,oldColor,newColor);
        doDFSFloodFill(image,row,col+1,oldColor,newColor);
        doDFSFloodFill(image,row+1,col,oldColor,newColor);
    }

}
