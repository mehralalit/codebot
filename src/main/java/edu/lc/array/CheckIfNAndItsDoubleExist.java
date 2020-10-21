package edu.lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * #1346 https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * 
 * @author Lalit Mehra
 *
 */
public class CheckIfNAndItsDoubleExist {

	static class Solution {
		public boolean checkIfExist(int[] arr) {
			Set<Integer> set = new HashSet<>();
			boolean result = false;
			for (int ele : arr) {
				if (set.contains(ele * 2) || (ele % 2 == 0 && set.contains(ele / 2))) {
					result = true;
					break;
				} else {
					set.add(ele);
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] nums = { { 10, 2, 5, 3 }, { 7, 1, 14, 11 }, { 3, 1, 7, 11 } };

		for (int[] numz : nums) {
			boolean result = obj.checkIfExist(numz);
			System.out.println(result);
		}
	}

}