package edu.immune.codebot.queue;

public class QueueTester {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
