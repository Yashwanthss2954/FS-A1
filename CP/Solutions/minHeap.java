// Minimum heap is implemented using PriorityQueue

import java.util.*;
class MinHeap 
{
	private int[] Heap;
	private int size;
	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

	// This code makes it max Heap 
	// (reverse order - Items are added in descending order to PriorityQueue
	// PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

	// Constructor to initialize an empty min heap
	public MinHeap(int maxsize)
	{
		this.size = 0;
		Heap = new int[maxsize];
	}

	// Return position of parent
	private int parent(int pos) 
	{ 
		return (pos - 1) / 2; 
	}

	// Return left child
	private int leftChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	}

	// Return right child
	private int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Add elements to min heap using Priority Queue
	public void add(int [] nums)
	{
		// Adding items to the pQueue using add()
		for (int i = 0; i < nums.length; i++)
			pQueue.add(nums[i]);
		
		Iterator itr = pQueue.iterator();

		// Iterating and add items to heap
		while (itr.hasNext())
			Heap[size++] = (int)itr.next();
	}

	// Display heap
	public void print()
	{
		for (int i = 0; i < size / 2; i++) 
		{
			System.out.print("Parent: " + Heap[i]);

			if (leftChild(i) < size) 
				System.out.print(" Left Child: "
								+ Heap[leftChild(i)]);

			if (rightChild(i) < size) 
				System.out.print(" Right Child: "
								+ Heap[rightChild(i)]);

			System.out.println(); 
		}
	}

	public void removeMin()
	{
		System.out.println("Minimim element " + pQueue.poll());
		Iterator itr = pQueue.iterator();

		size = 0;
		// Iterating and add items to heap
		while (itr.hasNext())
			Heap[size++] = (int)itr.next();
	}

	// 9
	// 10 30 17 3 85 20 8 25 12

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		MinHeap minHeap = new MinHeap(n);
		int [] nums = new int[n];
		for(int i=0; i<n; i++)
		{
			 nums[i] = scan.nextInt();
		}
		minHeap.add(nums);		
		minHeap.print();
		minHeap.removeMin();	
		minHeap.print();	
		minHeap.removeMin();	
		minHeap.print();

	}
}
