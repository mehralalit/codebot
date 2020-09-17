package edu.lc.string;

import java.util.Random;

public class ReplaceQuestionMarks {

	static class Solution {
		public String modifyString(String s) {
			if(s.length() == 1)
                if(s.equals("?"))
				    return String.valueOf((char)random());
                else 
                    return s;
			
			char[] al = s.toCharArray();
			for (int index = 0; index < al.length; index++) {
				if (al[index] != '?')
					continue;

				if (index == 0)
					al[index] = compute(al[index + 1], al[index + 1]);
				else if (index == al.length - 1)
					al[index] = compute(al[index - 1], al[index - 1]);
				else
					al[index] = compute(al[index - 1], al[index + 1]);
			}
			
			return String.valueOf(al);

		}

		private char compute(char left, char right) {
			if(left == '?')
	            left = right;
	        if(right == '?')
	            right = left;
	        
	        char res = left;
	        
	        while(res == left || res == right) {
	        	res = (char)random();
	        }
	        
	        return res;
		}

		private int random() {
			Random rnd = new Random();
			return  rnd.nextInt(25) + 'a';
		}
		
		public static void main(String[] args) {
			Solution obj = new Solution();
			String result = obj.modifyString("?");
			System.out.println(result);
		}
	}
}
