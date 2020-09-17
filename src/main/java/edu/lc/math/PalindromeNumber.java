package edu.lc.math;

public class PalindromeNumber {

	static class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;

			if (x == reverse(x))
				return true;
			else
				return false;

		}

		private int reverse(int x) {
			int num = 0;
			while (x != 0) {
				int tmp = x % 10;
				num = (num * 10) + tmp;
				x = x / 10;
			}
			return num;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		boolean result = obj.isPalindrome(121);
		System.out.println(result);
	}
}