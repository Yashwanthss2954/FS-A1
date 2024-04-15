/*
Mr. Ravi works in an industry where his duty involves monitoring the weight of vehicles passing through a weighing bridge. His task is to calculate the average weight of 'k' consecutive vehicles passing through the bridge and determine whether this average weight exceeds a specified threshold value. If the average weight exceeds the threshold, he needs to record how many groups of 'k' vehicles have crossed the threshold.

At any given time, 'k' vehicles are on the bridge, and only one vehicle can leave the bridge or enter it at a time. Mr. Ravi must calculate the average weight each time a new vehicle enters the bridge.
 
 input format : an integer n
                n number of integers
				two integers k and threshold
output format : an integer

Example 1:
Input:8
2 2 2 2 5 5 5 8
3 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

Example 2:
Input=10
11 13 17 23 29 31 7 5 2 3
3 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 104
1 <= k <= arr.length
0 <= threshold <= 104
 */