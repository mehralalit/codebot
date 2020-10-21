package edu.lc.array;

/**
 * #1572 https://leetcode.com/problems/matrix-diagonal-sum/
 * 
 * @author Lalit Mehra
 *
 */
public class MatrixDiagonalSum {

	static class Solution {
		public int diagonalSum(int[][] mat) {
			int sum = 0;
			int size = mat.length - 1;
			for (int x = 0, y = size; x <= size; x++, y--) {
				sum += mat[x][x];

				if (x != y)
					sum += mat[x][y];
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][][] matrix = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }, 
				{ { 1, 2 }, { 2, 1 } } };

		for (int[][] mat : matrix) {
			int result = obj.diagonalSum(mat);
			System.out.println(result);
		}

	}
}
