//@author David Panagiotopulos and Larissa Wagnerberger

public class Node<T> {
	T data;
	Node<T> next;

	public Node(T t, Node next) {
		data = t;
		this.next = next;
	}

}
