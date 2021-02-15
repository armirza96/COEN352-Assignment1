package Queston3;

public class Node<T> {
	private T Data;
	private Node NextItem;
	
	public Node(T data) {
		this.Data = data;
	}
	
	public void setNext(Node n) {
		NextItem = n;
	}
	
	public Node getNext() {
		return NextItem;
	}
	
	public T getData() {
		return Data;
	}
}
