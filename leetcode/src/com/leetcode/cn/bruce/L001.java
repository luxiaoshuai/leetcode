package com.leetcode.cn.bruce;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author bruce
 * 
 * 两数之和
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class L001 {
	public static void main(String[] args) {
		int target = 11;
		int[] nums = { 5, 3, 4, 1, 6 };
		int[] twoSum = new L001().twoSum(nums, target);

		System.out.println(twoSum[0]);
		System.out.println(twoSum[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}
	
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int res = target - nums[i];
			if (numMap.containsKey(res)) {
				return new int[] {numMap.get(res), i };
			}
			numMap.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}
}
