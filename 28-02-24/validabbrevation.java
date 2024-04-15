/*Mr. Vasu is solving a puzzle. In this puzzle, he is given a string and an 
abbreviation string. He needs to determine whether it is possible to form the 
given string using the abbreviation string.
An abbreviation string is a compressed representation of a string, where a number 
in the abbreviation represents the count of consecutive characters it replaces. 

For example, 'word' can be abbreviated as 'w2d', where '2' represents 
two characters 'or' being replaced. With your programming skills help vasu 
to solve this puzzle.

input format: two strings 
output format : true or false

sample test cases:
case =1
input=apple
a2le
output=true
case =2
input= intelligent
int3ligent
output=false
 */

 import java.util.*;
public class validabbrevation{
    static boolean fun(String w,String a){
        int wl=w.length();
        int al=a.length();
        int i=0,j=0;
        while(i<wl && j<al){
            if(w.charAt(i)==a.charAt(j)){
                i++;
                j++;
            }
            else if(a.charAt(j)>='0' && a.charAt(j)<='9'){
                int s=j;
                while(j<a.length() && a.charAt(i)>='0' && a.charAt(j)<='9'){
                    j++;
                }
                String res=a.substring(s,j);
                int r=Integer.parseInt(res);
                i+=r;
            } 
            else{
                return false;
            }
        }
        return i==w.length() && j==a.length();
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String w=sc.next();
        String a=sc.next();
        System.out.println(fun(w,a));
    }
}