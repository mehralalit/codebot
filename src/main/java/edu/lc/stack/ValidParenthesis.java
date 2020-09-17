package edu.lc.stack;

import java.util.Stack;

public class ValidParenthesis {

	static class Solution {
		public boolean isValid(String s) {

			if (s.isEmpty())
				return true;

			Stack<Character> stack = new Stack<>();
			char[] alph = s.toCharArray();

			for (int index = 0; index < alph.length; index++) {
				char ele = alph[index];
				if (ele == '(' || ele == '{' || ele == '[')
					stack.push(ele);
				else {
					if (stack.isEmpty())
						return false;

					char ch = stack.pop();
					if (ele == ')' && ch != '(')
						return false;
					else if (ele == '}' && ch != '{')
						return false;
					else if (ele == ']' && ch != '[')
						return false;
				}
			}
			return stack.isEmpty();
		}
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		boolean result = obj.isValid("(){}[]");
		System.out.println(result);
	}
}