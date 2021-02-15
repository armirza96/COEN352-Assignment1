package Queston3;

public class FindingMaxValueInALinkedList {

	public static void main(String[] args) {
	    CustomLinkedList<Integer> linkedList = new CustomLinkedList<Integer>();
	    
	    linkedList.add(1);
	    linkedList.add(2);
	    linkedList.add(3);
	    linkedList.add(6);
	    linkedList.add(4);
	    linkedList.add(5);

	    int max = max(linkedList.getHead());
	     
	    if(max != 0)
	    	System.out.println("The max is: " + max);
	    else 
	    	System.out.println("List is empty");
	    
	}
	
	private static int max(Node<Integer> item) {
		if(item == null)
			return 0;
		
		int max = 0; 
		while(item != null) {
			if(item.getData() > max)
				max = item.getData();
			item = item.getNext();
		}
		
		return max;
	}

}


