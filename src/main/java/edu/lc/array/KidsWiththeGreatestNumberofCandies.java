package edu.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * #1431
 */
public class KidsWiththeGreatestNumberofCandies {

	static class Solution {
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			final List<Boolean> result = new ArrayList<>();
			int max = max(candies, extraCandies);
			for(int index=0; index<candies.length; index++) {
				if((extraCandies + candies[index]) >= max) {
					result.add(true);
				} else {
					result.add(false);
				}
			}
			
			return result;
		}

		private int max(int[] candies, int extraCandies) {
			int max = 0;
			for(int c: candies) {
				max = max>c?max:c;
			}
			
			return max;
		}
		
		public static void main(String args[]) {
			Solution obj = new Solution();
			int[] candies = {2,3,5,1,3};
			int extraCandies = 3;
			List<Boolean> result = obj.kidsWithCandies(candies, extraCandies);
			System.out.println(result);
		}
	}

}
