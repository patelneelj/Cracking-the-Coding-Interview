
class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int d) {
		data = d;
		next = null;
	}

	public String toString() {
		return "" + this.data;
	}
}

public class Sumlist {

	Node n;

	public void printList(Node n) {
		Node head = n;
		while (head != null) {
			System.out.print(head.data + " => ");
			head = head.next;
		}
		System.out.println();
	}

	public int findLength(Node n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	public Node findLongerList(Node n1, Node n2) {
		int sizeList1 = findLength(n1);
		int sizeList2 = findLength(n2);
		return sizeList1 > sizeList2 ? n1 : n2;
	}

	public Node add(Node n1, Node n2) {
		int excess = 0;
		Node longerNode = findLongerList(n1, n2);
		Node shorterNode = longerNode == n1 ? n2 : n1;
		Node result = new Node();
		Node head = result;
		int tempSum = 0;
		while (longerNode != null) {
			Node temp = new Node();
			if (shorterNode != null) {
				tempSum = longerNode.data + shorterNode.data + excess;
				shorterNode = shorterNode.next;
			} else {
				tempSum = longerNode.data + excess;
			}
			temp.data = tempSum % 10;
			result.next = temp;
			excess = tempSum / 10;
			longerNode = longerNode.next;
			result = result.next;
		}
		if (excess != 0) {
			Node temp = new Node();
			temp.data = 1;
			result.next = temp;
		}

		return head.next;
	}

	public static void main(String[] args) {
		Sumlist s = new Sumlist();
		Node n1 = new Node(7);
		Node second = new Node(1);
		Node third = new Node(8);
		Node forth = new Node(6);

		Node n2 = new Node(6);
		Node second1 = new Node(5);
		Node third1 = new Node(9);
		Node forth1 = new Node(4);

		n1.next = second;
		second.next = third;
		third.next = forth;

		n2.next = second1;
		second1.next = third1;
		third1.next = forth1;

		s.printList(n1);
		System.out.println();
		s.printList(n2);
		System.out.println();
		Node ans = s.add(n1, n2);
		s.printList(ans);
	}

}
