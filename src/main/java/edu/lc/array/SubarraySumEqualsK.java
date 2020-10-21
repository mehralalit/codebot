package edu.lc.array;

/**
 * #560 https://leetcode.com/problems/subarray-sum-equals-k
 * 
 * @author Lalit Mehra
 *
 */
public class SubarraySumEqualsK {

	static class Solution {
	    public int subarraySum(int[] nums, int k) {
	        return subarray(nums, 0, 0, k, 0);
	    }
	    
	    private int subarray(int[] nums, int start, int end, int k, int count) {        
	        if(nums.length == end)
	            return count;
	        else if(start>end)
	            count = subarray(nums, 0, end+1, k, count);
	        else {
	            int sum = 0;
	            for(int idx=start;idx<end;idx++) {
	                sum += nums[idx];
	            }
	            sum += nums[end];
	            if(sum==k)
	                count++;
	            count = subarray(nums, start+1, end, k, count);
	        }
	        return count;
	    }
	}
	
	public static void main(String args[]) {
		int[] arr = { 1, 1, 1 };
		Solution obj = new Solution();
		System.out.println(obj.subarraySum(arr, 2));
	}
}
