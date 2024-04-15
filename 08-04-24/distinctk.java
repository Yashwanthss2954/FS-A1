/*Mr. Ram is working in an industry where his task is to fill a container with 
packets. Each packet is labeled with an alphabet, 
and a series of such packets flows from a conveyor belt. 
He needs to fill one single container with at most k distinct packets. 
.How many packets can he place in the container

 input format : string
                an integer
output format : an integer

Example 1:

Input: ccaabbb"
2
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
Example 2:
Input:eceba
2
Output: 3
Explanation: The substring is "ece" which its length is 3.
 

Constraints:

1 <= s.length <= 105
s consists of English letters.



import java.util.*;
class Solution 
{
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        //WRITE YOUR CODE HERE
    }
	public static void main(String[] args)
	{
		Scanner sc = new  Scanner(System.in);
		String str= sc.nextLine();
		int k = sc.nextInt();
		System.out.println(new Solution().lengthOfLongestSubstringKDistinct(str,k));
	}
} */


import java.util.*;
class DistinctK 
{
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int winpack=0,maxpack=0,left=0;
        for(int i=0;i<s.length();i++)
        {
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            else
                hm.put(s.charAt(i),1);
            winpack=winpack+1;
            if(hm.size()>k)
            {
                if(hm.get(s.charAt(left))==1)
                    hm.remove(s.charAt(left));
                else
                    hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left=left+1;
                winpack=winpack-1;
            }
            if(maxpack<winpack)
                maxpack=winpack;
        }
        return maxpack;
    }
	public static void main(String[] args)
	{
		Scanner sc = new  Scanner(System.in);
		String str= sc.nextLine();
		int k = sc.nextInt();
		System.out.println(new DistinctK().lengthOfLongestSubstringKDistinct(str,k));
	}
}