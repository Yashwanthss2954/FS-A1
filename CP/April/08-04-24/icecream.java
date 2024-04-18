/*In Turkey, an ice cream parlour gives an offer to a lucky kid.
The parlour keep N icecream cups in a row, and there are different flavours 
of icecreams, where i-th cup filled with the flavour[i] type of ice cream.

The kid can pick the continuous set of ice cream cups, where the cups filled
with the icecreams of atmost two different flavours. The kid wants to 
pick maximum number of icecream cups from the row.

You will be given the integer array, flavours[] of size N.
Your task is to help the kid to pick the maximum number of icecream cups 
with atmost two different flavours.


Input Format:
-------------
Line-1: An integer, number of icecreams.
Line-2: N space separated integers, flavours[] 

Output Format:
--------------
Print an integer result, maximum number of icecream cups can be picked.


Sample Input-1:
---------------
10
1 2 3 1 1 3 3 2 3 2

Sample Output-1:
----------------
5

Explanation:
------------
The kid can pick the continuous set of icecream cups as follows: 3 1 1 3 3
Where the cups are filled with two different flavours, 1 and 3.



Sample Input-2:
---------------
10
2 1 1 3 2 1 3 0 0 3

Sample Output-2:
----------------
4

import java.util.*;
class maxIcecream
{
	public int totalIcecream(int[] icecreams) 
	{      
        //WRITE YOUR CODE HERE
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int parlour[] = new int[n];
		for(int i = 0; i < n; i++)
			parlour[i] = sc.nextInt();
		System.out.println(new maxIcecream().totalIcecream(parlour));
	}
} */


import java.util.*;
class Icecream
{
	public int totalIcecream(int[] icecreams) 
	{      
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int maxice=0;
        int left=0;
        int winice=0;
        for(int i=0;i<icecreams.length;i++)
        {
            if(hm.containsKey(icecreams[i])==false){
                hm.put(icecreams[i],1);
                winice=winice+1;
            }
            else{
                hm.put(icecreams[i],hm.get(icecreams[i])+1);
                winice=winice+1;
            }
            if(hm.size()>2)
            {
                winice=winice-1;
                if(hm.get(icecreams[left])==1)
                    hm.remove(icecreams[left]);
                else
                    hm.put(icecreams[left],hm.get(icecreams[left])-1);
                left=left+1;
            }
            if(winice>maxice){
                maxice=winice;
            }
        }
        return maxice;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int parlour[] = new int[n];
		for(int i = 0; i < n; i++)
			parlour[i] = sc.nextInt();
		System.out.println(new Icecream().totalIcecream(parlour));
	}
}