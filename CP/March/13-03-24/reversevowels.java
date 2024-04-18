/*Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle


Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians
 */

 import java.util.*;
class reversevowel{
    static String func(StringBuilder sb){
        int i=0;
        int j=sb.length()-1;
        int f=0;
        int f1=0;
        while(i<j){
            if(sb.charAt(i)=='a' || sb.charAt(i)=='e' || sb.charAt(i)=='i' || sb.charAt(i)=='o' || sb.charAt(i)=='u'){
                f=1;
            }
            else{
                i++;
            }
            if(sb.charAt(j)=='a' || sb.charAt(j)=='e' || sb.charAt(j)=='i' || sb.charAt(j)=='o' || sb.charAt(j)=='u'){
                f1=1;
            }
            else{
                j--;
            }
            if(f==1 && f1==1){
                f=0;
                f1=0;
                char a=sb.charAt(i);
                char b=sb.charAt(j);
                sb.setCharAt(i,b);
                sb.setCharAt(j,a);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        StringBuilder sb=new StringBuilder(s);
        System.out.print(func(sb));
    }
}
 