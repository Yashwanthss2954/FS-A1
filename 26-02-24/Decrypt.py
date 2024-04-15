'''
Given an array of integers which is a secret Code which is an array of integers.
You will be provided with a key K.

To decrypt the Code, you must replace every number. 

If K > 0, replace the ith number with the sum of the next K numbers.
If K < 0, replace the ith number with the sum of the previous K numbers.
If K == 0, replace the ith number with 0.

The next element of Code[N-1] is Code[0], and the previous element of Code[0] is Code[N-1] (N is Length of array).

Given the circular array Code and an integer key K, return the decrypted Code.
 
Example 1:
Input: 5 7 1 4
3
Output: 12 10 16 13
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted Code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Example 2:
Input: 1 2 3 4
0
Output: 0 0 0 0
Explanation: When k is zero, the numbers are replaced by 0. 

Example 3:
Input: 2 4 9 3
-2
Output: 12 5 6 13
Explanation: The decrypted Code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 
Constraints:
N == Code.length
1 <= N <= 100
1 <= Code[i] <= 100
-(N - 1) <= K <= N - 1
'''

    
    
arr = list(map(int,input().split(" ")))
k = int(input())



def decrypt(code, k):
    n = len(code)
    d_code = [0] * n
    
    for i in range(n):
        if k > 0:
            next_k = k % n
            sum = 0
            for j in range(next_k):
                sum += code[(i + j + 1) % n]
            d_code[i] = sum
        elif k < 0:
            prev_k = -k % n
            sum = 0
            for j in range(prev_k):
                sum += code[(i - j - 1 + n) % n]
            d_code[i] = sum
        else:
            d_code[i] = 0
    
    return d_code
    
rest = decrypt(arr,k)
print(rest)