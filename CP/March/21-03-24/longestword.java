/* In a school, the students are given an array of strings words[]. Students have 
to find the longest string in words[] such that every prefix of it is also in words.

For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" 
has prefixes "ap","app","appl" and "a", all of which are in words.

Your task is the find and return the longest string in words as described above.

If there is more than one string with the same length, return the lexicographically
smallest one, and if no string exists, return "".

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
----------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


Sample Input-2:
---------------
t tanker tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.
However, "tupla" is lexicographically smaller, so we return that.


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""

import java.util.*;
class trieHelper 
{
    Trie root = new Trie();
    String res = "";
    public String longestWord(String[] words) 
    {
        for (String word : words) 
			addWord(word);
        for (String word : words) 
			searchPrefix(word);
        return res;
    }
    
    private void searchPrefix(String word) 
    {
		//WRITW YOUR CODE HERE
	}
    
    private void addWord(String word) 
    {
        //WRITE YOUR CODE HERE
    }
}
class Trie 
{
    Trie[] children = new Trie[26];
    boolean isWord;
}

class LongestWord
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String arr[]=sc.nextLine().split(" ");
		System.out.println(new trieHelper().longestWord(arr));
	}
}

*/
import java.util.*;
class trieHelper 
{
    Trie root = new Trie();
    String res = "";
    String ans = "";
    public String longestWord(String[] words) 
    {
        for (String word : words) 
			addWord(word);
        for (String word : words) {
			res=searchPrefix(word);
		if(ans.length()<res.length()){
		    ans=res;
		}
		else if(ans.length()==res.length()){
    		if(ans.compareTo(res)>0){
    		    ans=res;
    		}
		}
        }
        return ans;
    }
    
    private String searchPrefix(String key) 
    {
		//WRITW YOUR CODE HERE
		Trie curr= root;
		String res="";
		for(int i=0;i<key.length();i++){
		    int ind=key.charAt(i)-'a';
		    if(curr.children[ind]==null){
		        return "";
		    }
		    if(curr.children[ind].isWord){
		        res+=key.charAt(i);
		    }
		    else{
		        return "";
		    }
		    curr=curr.children[ind];
		}
		
		return res;
		
	}
    
    private void addWord(String key) 
    {
        //WRITE YOUR CODE HERE
        int level;
		int length = key.length();
		int index;
	
		Trie currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new Trie();
	
			currentNode = currentNode.children[index];
		}
	
		// mark last node as leaf
		currentNode.isWord = true;
    }
}
class Trie 
{
    Trie[] children = new Trie[26];
    boolean isWord;
}

class longestword
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String arr[]=sc.nextLine().split(" ");
		System.out.println(new trieHelper().longestWord(arr));
	}
}

