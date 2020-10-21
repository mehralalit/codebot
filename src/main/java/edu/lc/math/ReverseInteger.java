package edu.lc.math;

/**
 * #7 https://leetcode.com/problems/reverse-integer/
 * 
 * @author Lalit Mehra
 *
 */
public class ReverseInteger {

	static class Solution {
		public int reverse(Integer x) {
			int y = Math.abs(x);
			int res = 0;
			while (y > 0) {
				if (res > Integer.MAX_VALUE / 10) {
					return 0;
				}
				res = res * 10;
				res = res + (y % 10);
				y = y / 10;
			}
			return (x > 0 ? res : -res);
		}
	}

	static class Solution2 {
		public int reverse(int y) {

			int revNum = 0;
			int x = Math.abs(y);

			while (x > 0) {
				if (revNum > Integer.MAX_VALUE / 10) {
					return 0;
				}
				revNum = (revNum * 10) + x % 10;
				x = x / 10;
			}

			return (y<0)?-revNum:revNum;

		}
	}

	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		int result = obj.reverse(-123);
		System.out.println(result);
	}
}