package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	Set<GraphNode> nodes;

	
	public Graph(){
		nodes = new HashSet<>();
	}
	
	
	
	public Set<GraphNode> getNodes() {
		return nodes;
	}



	public void setNodes(Set<GraphNode> nodes) {
		this.nodes = nodes;
	}



	public void addNode(GraphNode g){
		if(nodes.contains(g)){
			System.out.println("Node with id " + g.id + " is already present in graph");
		}
		nodes.add(g);
	}
	
	
	public GraphNode getNodeWithId(int nodeId){
		for(GraphNode node : nodes){
			if(node.id == nodeId) return node;
		}
		
		return null;
	}
	
	public void addAdjacentNodesToGraphNode(int id,List<Integer> adjacentNodeIds){
		GraphNode node = getNodeWithId(id);
		if(node!=null){
			for(Integer adjacentNodeId : adjacentNodeIds){
				GraphNode adjacentNode = getNodeWithId(adjacentNodeId);
				if(adjacentNode==null){
					adjacentNode = new GraphNode(adjacentNodeId);
					addNode(adjacentNode);
				}
				node.adjacencyList.add(adjacentNode);
			}

		}
	}
	
	public void printAllGraphNodeIds(){
		nodes.stream().forEach(node -> System.out.print(" Node id :" + node.id + " "));
		System.out.println();
	}
}
