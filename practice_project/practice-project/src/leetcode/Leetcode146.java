package leetcode;

import java.util.*;

public class Leetcode146 { //Implementing LRU cache
	class DLLNode{
		int key;
        int value;
        DLLNode next;
        DLLNode prev;
    
        public DLLNode(int key,int value){
        	this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer,DLLNode> keyValueMap;
    DLLNode head;
    DLLNode tail;
    int maxCapacity;
    int currentCapacity;
    

    public Leetcode146(int capacity) {
        keyValueMap = new HashMap<Integer,DLLNode>();
        maxCapacity = capacity;
        currentCapacity=0;
    }
    
    public int get(int key) {
        DLLNode node = keyValueMap.get(key);
        if(node == null) return -1;
        moveNodeToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLLNode node = keyValueMap.get(key);
        if(node == null){
            node = new DLLNode(key,value);
            addToHead(node);
        }else{
            node.value = value;
            moveNodeToHead(node);
        }
        
        if(currentCapacity == maxCapacity){
            removeLastNode();
        }else{
            currentCapacity++;
        }
        
        keyValueMap.put(key,node);
    }
    
    
    private void moveNodeToHead(DLLNode node){
        //Remove node from original pos
    	if(node == head) return;
    	if(node.prev != null){
    		node.prev.next = node.next;
    	}
        if(node.next!=null){
        	node.next.prev = node.prev;
        }else{
        	//Its the last node in the DLL
        	tail = node.prev;
        }
        
        //Add node to front of DLL
        head.prev = node;
        node.next = head;
        node.prev = null;
        
        //Set new head
        head = node;
    }
    
    private void addToHead(DLLNode node){
    	node.next = head;
		if(head!=null){
			head.prev = node;
		}
		head = node;
		if(tail == null){
			tail = node;
		}
    }
    
    
    private void removeLastNode(){
        tail = tail.prev;
        //Remove entry from keyValueMap
        keyValueMap.remove(tail.next.key);
        
        //Remove from DLL
        tail.next = null;
    }
    
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode146 cache = new Leetcode146(1);
		
		//cache.put(1,100);
		cache.put(2,200);
		
		System.out.println(cache.get(2));
		
		cache.put(3,300);
		
		System.out.println(cache.get(2));
		
		//cache.put(4,400);
		
		//System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		//System.out.println(cache.get(4));
	}

}
