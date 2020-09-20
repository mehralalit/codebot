package edu.lc.array;

import java.util.Arrays;

/**
 * #1470
 */
public class ShuffleTheArray {

	static class Solution {
		public int[] shuffle(int[] nums, int n) {
			int[] res = new int[n*2];
			int idx = 0;
			for (int index = 0; index < n; index++) {
				res[idx++] = nums[index];
				res[idx++] = nums[n+index];
			}

			return res;
		}

		public static void main(String args[]) {
			Solution obj = new Solution();
			int[] nums = {2,5,1,3,4,7};
			nums = obj.shuffle(nums, 3);
			System.out.println(Arrays.toString(nums));
		}
	}

}
