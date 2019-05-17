package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode841 {

	public static void main(String[] args) {
		Leetcode841 lc841 = new Leetcode841();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		
		List<Integer> list0 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		list0.add(1);
		list1.add(2);
		list2.add(3);
		
		rooms.add(list0);
		rooms.add(list1);
		rooms.add(list2);
		rooms.add(list3);
		
		System.out.println(lc841.canVisitAllRooms(rooms));
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] visited = new int[rooms.size()];
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			Integer currRoom = queue.poll();
			visited[currRoom.intValue()] = 1;
			List<Integer> adjRooms = rooms.get(currRoom.intValue());
			
			adjRooms.stream().forEach(adjRoom -> {if(visited[adjRoom.intValue()]!=1) queue.offer(adjRoom);});
		}
		
		for(int i=0;i<visited.length;i++) {
			if(visited[i] == 0) {
				return false;
			}
		}
		
		return true;
	}

}
