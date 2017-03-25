package implementation;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.push(1);
		q.push(2);
		q.print(); // print 1 2
		System.out.println(q.pop()); // print 1
		System.out.println(q.peek()); // print 2
		System.out.println(q.isEmpty()); // false
		q.pop();
		System.out.println(q.isEmpty()); // true
	}
}
