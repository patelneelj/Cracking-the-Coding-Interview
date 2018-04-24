

public class ReturnKthFromLastLinedList {
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
	
	public void printList()
    {
        Node head = n;
        while (head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
	
	
	public Node findElements(int k) {
	     Node head = n;
	     Node runner = n;
	     for(int i = 0; i< k;i++)
	     {   
	       if(head == null)
	       {
	          return null;
	       }
	       head= head.next;
	      } 
	     
	   while(head != null)
	   {
	      head = head.next;	
	      runner = runner.next;
	   }
	return runner;
	  }

	
	
	
	public static void main(String[] args) {
		ReturnKthFromLastLinedList rk = new ReturnKthFromLastLinedList();
		 	
			rk.n = new Node(5);
			Node second = new Node(3);
			Node third = new Node(9);
			Node forth = new Node(7);
			Node fifth = new Node(12);
			rk.n.next = second; 
			second.next = third;
			third.next = forth;
			forth.next = fifth;
			rk.printList();
			Node p = rk.findElements(2);
			 System.out.println();
			System.out.println(p.data);
			 System.out.println();
			 rk.printList();
		
	}

}
