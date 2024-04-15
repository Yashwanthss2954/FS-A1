/*
AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

*/ 

import java.util.*;
class palindrome{
    static boolean fun(String s){
        int x=0;
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i);
            int b=1<<a;
            x=x^b;
        }
        if(s.length()%2==0 && x==0){
            return true;
        }
        if(s.length()%2!=0 && (x&(x-1))==0){
            return true;
        }
        return false;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(fun(s));
    }
}
/*import java.util.*;
class palindrome{
    static boolean fun(String s){
        int x=0;
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i)-'a';
            // int b=1<<a;
            x=x^a;
        }
        if(s.length()%2==0 && x==0){
            return true;
        }
        if(s.length()%2!=0){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)-'a'==x){
                    return true;
                }
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(fun(s));
    }
} */