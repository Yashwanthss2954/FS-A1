/*
 Mr. Varun is an accountant in a shop,daily turnover of shop is in lakhs, some times it is negetive also when purchses by the shop are more than sales of shop.One day shop owner called Varun and asked him to give the sum of three days turnover which is near to given target.Help Varun with a your program skills.



input format : integer (n)
               n number of integers
			   integer (target)
output format : integer

You may assume that each input would have exactly one solution.

Example 1:

Input:4
-1 2 1 -4
1
Output: 2

Example 2:
Input:3
0 0 0 
1
Output: 0
 */

import java.util.*;
public class threeptrsum {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        int start, end;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            start = i + 1;
            end = n - 1;
            int sum = nums[i];
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}
