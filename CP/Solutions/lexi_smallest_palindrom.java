/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
---------------
r#d#v#cer

Sample Output-2:
----------------
invalid

*/
import java.util.*;
class Solution
{
	static boolean isPossiblePalindrome(char str[])
	{
	int n = str.length;
	for (int i = 0; i < n / 2; i++)
	{
		/* If both left and right character
			are not dot and they are not
			equal also, then it is not
			possible to make this string a
			palindrome */
		if (str[i] != '#' &&
			str[n - i - 1] != '#' &&
			str[i] != str[n - i - 1])
			return false;
	}
	return true;
	}
	// Returns lexicographically smallest
	// palindrome string, if possible
	public void smallestPalindrome(char str[])
	{
		if (!isPossiblePalindrome(str)){
		System.out.println("invalid");
		return;
	}
	int n = str.length;
	// loop through character of string
	for (int i = 0; i < n; i++)
	{
		if (str[i] == '#')
		{
			// if one of character is dot,
			// replace dot with other character
			if (str[n - i - 1] != '#')
				str[i] = str[n - i - 1];
			// if both character are dot,
			// then replace them with
			// smallest character 'a'
			else
				str[i] = str[n - i - 1] = 'a';
		}
	}
	for(int i = 0; i < n; i++)
		System.out.print(str[i] + "");
	}


	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str = sc.next();
		char[] s = str.toCharArray();
		Solution obj = new Solution();
		obj.smallestPalindrome(s);
	}
}
/*



==== testcases ====
case =1
input =r#d#v##er
output =redavader

case =2
input =r#d#v#cer
output =invalid

case =3
input =nol#mo#no#el#n
output =nolemonnomelon

case =4
input =r##r#msir#sm###er
output =rearamsirismaraer

case =5
input =n#v#ro#do#ev#n
output =naveroddorevan

case =6
input =#e#er#dt#pspot#or#v#n
output =neverodtopspotdoreven

case =7
input =sa#or#re#oten#top#ra#ot##
output =satorarepotenetoperarotas

case =8
input =r##r#msisa#or#re#oten#top#ra#ot###sm###er
output =rearamsisatorarepotenetoperarotasismaraer
*/

