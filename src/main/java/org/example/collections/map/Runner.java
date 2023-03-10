package org.example.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Runner {

    public static void main(String[] args) {
        Map<String, String> hm = new LinkedHashMap<>();

        hm.put("USA", "Washington");
        hm.put("United Kingdom", "London");
        hm.put("India", "New Delhi");

        hm.get("USA");

        System.out.println("LinkedHashMap : " + hm);

        hm = new TreeMap<>(hm);

        hm.get("USA");

        System.out.println("TreeMap : " + hm);

        hm = new HashMap<>(hm);

        hm.get("USA");

        System.out.println("HashMap : " + hm);
    }

}
