package implementation;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1); s.push(2); s.print(); // print 2 1
		System.out.println(s.pop()); // print 2
		System.out.println(s.peek()); // print 1
		System.out.println(s.isEmpty()); // false
		s.pop(); System.out.println(s.isEmpty()); //true
	}
}
