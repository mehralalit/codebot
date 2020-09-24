package edu.lc.array;

import java.util.Arrays;

/**
 * #896 https://leetcode.com/problems/monotonic-array/
 *
 */
public class MonotonicArray {

	static class Solution {
		public boolean isMonotonic2(int[] arr) {
			boolean monotonic = true;
			
			if(arr.length == 0 || arr.length == 1)
				return monotonic;

			int[] temp = arr.clone();
			Arrays.sort(arr);

			for (int idx = 0; idx < arr.length; idx++) {
				if (arr[idx] != temp[idx]) {
					monotonic = false;
					break;
				}
			}

			if (!monotonic) {
				monotonic = true;
				for (int l=0, r=arr.length-1; l < arr.length; l++, r--) {
					if (arr[l] != temp[r]) {
						monotonic = false;
						break;
					}
				}
			}

			return monotonic;
		}
		
		public boolean isMonotonic(int[] arr) {
			
			boolean leftM = true;
			boolean rightM = true;
			
			System.out.println(leftM + " " + rightM);
			return leftM || rightM;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] arr = { { 1, 2, 2, 3 }, { 6, 5, 4, 4 }, { 1, 3, 2 }, { 1, 2, 4, 5 }, { 1, 1, 1 } };

		for (int[] a : arr) {
			boolean result = obj.isMonotonic(a);
			System.out.println(result);
		}
	}

}
