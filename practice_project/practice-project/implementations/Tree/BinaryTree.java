package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
	private BinaryTreeNode root;
	
	
	
	
	public BinaryTreeNode getRoot() {
		return root;
	}




	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}



	//Constructing a tree by populating it from an array level by level
	public BinaryTree(int[] nums) {
		if(nums == null || nums.length == 0){
			System.out.println("List is null or empty");
			return;
		}
		
		int index=0;
		root = new BinaryTreeNode(nums[index++]);
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(index < nums.length){
			BinaryTreeNode temp = queue.poll();
			BinaryTreeNode leftChild = new BinaryTreeNode(nums[index++]);
			BinaryTreeNode rightChild=null;
			if(index < nums.length){
				rightChild = new BinaryTreeNode(nums[index++]);
			}
			temp.setLeft(leftChild);
			temp.setRight(rightChild);
			if(leftChild!=null){
				queue.add(leftChild);
			}
			
			if(rightChild!=null){
				queue.add(rightChild);
			}
			
		}
	
	}
	

}
