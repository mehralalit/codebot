package edu.lc.string;

public class LongestCommonPrefix {

	static class Solution {
		public String longestCommonPrefix(String[] strs) {

			if (strs.length == 0)
				return "";

			int smallestStrLength = Integer.MAX_VALUE;
			for (int index = 0; index < strs.length; index++) {
				if (smallestStrLength > strs[index].length()) {
					smallestStrLength = strs[index].length();
				}
			}

			int endIndex = 0;
			boolean flag = true;
			for (int i = 0; i < smallestStrLength; i++) {
				for (int j = 1; j < strs.length; j++) {
					if (strs[0].charAt(i) != strs[j].charAt(i)) {
						flag = false;
						break;
					}
				}
				if (flag)
					endIndex++;
				else
					break;
			}

			if (endIndex == 0)
				return "";
			else
				return strs[0].substring(0, endIndex);
		}
	}

	static class Solution2 {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0)
				return "";
			String prefix = strs[0];
			for (int i = 1; i < strs.length; i++)
				while (strs[i].indexOf(prefix) != 0) {
					prefix = prefix.substring(0, prefix.length() - 1);
					if (prefix.isEmpty())
						return "";
				}
			return prefix;
		}
	}

	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		String[] strs = { "flower", "flow", "flight" };
		String result = obj.longestCommonPrefix(strs);
		System.out.println(result);
	}
}