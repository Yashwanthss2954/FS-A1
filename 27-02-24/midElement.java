given a singly LinkedList, find its middle element.
For example, if our input LinkedList is 1->2->3->4->5,
then the output should be 3.

Example 1:
input = 1 2 3 4 5 6 7 8 9
output= 5

Example 2:
input=20 50 60 70 80 90 100 200 110 120 130
output=90


import java.io.*;
import java.util.*;
class MiddleOftheLinkedList {
    Node head; 
 
    // Linked list node 
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    // Function to print the middle element of the linked list 
    void printMiddle()
    {
        //WRITE CODE HERE
    }
 
    // Inserts a new Node at front of the list. 
    public void push(int new_data)
    {
        // 1 & 2: Allocate the Node & Put in the data
        Node new_node = new Node(new_data);
 
        // 3. Make next of new Node as head 
        new_node.next = head;
 
        // 4. Move the head to point to the new Node 
        head = new_node;
    }
 
    // This function prints the contents of the linked list starting from  the given node     
	public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
 
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar= new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		MiddleOftheLinkedList llist = new MiddleOftheLinkedList();
        for (int i = 0; i < n; i++)
		   {
            llist.push(ar[i]);
            llist.printList();
            llist.printMiddle();
        }
    }
}
