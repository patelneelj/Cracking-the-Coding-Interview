class Node
    {
        int data;
        Node next;  
        
        Node (){
        	
        }
        
        Node(int d) 
        {
        	data = d; next = null; 
        }
    }


public class Partition {
	
	Node n;
	
	
	public void printList(Node n)
    {
        Node head = n;
        while (head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
	
	public Node   CreatePartition(Node n ,int x)
	  {
	   
	   Node right = new Node();
	   Node left = new Node();
	   Node rightHead = null;
	   while(n!=null)
	   {
	      if(n.data < x)
		{
		  left.next = n;
		  left = left.next;
	   } else
	         {
	           if(right.next==null)
	           {
	        	   rightHead = n;
	           }
		right.next = n;
		right = right.next;
	         }
	    n= n.next;
	  }

	 left.next = rightHead;

	return left;
	  }

	
	public static void main(String[] args) {
		Partition rk = new Partition();
		 Node n = new Node(5);	 	
		
		Node second = new Node(3);
		Node third = new Node(9);
		Node forth = new Node(7);
		Node fifth = new Node(12);
		n.next = second; 
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		rk.printList(n);
	   Node r =  rk.CreatePartition(n , 5);
	   System.out.println();
	   rk.printList(r);
	}

}
