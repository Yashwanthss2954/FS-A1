/*Single Number- Find the element in an array that is not repeated.*/
import java.util.*;
class SingleNumber 
{
    private static int singleNumber(int[] nums) 
{
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
     public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
        int[] nums = {4, 1, 2, 9, 1, 4, 2};
        System.out.println("Element appearing one time is " + singleNumber(nums));
    }
}
