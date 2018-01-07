package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {
	
	public static void prettyPrint(BinaryTreeNode root){
		int levels = getHeight(root);
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int currentLevel=1;
		
		StringBuilder currentLevelElements = new StringBuilder();
		while(!queue.isEmpty()){
			BinaryTreeNode temp = queue.poll();
			if(temp!=null){
				currentLevelElements.append(temp.getVal() + "   ");
				
				if(temp.getLeft()!=null){
					queue.add(temp.getLeft());
				}
				
				if(temp.getRight()!=null){
					queue.add(temp.getRight());
				}
			}else{
				if(queue.peek()!=null){
					queue.add(null);
					int spaceCount = (int) (Math.pow(2, levels) - Math.pow(2, currentLevel));
					for(int i=0;i<spaceCount/2;i++){
						currentLevelElements.insert(0, ' ');
						currentLevelElements.append(" ");
					}
					System.out.println(currentLevelElements.toString());
					System.out.println();
					currentLevel++;
					currentLevelElements = new StringBuilder();
				}
				
			}
			
		}
		
		System.out.println(currentLevelElements.toString());
		
	}
	
	public static void normalPrint(BinaryTreeNode root){
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
         List<Integer> currentLevel = new ArrayList<>();
        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();
            if(temp!=null){
                currentLevel.add(temp.getVal());
                
                if(temp.getLeft()!=null){
                queue.offer(temp.getLeft());
                }
            
                if(temp.getRight()!=null){
                queue.offer(temp.getRight());
                }
            }else{
                if(queue.peek()!=null){
                    queue.offer(null);
                    currentLevel.stream().forEach(i -> System.out.print(i));
                    currentLevel = new ArrayList<>();
                    System.out.println();
                }
            }
            
        }
        currentLevel.stream().forEach(i -> System.out.print(i));
	}
	
	
	public static int getHeight(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = getHeight(root.getLeft());
		int right = getHeight(root.getRight());
		
		return Math.max(left, right) + 1;
		
	}

}
