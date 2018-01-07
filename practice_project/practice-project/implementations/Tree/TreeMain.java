package Tree;

public class TreeMain {
	
	public static void main(String[] args){
		int[] nums1 = {1,2,3,4,5,6,7,8,9,10};
		int[] nums2 = {1,2,3,4,5};
		
		BinaryTree t = new BinaryTree(nums1);
		System.out.println();
		System.out.println("Normal Print");
		TreeUtils.normalPrint(t.getRoot());
		System.out.println();
		System.out.println("Pretty Print");
		TreeUtils.prettyPrint(t.getRoot());
	}

}
