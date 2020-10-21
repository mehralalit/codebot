package edu.lc.string;

/**
 * #1528 https://leetcode.com/problems/shuffle-string
 * 
 * @author Lalit Mehra
 *
 */
public class ShuffleString {

	static class Solution {
		public String restoreString(String s, int[] indices) {
	        char[] c = s.toCharArray();
	        char[] result = new char[c.length];
	        
	        for(int index=0; index<c.length; index++) {
	            result[indices[index]] = c[index];
	        }
	        
	        return new String(result);
	    }

		public static void main(String args[]) {
			Solution obj = new Solution();
			int[] indices = {1, 0, 2};
			String s = obj.restoreString("art", indices);
			System.out.println(s);
		}
	}

}
