package leetcode;

public class Leetcode706 {
	int bucket_size = 10;
	ListNode[] buckets;
	
	
	Leetcode706(int bucket_size){
		this.bucket_size = bucket_size;
		buckets = new ListNode[bucket_size];
	}
	
	/** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = getBucket(key);
        ListNode head = buckets[bucket];
        
        while(head!=null) {
        	if(head.getKey() == key) {
        		head.setValue(value);
        		return;
        	}
        	head = head.getNext();
        }
        ListNode newNode = new ListNode(key,value);
        newNode.next = buckets[bucket];
        buckets[bucket] = newNode;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = getBucket(key);
        ListNode head = buckets[bucket];
        
        while(head!=null) {
        	if(head.getKey() == key) {
        		return head.getValue();
        	}
        	head = head.getNext();
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int bucket = getBucket(key);
    	ListNode head = buckets[bucket];
    	ListNode prev = null;
    	ListNode curr = head;
    	
    	while(curr!=null) {
    		if(curr.getKey() == key) {
    			if(prev == null) {
    				buckets[bucket] = curr.getNext();
    			}else {
    				prev.setNext(curr.getNext());
    				return;
    			}
    		}
    		prev = curr;
    		curr = curr.getNext();
    	}
    }
    
    private int getBucket(int key) {
    	Integer keyObject = new Integer(key);
    	int hashcode = keyObject.hashCode();
    	if(hashcode < 0) {
    		hashcode = Math.abs(hashcode);
    	}
    	
    	return hashcode % bucket_size;
    }
    
    public static void main(String[] args) {
    	Leetcode706 lc706= new Leetcode706(10);
    	lc706.remove(14);
    	System.out.println(lc706.get(4));
    	lc706.put(7,3);
    	lc706.put(11,1);
    	lc706.put(12,1);
    	System.out.println(lc706.get(7));;
    	lc706.put(1,19);
    	lc706.put(0,3);
    	lc706.put(1,8);
    	lc706.put(2,6);
    	
    	lc706.printMap();
    	
	}
    
    private void printMap() {
    	for(int i=0;i<buckets.length;i++) {
    		ListNode head = buckets[i];
    		while(head!=null) {
    			System.out.println(head.getKey() + "->" + head.getValue());
    			head = head.getNext();
    		}
    	}
    }
    
    class ListNode {
    	private int key;
    	private int value;
    	private ListNode next;
    	
    	ListNode(int key,int value){
    		this.key = key;
    		this.value = value;
    	}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
    }
	
}
