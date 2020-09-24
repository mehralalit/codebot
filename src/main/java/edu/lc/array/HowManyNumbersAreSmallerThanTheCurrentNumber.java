package edu.lc.array;

import java.util.Arrays;

/**
 * #1365
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

	static class Solution {
		public int[] smallerNumbersThanCurrent(int[] nums) {
			int[] result = new int[nums.length];
			for (int oli = 0; oli < nums.length; oli++) {
				for (int ili = 0; ili < nums.length; ili++) {
					if (nums[ili] < nums[oli]) {
						result[oli] += 1;
					}
				}
			}
			return result;
		}

		public int[] smallerNumbersThanCurrent2(int[] nums) {
			if (nums == null || nums.length == 0) {
				return new int[0];
			}

			int[] result = new int[nums.length];
			// needs 102 bucket for 0th - 101th elements because the 100th accumulated
			// result will be inserted into the 101th index to indicate how many elemets are
			// less than the digit 101
			int[] numberBucket = new int[101];

			// store the occurence of the current number to the next number to indicate how
			// many digits are smaller than the next number
			for (int i = 0; i < nums.length; ++i) {
				// example: occurence of 0 will be stored in the number one bucket, so we know
				// how many numbers are less than the number one.

				int currentNum = nums[i];

				numberBucket[currentNum + 1] += 1;
			}

			// parse the countOccurence array, and add up the previous occurence to itself
			// to make the total number of smaller digits than itself; nothing is small than
			// 0, so first element will be zero
			for (int i = 1; i < numberBucket.length; ++i) {
				// example: currently at the number two bucket, which initially has the total
				// occurence of the number one. We then add the total occurence of zero, which
				// is stored in bucket one, to bucket two, which then makes the total number of
				// digits that are less than the number two.
				numberBucket[i] += numberBucket[i - 1];
			}

			// parse original array, and find the total number of digits that are less than
			// itself from the corresponding bucket
			for (int i = 0; i < nums.length; ++i) {
				int currentNum = nums[i];
				result[i] = numberBucket[currentNum];
			}

			return result;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] nums = { { 6, 5, 4, 8 }, { 7, 7, 7, 7 } };

		for (int[] numz : nums) {
			int[] result = obj.smallerNumbersThanCurrent2(numz);
			System.out.println(Arrays.toString(result));
		}
	}

}