package Queston2;

import java.util.LinkedList;

public class DeletingKthElementInALinkedList {

	public static void main(String[] args) {
	    CustomLinkedList linkedList = new CustomLinkedList<String>();
	    
	    linkedList.add("Abdul");
	    linkedList.add("Bryan");
	    linkedList.add("Catherine");
	    linkedList.add("Elvis");
	    linkedList.add("Gloria");
	    
	    // Node deletedNode = deleteStudent(linkedList, "Abdul"); // node exists
	    //Node deletedNode = deleteStudent(linkedList, "Charles"); // node doesnt exist
	    Node deletedNode = deleteStudent(linkedList, 1); // will delete bryan
	     
	    if(deletedNode != null)
	    	System.out.println("Deleted Node: " + deletedNode.getData());
	    else 
	    	System.out.println("Node does not exist");
	    
	    Node currentNode = linkedList.getHead();
	    
		while(currentNode != null) {
			System.out.println("Node: " + currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
	
	private static Node deleteStudent(CustomLinkedList<String> students, int k) {
		Node currentNode = students.getHead();
		Node previousNode = null;
		
		/* this if statement could technically be removed and let the codes executon get to the for loop
		 * at k ==0 the for loop would never excute and the method returns null
		 * at k > linkedList.size the for loop will continue until its exhasuted. it will return null as well
		 */
		if (k > students.getSize() || k == 0) {
			return null;
		} else if (k == 1) {
			students.setHead(currentNode.getNext());
			return currentNode;
		} else {
			for(int i = 1; i <= students.getSize(); i++) {
				
				if(i != k) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				} else {
					previousNode.setNext(currentNode.getNext());
					return currentNode;
				}
			}	
		}
		
		return null;
	}

	private static Node deleteStudent(CustomLinkedList<String> students, String name) {
		Node currentNode = students.getHead();
		Node previousNode = null;
		
		if(currentNode != null && currentNode.getData().equals(name)) {
			students.setHead(currentNode.getNext());
		} else {
			while(currentNode != null) {
				if(currentNode.getData().equals(name)) {
					return students.removeNode(currentNode, previousNode);
				} else {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
		
		return null;
	}
}
