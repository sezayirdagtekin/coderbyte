package com.sezayir;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class LRUAlgorithm {

	public static void main(String[] args) {
		// keep this function call here
		String[] arr = new String[] { "A", "B", "A", "C", "A", "B" };
		System.out.println(ArrayChallenge(arr));
	}

	public static String ArrayChallenge(String[] strArr) {
		LRUCache cache = new LRUCache();
		for (String element : strArr) {
			cache.put(element, element);
		}

		return LRUCache.queue.stream().collect(Collectors.joining(" "));
	}
}

class LRUCache {
	private static final int CAPACITY = 5;
	static Deque<String> queue = new LinkedList<>();
	static Map<String, Cache<String, String>> cacheMap = new HashMap<>();

	public void put(String key, String value) {
		if (cacheMap.containsKey(key)) {
			Cache<String, String> current = cacheMap.get(key);
			queue.remove(current.key);
		} else {
			if (queue.size() == CAPACITY) {
				String lastElement = queue.removeFirst();
				cacheMap.remove(lastElement);
			}
		}
		Cache<String, String> cacheItem = new Cache<>(key, value);
		queue.addFirst(cacheItem.key);
		cacheMap.put(key, cacheItem);
	}

	class Cache<K, V> {
		K key;
		V value;

		Cache(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}