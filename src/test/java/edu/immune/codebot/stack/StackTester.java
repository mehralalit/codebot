package edu.immune.codebot.stack;

public class StackTester {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(10);
		
		stack.push(1);
		stack.push(2);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(3);
		
		System.out.println(stack.peek());
		stack.push(4);
		System.out.println(stack.peek());
	}
	
}
