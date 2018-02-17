
public class RemoveDuplicateLinkedList {

	Node head;  // head of list
	 
    /* Node Class */
    static class Node
    {
        int data;
        Node next;
          
        
        Node(int d) 
        {
        	data = d; next = null; 
        }
    }
    public void removeDups()
	{
	//Node head = n;
	Node current  = head;
	while( current  != null)
	  { 
	     Node runner = current;
	    while(runner.next != null)
	    {
	    	 if(runner.next.data== current.data)
	   		 {
	    		 runner.next = runner.next.next ;
	    	 }
	    	 else
	    	 {
	    		 runner = runner.next ;
	    	 }
	     }
	    current = current.next;
	  }
	}
	
	public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
    
	 public static void main(String[] args) {
		 RemoveDuplicateLinkedList llist = new RemoveDuplicateLinkedList();
		 	
			llist.head = new Node(5);
			Node second = new Node(5);
			Node third = new Node(5);
			Node forth = new Node(7);
			llist.head.next = second; 
			second.next = third;
			third.next = forth;
			 llist.printList();
			 llist.removeDups();
			 System.out.println();
			 llist.printList();
	}
	 

}
