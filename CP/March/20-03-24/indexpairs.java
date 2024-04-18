/*An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17

import java.util.*;

class IndexPairs 
{
    public int[][] indexPairs(String text, String[] words) 
    {
        //WRITE YOUR CODE HERE
    }
}

class Trie
{
    Trie[] children;
    boolean end;   /*indicate whether there is a word
    public Trie()
    {
        end=false;
        children=new Trie[26];
    }
}

class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String org=sc.nextLine();
		String arr[]=sc.nextLine().split(" ");
		int res[][]=new IndexPairs().indexPairs(org,arr);
		for(int[] ans: res){
			System.out.println(ans[0]+" "+ans[1]);
		}
	}
} 
*/


import java.util.*;

class solution 
{	
	static final int NUM_CHARS = 26;
	static boolean isDeleted = false;	
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[NUM_CHARS];
	
		// isEndOfWord is true if the node represents end of a word
		boolean isEndOfWord;
		
		TrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	static void insert(String key)
	{
		int level;
		int length = key.length();
		int index;
	
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new TrieNode();
	
			currentNode = currentNode.children[index];
		}
	
		// mark last node as leaf
		currentNode.isEndOfWord = true;
	}
	
	// Returns true if key (prefix or complete word) is present in trie, else false
	static int search(String key,int start)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode currentNode = root;
		int count=0;
	
		for (level = start; level < length; level++)
		{
			index = key.charAt(level) - 'a';
	
			if (currentNode.children[index] == null)
				return -1;
	        count+=1;
			currentNode = currentNode.children[index];
			
			if(currentNode.isEndOfWord){
			    System.out.println(start+" "+(start+count-1));
			    currentNode.isEndOfWord=false;
			    int r=search(key,start);
			    currentNode.isEndOfWord=true;
			    return r;
			}
			
		}
	    if(currentNode.isEndOfWord) return count;
		else{
		    return -1;
		} 
		
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String keys[]=sc.nextLine().split(" ");	
		root = new TrieNode();
	
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);
		
		int z=0;
			
		while(z<s.length()){
		    int start=z;
		    int c=search(s,start);
		    if(c!=-1)
		    System.out.println(start+" "+(start+c-1));
		    z+=1;
		}
		
		
	}
}