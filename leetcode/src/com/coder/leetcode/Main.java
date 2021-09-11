package com.coder.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by kougavin on 04/09/2021.
 */
public class Main {
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.getOrDefault(target - nums[i], i);

            if (index != i) {
                return new int[]{index, i};
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Integer[] indexs = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs, Comparator.comparingInt(i -> nums[i]));

        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(nums, indexs, i, target);

            if (index != i) {
                return new int[]{index, i};
            }
        }
        return null;
    }

    private int binarySearch(int[] nums, Integer[] indexs, int i, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[indexs[mid]] == target - nums[i]) {
                return indexs[mid];
            } else if (nums[indexs[mid]] < target - nums[i]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return i;
    }


    public int[] twoSum3(int[] nums, int target) {
        if(nums.length==2) return new int[]{0,1};
        int n = nums.length;
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                if(nums[j]+nums[j-i]==target) return new int[]{j,j-i};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.twoSum(new int[]{3, 2, 4}, 6);
    }


}
