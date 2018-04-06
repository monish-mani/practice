package LRUCache;

public interface CacheOperations<K,V> {
	
	public V get(K key);
	
	public void set(K key,V value);

}
