// /*A dieter consumes calories[i] calories on the i-th day. 
// Given an integer k, for every consecutive sequence of k days (calories[i], 
// calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, 
// the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):

// •	If T < lower, they performed poorly on their diet and lose 1 point; 
// •	If T > upper, they performed well on their diet and gain 1 point;
// •	Otherwise, they performed normally and there is no change in points.
// Initially, the dieter has zero points. 
// Return the total number of points the dieter has after dieting for calories.length days.
// Note that the total points can be negative.
 
// Example 1:
// Input: claorie size calorie[5],calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
// Output: 0
// Explanation: Since k = 1, we consider each element of the array separately and compare it to lower and upper.
// calories[0] and calories[1] are less than lower so 2 points are lost.
// calories[3] and calories[4] are greater than upper so 2 points are gained.
// Example 2:
// Input: calorie[2],calories = [3,2], k = 2, lower = 0, upper = 1
// Output: 1
// Explanation: Since k = 2, we consider subarrays of length 2.
// calories[0] + calories[1] > upper so 1 point is gained.
// Example 3:
// Input: calorie[4],calories = [6,5,0,0], k = 2, lower = 1, upper = 5
// Output: 0
// Explanation:
// calories[0] + calories[1] > upper so 1 point is gained.
// lower <= calories[1] + calories[2] <= upper so no change in points.
// calories[2] + calories[3] < lower so 1 point is lost.
 
// Sample input=3
// 1 2 3
// 1 3 1
// Sample output =1

// Constraints:
// •	1 <= k <= calories.length <= 10^5
// •	0 <= calories[i] <= 20000
// •	0 <= lower <= upper

// */
// import java.util.*;

// class DietPlanPerformance
//  {
//     public int dietPlanPerformance(int[] calories, int k, int lower, int upper)
//     {
//         if(k>calories.length){
//             return -1;
//         }
//         int tc=0;
//         int msum=0;
//         //WRITE YOUR CODE HERE
//         for(int i=0;i<k;i++){
//             msum+=calories[i];
//         }
//         if(msum<lower){
//             tc--;
//             }
//         else if(msum>upper){
//             tc++;
//         }
//         int sum=msum;
//         for(int i=k;i<calories.length;i++){
//             sum+=calories[i]-calories[i-k];
//             if(sum<lower){
//                 tc--;
//             }
//             else if(sum>upper){
//                 tc++;
//             }
//         }
//         return tc;
//     }
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);

        
//         int n=sc.nextInt();
//         int calories[]=new int[n];
        
//         for(int i=0;i<n;i++)
//         {
//             calories[i]=sc.nextInt();
//         }
        
//         int k=sc.nextInt();
        
//         int l=sc.nextInt();
        
//         int u=sc.nextInt();
//         System.out.println(new DietPlanPerformance().dietPlanPerformance(calories,k,l,u));
//     }
//  }





import java.util.*;
public class main{
    static int fun(int []a,int m){
        int s=0,c=0;
        for(int i=0;i<n;i++){
            int j=i;
            while(j<n && s<m){
                s+=arr[i];
                c++;
                j++;
            }
        }
        return c;
    }
    static int max(int []a,int n,int k){
        int min=Integer.MAX_VALUE;
        int l,h;
        for(auto i:a){
            if(l<min){
                min=l;
            }
            h+=i;
        }
        while(l<=h){
            int mid=(l+h-1)/2;
            if(fun(a,mid)>k){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return l;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(max(a,n,k));
    }
}