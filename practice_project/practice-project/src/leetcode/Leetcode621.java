package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode621 {

	public static void main(String[] args) {
		Leetcode621 lc621 = new Leetcode621();
		
		char[] tasks = {'A','A','B','B','B','B'};
		
		int n=2;
		
		System.out.println(lc621.leastInterval(tasks, n));
		System.out.println(Long.MAX_VALUE);
	}

	public int leastInterval(char[] tasks, int n) {
		int[] taskCount = new int[26];
		
		for(int i=0;i<tasks.length;i++) {
			taskCount[tasks[i] - 'A']++;
		}
		
		Queue<Character> taskQueue = new LinkedList<>();
		
		int totalIntervaltime=0;
		int intervalClock=0;
		Character prevTask=null;
		
		while(!taskQueue.isEmpty()) {
			Character currTask = taskQueue.poll();
			
			if(prevTask == null || currTask.charValue()!=prevTask.charValue()) {
				
			}
		}
		

		return 0;
	}

}
