/*
perform right shift on given integer

examples:
input=4
output=2

input=1
output=0

input=15
output=7

*/
import java.util.*;
class RightShift 
{
	public int RS(int n)
	{
		return n >> 1;
	}
  public static void main(String[] args) 
 {
    Scanner sc =new Scanner(System.in);
	int n = sc.nextInt();

    System.out.println(new RightShift().RS(n));    
  }
}
