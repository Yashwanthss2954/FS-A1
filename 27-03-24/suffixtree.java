/*/*
Write a program to implement suffix tree concept. 
Given a string return how many distinct subtrees are possible
input format : string
output format : integer
Example :
input=banana
output=15
*/
import java.util.*;
class suffixtree
{
	static class SuffixTrieNode
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
		boolean isEndOfWord;
		SuffixTrieNode() 
	    {
	       for (int i = 0; i < MAX_CHAR; i++)
				children[i] = null;
	    }
		void insertSuffix(String s)
	    {
	        //WRITE YOUR CODE HERE
	        SuffixTrieNode curr=this;
	        for(int i=0;i<s.length();i++){
	            int ind=s.charAt(i)-'a';
	            if(curr.children[ind]==null){
	                curr.children[ind]=new SuffixTrieNode();
	            }
	            curr=curr.children[ind];
	            insertSuffix(s.substring(1));
	        }
	        curr.isEndOfWord=true;
		}
	}
	static class Suffix_trie
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode root;
		Suffix_trie(String s)
		{
			root = new SuffixTrieNode();
			for (int i = 0; i < s.length(); i++)
			root.insertSuffix(s.substring(i));
		}
		int _countNodesInTrie(SuffixTrieNode node)
		{
			//WRITE YOUR CODE HERE
			if(node==null){
			    return 0;
			}
			int c=0;
			for(int i=0;i<26;i++){
			    if(node.children[i]!=null){
			        c+=_countNodesInTrie(node.children[i]);
			     //   System.out.println(c);
			    }
			}
			return c+1;
		}
		int countNodesInTrie()
		{
	        return _countNodesInTrie(root);
		}
	}
		static int countDistinctSubstring(String str)
		{
			Suffix_trie sTrie = new Suffix_trie(str);
			return sTrie.countNodesInTrie();
		}
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter any string to construct suffix tree");
			String str=sc.nextLine();		
			System.out.println("Count of distinct substrings is "
					+ (countDistinctSubstring(str) - 1));
		}
}
