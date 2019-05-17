package zillow2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MovieRatingOrder {
	
	
	public static void main(String[] args) {
		String[][] pairs = {{"undershorts","pants"},
							{"pants","belt"},
							{"belt","jacket"},
							{"shirt","belt"},
							{"shirt","tie"},
							{"pants","shoes"},
							{"undershorts","shoes"},
							{"socks","shoes"},
							{"tie","jacket"}};
		
		MovieRatingOrder obj = new MovieRatingOrder();
		List<String> result = obj.arrangeMovies(pairs);
	}
	
	
	private List<String> arrangeMovies(String[][] pairs){
		
		
		Map<String,Integer> moviesById = new HashMap<>();
		int id=0;
		
		for(int i=0;i<pairs.length;i++) {
			for(int j=0;j<pairs[i].length;j++) {
				Integer movieId = moviesById.get(pairs[i][j]);
				if(movieId == null) {
					moviesById.put(pairs[i][j],id++);
				}
			}
		}
		
		List<List<Integer>> adjList = createAdjList(moviesById,pairs);
		
		List<Integer> result = topologicalSort(adjList);
		
		System.out.println(result);
		return null;
	}
	
	
	private List<List<Integer>> createAdjList(Map<String,Integer> moviesById, String[][] pairs){
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		for(int i=0;i<moviesById.keySet().size();i++) {
			adjList.add(new ArrayList<>());
		}
		System.out.println(moviesById);
		
		for(String[] pair : pairs) {
			int u = moviesById.get(pair[0]);
			int v = moviesById.get(pair[1]);
			
			
			
			List<Integer> uAdjList = adjList.get(u);
			
			uAdjList.add(v);
		}
		
		return adjList;
	}
	
	private List<Integer> topologicalSort(List<List<Integer>> adjList){
		int[] visited = new int[adjList.size()];
		
		List<Integer> result = new LinkedList<>();
		doDFS(adjList,visited,result);
		
		return result;
	}
	
	private void doDFS(List<List<Integer>> adjList,int[] visited,List<Integer> result) {
		for(int i=0;i<visited.length;i++) {
			if(visited[i] == 0) {
				dfs(i,adjList,visited,result);
			}
		}
	}
	
	private void dfs(int source,List<List<Integer>> adjList,int[] visited,List<Integer> result) {
		visited[source] = 1;
		
		for(Integer neighbor : adjList.get(source)) {
			if(visited[neighbor] == 0) {
				dfs(neighbor,adjList,visited,result);
			}
		}
		
		visited[source] = 2;
		result.add(0, source);
	}

}
