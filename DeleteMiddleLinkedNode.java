public class DeleteMiddleLinkedNode {
	Node n;
	static class Node
    {
        int data;
        Node next;
          
        
        Node(int d) 
        {
        	data = d; next = null; 
        }
    }

	
	public void deleteMiddleNode() 
	  {
	     Node head = n ; 
	     Node fast =head;
	     Node slow=head;
	     Node prev = null ; 
	    if(head!=null && head.next != null)
	    {
	       while (fast != null && fast.next!=null)
	        {
	            fast = fast.next.next ; 
	            prev = slow;
	            slow = slow.next;
	        }
	           prev.next = slow.next ;
	    }

	  }
	
	public void printList()
    {
        Node head = n;
        while (head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
	

	 public static void main(String[] args) {
		 DeleteMiddleLinkedNode dup = new DeleteMiddleLinkedNode();
		 	
		    dup.n = new Node(5);
			Node second = new Node(3);
			Node third = new Node(9);
			Node forth = new Node(7);
			Node fifth = new Node(12);
			dup.n.next = second; 
			second.next = third;
			third.next = forth;
			forth.next = fifth;
			dup.printList();
			dup.deleteMiddleNode();
			 System.out.println();
			 dup.printList();
	}

}
