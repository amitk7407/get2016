package DS_Assignment2_Queue;

/**
 * class to check the queue operations
 */
public class CheckQueue {

	/**
	 * main method to check operations of stack
	 * @param args : command line argument
	 */
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(8);
		
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
		System.out.println();
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println("Value at front of queue : "+queue.getFront());
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println("Value at front of queue : "+queue.getFront());
		System.out.println("Value dequeued : "+queue.dequeue());
		System.out.println();
		
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
		
		queue.makeEmpty();
		System.out.println(queue.isEmpty());
		for(int index=0 ; index<queue.size() ; index++) {
			
			System.out.println("Value at index "+index+" is "+queue.get(index));
		}
	}
}