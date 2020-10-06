package util;

public class Pair<T, V> {

	public T key;
	public V value;
	
	public Pair() {
		super();
	}

	public Pair(T key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
