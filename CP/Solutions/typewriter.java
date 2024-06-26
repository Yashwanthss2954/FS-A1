/*
Aruna as a data entry operator, typing a document in her laptop. Suddently her system got hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.

*/
import java.util.*;

class Test2 {
	public String reverseParentheses(String s) {
		Stack<Character> stack = new Stack<>();
	   for(char c : s.toCharArray())
		 {
		   if(c == ')')
			{
			 StringBuilder stringBuilder = new StringBuilder();
			 while (stack.peek() != '(')
			  {
			   stringBuilder.append(stack.pop());
			  }
			 stack.pop();
			 int i = 0;
			 while (i < stringBuilder.length())
			  {
			   stack.push(stringBuilder.charAt(i++));
			  }
		    }
		   else
			   stack.push(c);
	      }
	    StringBuilder stringBuilder = new StringBuilder();
	    while (!stack.empty())
		 {
		   stringBuilder.append(stack.pop());
	     }
	     return stringBuilder.reverse().toString();
	}

    public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(new Test2().reverseParentheses(str));
    }
}
/*


==== testcases ====

case =1
input =(how(old)(are)you)
Output =uoyareoldwoh

case =2
input =(this(is(my))house)
Output =esuohisymsiht

case =3
input =switch(off)(the)fan
Output =switchffoehtfan

case =4
input =(Kohli(got)(out))
Output =outgotilhoK

case =5
input =(tra)(si)(efil)
Output =artislife

case =6
input =(efil)(si)beautiful
Output =lifeisbeautiful


*/