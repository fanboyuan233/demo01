package com.czxy.controller;

import java.util.Set;
import java.util.TreeMap;

public class democ1 {
    public static void main(String[] args) {

        TreeMap<String,String>map =new TreeMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("key="+key+",value="+map.get(key));
        }
    }
}
