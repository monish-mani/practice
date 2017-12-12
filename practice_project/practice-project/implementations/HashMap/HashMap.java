package HashMap;

import java.util.ArrayList;



public class HashMap<K,V> {
	//Implemented as an array of linked lists
	
	
	ArrayList<HashNode<K,V>> buckets;
	int numOfBuckets=20;
	
	
	/*
	 * Methods:
	 * 1. put
	 * 2. get
	 * 3. contains
	 * 4. remove
	 * 5. Traverse
	 * 
	 */
	
	
	HashMap(){
		buckets = new ArrayList<>(numOfBuckets);
		for(int i=0;i<numOfBuckets;i++){
			buckets.add(null);
		}
	}
	
	
	//Method to get the bucket in which the key falls under
	int getBucket(K key){
		return Math.abs(key.hashCode())%numOfBuckets;
		
	}
	
	
	//Get
	public V get(K key){
		int bucket = getBucket(key);
		return buckets.get(bucket).getValue();
	}
	
	//Put
	public V put(K key,V value){
		int bucket = getBucket(key);
		
		HashNode<K,V> head = buckets.get(bucket);
		HashNode<K,V> prev = head;
		if(head == null){
			//bucket is empty
			head = new HashNode(key,value);
			buckets.set(bucket, head);
		}else{
			//Traverse till the end of the list and add if its not there already
			while(head!=null){
				if(head.getKey().equals(key)){
					System.out.println("Key "+key +" exists in map. Updating value from " + head.getValue().toString() + "->" + value.toString());
					head.setValue(value);
					return head.getValue();
				}
				prev = head;
				head = head.getNext();
				
			}
			prev.setNext(new HashNode(key,value));
		}
		
		return value;
	}
	
	//Remove
	public V remove(K key,V value){
		int bucket = getBucket(key);
		
		HashNode<K,V> head = buckets.get(bucket);
		HashNode<K,V> prev =null;
		
		if(head == null){
			System.out.println("Key does not exist in map! "+ key.toString() + "->" + value.toString());
			return null;
		}else{
			while(head!=null){
				if(head.getValue().equals(value)){
					if(prev == null){
						//If value is present at the head of the list
						V returnValue = head.getValue();
						head = head.getNext();
						buckets.set(bucket, head);
						return returnValue;
					}else{
						//Value is present in the middle of the list
						V returnValue = head.getValue();
						prev.setNext(head.getNext());
						return returnValue;
					}
				}
				
				prev = head;
				head = head.getNext();
			}
		}
		
		System.out.println("Value is not preset in the map " + key.toString() + "->" + value.toString());
		return null;
	}
	
	//Contains
	public boolean contains(K key,V value){
		int bucket = getBucket(key);
		HashNode<K,V> head = buckets.get(bucket);
		if(head == null){
			System.out.println("Bucket is empty");
			return false;
		}
		
		while(head!=null){
			if(head.getKey().equals(key) && head.getValue().equals(value)){
				return true;
			}
			head = head.getNext();
		}
		
		return false;
	}
	
	//Traverse
	public void traverse(){
		StringBuilder result = new StringBuilder();
		for(int i=0;i<numOfBuckets;i++){
			HashNode<K,V> head = buckets.get(i);
			while(head!=null){
				result.append(head.getKey().toString() + " -> " + head.getValue().toString() + '\n');
				head=head.getNext();
			}
			//result.append();
		}
		
		System.out.println("Hash Map: " +'\n'+ result);
		
	}

}
