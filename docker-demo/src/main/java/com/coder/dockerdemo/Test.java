package com.coder.dockerdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kougavin on 10/09/2021.
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 100000;

        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < count; i++) {
            map.remove(i, i);
        }

        map.put(1, 3);



        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        for (int i = 0; i < count; i++) {
            list.remove(count - 1 -i);

        }

        list.add(1234);

        System.out.println(list.add(1));
    }





}
