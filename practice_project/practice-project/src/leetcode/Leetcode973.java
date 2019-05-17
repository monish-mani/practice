package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode973 {
	
	
	public static void main(String[] args) {
		Leetcode973 lc973 = new Leetcode973();
		int[][] points = {{1,2},
							{3,3},
							{2,2},
							{0,0}};
		
		int[][] result = lc973.getKClosestPoints(points,2);
		System.out.println(Arrays.deepToString(result));
	}
	
	
	int[][] getKClosestPoints(int[][] points, int K) {
		if(points.length < K) {
			return points;
		}
		
		int[][] result = new int[K][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (int)(Math.ceil(getDistanceFromOrigin(b[0],b[1]) - getDistanceFromOrigin(a[0],a[1]))));
		
		for(int i=0;i<points.length;i++) {
			if(pq.size() < K) {
				pq.add(points[i]);
			}else {
				double currDistance = getDistanceFromOrigin(points[i][0],points[i][1]);
				int[] root = pq.peek();
				double rootDistance = getDistanceFromOrigin(root[0],root[1]);
				
				if(currDistance < rootDistance) {
					pq.poll();
					pq.add(points[i]);
				}
			}
		}
		
		int k=0;
		while(pq.size() > 0) {
			result[k++] = pq.poll();
		}
		return result;
	}
	
	private double getDistanceFromOrigin(int x,int y) {
		int total = (x*x) + (y*y);
		double distance = Math.sqrt(total);
		System.out.println("Distance form origin " + distance);
		return distance;
	}

}
