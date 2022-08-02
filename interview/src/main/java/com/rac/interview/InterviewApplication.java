package com.rac.interview;

public class InterviewApplication<K, V> implements Map<K, V> {

	Entry<K, V>[] entry = new Entry[16];

	@Override
	public void put(K key, V value) {
		// used to test hash collision
		// int keyHash = 1000;
		int keyHash = key.hashCode();
		int index = (keyHash % entry.length);

		Entry<K, V> ent = entry[index];
		Entry<K, V> prev = null;
		// ent == current
		if (ent != null) {

			while (ent != null) {

				if (ent.getKey().equals(key)) {
					entry[index].setValue(value);
					break;
				} else {
					prev = ent;
					ent = ent.getNext();
				}
			}
			if (prev != null) {
				prev.setNext(new Entry(key, value, keyHash, null));
			}
		} else {
			entry[index] = new Entry(key, value, keyHash, null);
		}
	}

	@Override
	public V get(K key) {
		int keyHash = key.hashCode();
		int index = (keyHash % entry.length);
		Entry<K, V> ent = entry[index];

		if (ent != null) {

			while (ent != null) {
				if (ent.getKey().equals(key)) {
					return ent.getValue();
				} else {
					ent = ent.getNext();
				}
			}
		}

		return (V) "key not found.";
	}

	@Override
	public V remove(K key) {

		int keyHash = key.hashCode();
		int index = (keyHash % entry.length);

		Entry<K, V> ent = entry[index];
		// ent == current
		if (ent != null) {

			while (ent != null) {

				if (ent.getKey().equals(key)) {
					entry[index] = null;
					return (V) "key deleted";
				} else {
					ent = ent.getNext();
				}
			}
		}

		return (V) "Key does not exist.";
	}

	public static void main(String[] args) {
		InterviewApplication ia = new InterviewApplication();
		ia.put("aa", "AA1");
		ia.put("ab", "AB1");
		//ia.put("ab", "AB2");
		ia.put("ac", "AC");
		System.out.println(ia.get("aa"));
		System.out.println(ia.remove("aa"));
		System.out.println(ia.get("aa"));
	}

	public String hello(String name) {
		return "Hello " + name;
	}

	class Entry<K, V> {
		private K key;
		private V value;
		private int hashCode;
		private Entry<K, V> next;

		public Entry(K key, V value, int hashCode, Entry<K, V> entry) {
			this.key = key;
			this.value = value;
			this.hashCode = hashCode;
			this.next = entry;
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

		public int getHashCode() {
			return hashCode;
		}

		public void setHashCode(int hashCode) {
			this.hashCode = hashCode;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}
	}
}
