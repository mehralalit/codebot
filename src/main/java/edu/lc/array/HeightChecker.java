package edu.lc.array;

import java.util.Arrays;

/**
 * #1051 https://leetcode.com/problems/height-checker/
 * 
 * @author Lalit Mehra
 */
public class HeightChecker {

	static class Solution {
		public int heightChecker(int[] heights) {
			int moves = 0;
			int[] temp = heights.clone();
			Arrays.sort(temp);

			for (int idx = 0; idx < heights.length; idx++) {
				if (temp[idx] != heights[idx])
					moves++;
			}

			return moves;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] heights = { { 1, 1, 4, 2, 1, 3 }, { 5, 1, 2, 3, 4 }, { 1, 2, 3, 4, 5 }, { 2, 1, 2, 1, 1, 2, 2, 1 } };

		for (int[] h : heights) {
			int result = obj.heightChecker(h);
			System.out.println(result);
		}
	}

}