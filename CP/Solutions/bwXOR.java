/*
Write a java progam for Convert characters to uppercase or lowercase
*/
import java.util.*;
class Test 
{ 
   static int x=32; 
      
    // tOGGLE cASE = swaps CAPS to lower case and lower case to CAPS 
    static String toggleCase(char[] a) 
    { 
        for (int i=0; i<a.length; i++) { 
        
            // Bitwise XOR with 32 
            a[i]^=32; 
        } 
        return new String(a); 
    }
   public static void main(String[] args)  
    { 
        Scanner sc=new Scanner(System.in);
		String str = sc.nextLine(); 
        System.out.print("UpperCase: "); 
        str = toggleCase(str.toCharArray()); 
        System.out.println(str); 
          
        System.out.print("Original string: "); 
        str = toggleCase(str.toCharArray()); 
        System.out.println(str);     
    } 
} 
