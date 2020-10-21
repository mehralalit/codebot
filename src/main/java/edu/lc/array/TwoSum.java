package edu.lc.array;

import java.util.Arrays;

/**
 * #1 https://leetcode.com/problems/two-sum
 * 
 * @author Lalit Mehra
 *
 */
public class TwoSum {
	
	static class Solution {
		public int[] twoSum(int[] nums, int target) {
			int MOD = 2047;
			int arr[] = new int[2048];
			int len = nums.length;
			for (int i = 0; i < len; i++) {
				int key = target - nums[i] & MOD;
				if (arr[key] != 0) {
					return new int[] { arr[key] - 1, i };
				}
				arr[nums[i] & MOD] = i + 1;
			}
			return null;
		}
	}
	
	static class Solution2 {
	    public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        
	        for(int j=0;j<nums.length;j++) {
	            for(int k=j+1;k<nums.length;k++) {
	                if(nums[j] + nums[k] == target) {
	                    result[0] = j;
	                    result[1] = k;
	                    break;
	                }
	            }
	        }
	        
	        return result;
	    }
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] result = obj.twoSum(new int[]{2, 11, 5, 7}, 9);
		System.out.println(Arrays.toString(result));
	}
}