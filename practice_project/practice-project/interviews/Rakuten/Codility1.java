package Rakuten;

public class Codility1 {
	
	public static void main(String[] args){
		System.out.println(solution(-4,11342345,213223454,623452123,0,-1,412234,31324));
		
	}
	
	public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {

        
        // write your code in Java SE 8
        
        //Rectangle 1
        int height1 = N - L; //-->Check
        int length1 = M - K;
        long area1 = length1 * height1;
        
        
        
        //Rectangle 2
        int height2 = S - Q;
        int length2 = R - P;
        long area2 = length2 * height2;
        
        
        
        //Find out if there is intersection
        //Coordinates of overlapping rectangle(if it exists)
        int x1 = Math.max(K,P);
        int y1 = Math.max(Q,L);
        int x2 = Math.min(R,M);
        int y2 = Math.min(N,S);
        
        long overlapArea=0;
        if(x2 > x1 && y2 > y1){
            overlapArea = (x2- x1) * (y2 - y1);
        }
        
        long resultantArea = area1 + area2 - overlapArea;
        if(resultantArea > Integer.MAX_VALUE){
            return -1;
        }
        return (int)resultantArea;
    
	}
    
    
    public boolean isCornerContained(int a,int b,int x1,int x2,int y1,int y2){
        if(a >= x1 && a <= x2 && b >= y1 && b <= y2){
            return true;
        }
        
        return false;
        
    }    

}
