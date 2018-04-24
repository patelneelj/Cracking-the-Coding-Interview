

public class RemoveMiddleNodeWithonlyAccess {
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
	public boolean deleteNode(){
		if( n == null  || n.next == null){
		return false;
		}
		 
		n.data = n.next.data;
		n.next = n.next.next;
	
		return true;
		}

	
	
	public static void main(String[] args) {
		RemoveMiddleNodeWithonlyAccess rk = new RemoveMiddleNodeWithonlyAccess();
	 	
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
		rk.deleteNode();
		 System.out.println();
		 rk.printList();
	}

}
