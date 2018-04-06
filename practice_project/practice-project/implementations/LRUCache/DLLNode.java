package LRUCache;

public class DLLNode<K,V> {
	private K key;
	private V value;
	private DLLNode<K,V> next;
	private DLLNode<K,V> prev;
	
	
	public DLLNode(K key,V value){
		this.key = key;
		this.value = value;
	}


	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}


	public DLLNode<K, V> getNext() {
		return next;
	}


	public void setNext(DLLNode<K, V> next) {
		this.next = next;
	}


	public DLLNode<K, V> getPrev() {
		return prev;
	}


	public void setPrev(DLLNode<K, V> prev) {
		this.prev = prev;
	}
	
	

}
