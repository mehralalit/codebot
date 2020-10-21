package edu.lc.array;

import java.util.Arrays;

/**
 * #1299 https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 
 * @author Lalit Mehra
 *
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

	static class Solution {
		public int[] replaceElements(int[] arr) {
			int length = arr.length;
			int max = arr[length - 1];
			for (int index = arr.length - 1; index >= 0; index--) {
				int temp = arr[index];
				arr[index] = max;
				if (temp > max) {
					max = temp;
				}
			}
			arr[length - 1] = -1;

			return arr;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = { 1, 1 };
		int[] result = obj.replaceElements(nums);
		System.out.println(Arrays.toString(result));
	}

}