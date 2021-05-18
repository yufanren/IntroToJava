package PartIII;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class ReverseMap {

	public static Map<Object, Set<Object>> getInverted(Map<Object, Object> mp)
	{
		Map<Object, Set<Object>> invertedMap = new HashMap<>();
		for (Iterator<Map.Entry<Object, Object>> i = mp.entrySet().iterator(); i.hasNext();)
		{
			Entry<Object, Object> entry = i.next();
			if (invertedMap.containsKey(entry.getValue())) {
				invertedMap.get(entry.getValue()).add(entry.getKey());
			}
			else {
				invertedMap.put(entry.getValue(), new HashSet<Object>(Collections.singletonList(entry.getKey())));
			}
		}
		return invertedMap;
	}
	public static void main(String[] args) {
		Map<Object,Object> m = new HashMap<Object,Object>();
		m.put("Key1", new Integer(2));
		m.put("Key2", new Integer(5));
		m.put("Key4", new Integer(2));
		m.put("Key5", new Integer(8));
		m.put("Key6", new Integer(18));
		m.put("Key7", new Integer(24));
		System.out.println("hashmap is " + m);
		
		System.out.println("inverted: " + ReverseMap.getInverted(m));
		

	}

}
