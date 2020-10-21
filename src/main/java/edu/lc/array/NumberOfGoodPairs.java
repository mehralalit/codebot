package edu.lc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * #1512 https://leetcode.com/problems/number-of-good-pairs
 * 
 * @author Lalit Mehra
 */
public class NumberOfGoodPairs {

	static class Solution {
		public int numIdenticalPairs(int[] nums) {
			int goodPairs = 0;
			int count = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for (int n : nums) {
				if (map.containsKey(n)) {
					count = map.get(n);
					goodPairs += count;
					map.put(n, ++count);
				} else {
					map.put(n, 1);
				}
			}
			return goodPairs;
		}

		public int numIdenticalPairs2(int[] nums) {
			int goodPairs = 0;
			for (int oli = 0; oli < nums.length - 1; oli++) {
				for (int ili = oli + 1; ili < nums.length; ili++) {
					if (nums[oli] == nums[ili]) {
						goodPairs++;
					}
				}
			}
			return goodPairs;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = { 1, 1, 1, 1 };
		int result = obj.numIdenticalPairs(nums);
		System.out.println(result);
	}

}