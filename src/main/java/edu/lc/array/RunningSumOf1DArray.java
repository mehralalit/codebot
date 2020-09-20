package edu.lc.array;

import java.util.Arrays;

/**
 * #1480
 */
public class RunningSumOf1DArray {

	static class Solution {
		public int[] runningSum(int[] nums) {
			for (int index = 1; index < nums.length; index++) {
				nums[index] += nums[index - 1];
			}

			return nums;
		}

		public static void main(String args[]) {
			Solution obj = new Solution();
			int[] nums = {1, 1, 1, 1, 1};
			nums = obj.runningSum(nums);
			System.out.println(Arrays.toString(nums));
		}
	}

}
