package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V> {
	
	Map<K,DLLNode> hashMap;
	DLLNode<K,V> listHead;
	DLLNode<K,V> listTail;
	int capacity;

	
	public LRUCache(int capacity){
		hashMap = new HashMap<K,DLLNode>();
		listHead = null;
		this.capacity = capacity;
	}


	public V get(K key) {
		DLLNode<K,V> valueNode = hashMap.get(key);
		if(valueNode != null){
			moveToHead(valueNode);
			return valueNode.getValue();
		}
		return null;
	}


	public void put(K key, V value) {
		DLLNode<K,V> newValueNode = hashMap.get(key);
		if(newValueNode!=null){
			newValueNode.setValue(value);
		}else{
			newValueNode = new DLLNode<>(key,value);
			if(hashMap.size() < capacity){
				//do nothing
			}else{
				removeLastNodeFromListAndMap();
			}
		}
		addToHead(newValueNode);
		hashMap.put(key, newValueNode);
	}
	
	
	public void moveToHead(DLLNode<K,V> valueNode){
		if(valueNode.getPrev()!=null){
			valueNode.getPrev().setNext(valueNode.getNext());
		}
		
		if(valueNode.getNext()!=null){
			valueNode.getNext().setPrev(valueNode.getPrev());
		}
		if(valueNode == listTail){
			listTail = valueNode.getPrev();
		}
		
		valueNode.setNext(listHead);
		listHead = valueNode;
		
	}
	
	public void addToHead(DLLNode<K,V> newValueNode){
		newValueNode.setNext(listHead);
		if(listHead!=null){
			listHead.setPrev(newValueNode);
		}
		listHead = newValueNode;
		if(listTail == null){
			listTail = newValueNode;
		}
	}
	
	public void removeLastNodeFromListAndMap(){
		hashMap.remove(listTail.getKey());
		listTail = listTail.getPrev();
	}
	
}
