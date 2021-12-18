package com.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExampleCollections {
	
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<>();
		//Adding values to array
		array.add("Srujan");
		array.add(0, "Naligili");
		array.add("Kumar");
		System.out.println(array);
		
		//Remove values from array
//		array.remove(0);
		array.set(1, "Sandeep");
		System.out.println(array);
		
		Map<Integer, Object> set = new TreeMap<Integer, Object>();
		set.put(1,300);
		set.put(1, 200);
		set.put(2, 20);
		set.put(4, 30);
		set.put(3, 50);
		set.put(6, 40);
		set.put(5, 40);
		set.put(10, "Srujan");
		set.replace(10, "Sandeep");
		System.out.println(set);

		
	}

}
