package Queston2;

public class CustomLinkedList<T> {
	private Node head;
	private Node tail;
	
	private int size = 0;
	
	public CustomLinkedList() {
		
	}
	
	public CustomLinkedList(T data) {
		head = new Node<T>(data);
		tail = head;
		size++;
	}
	
	public void add(T data) {
		if(head == null) {
			head = new Node<T>(data);
			tail = head;
			size++;
			return;
		}
		
		Node temp = new Node<T>(data);

		tail.setNext(temp);
		
		tail = temp;	
		
		size++;
	}
	
	public Node removeNode(Node currentNode, Node previousNode) {
		previousNode.setNext(currentNode.getNext());
		size--;
		return currentNode;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node newHead) {
		head = newHead;
	}
	
	public int getSize() {
		return size;
	}
	

}
