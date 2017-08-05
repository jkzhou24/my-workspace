package com.zwq.demo.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length < 2)
			return result;
		for (int i = 0; i <= nums.length - 2; i++) {
			for (int j = i+1; j <= nums.length - 1; j++) {
				System.out.println(nums[i] + "+" + nums[j]);
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
	}
	
	public static int[] twoSumMap(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    System.out.println(map.toString());
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(Solution.twoSum(new int[] { -1,-2,-3,-4,-5 }, -8)));
		Solution.twoSumMap(new int[] { -1,-2,-3,-4,-5 }, -8);
	}
}