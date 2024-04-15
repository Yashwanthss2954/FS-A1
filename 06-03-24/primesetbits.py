'''******DO NOT USE bin()to solve this problem******

Input two integers x and y (1 <= x <= y <= 10**6).

Find and display the count of numbers in the inclusive range "x to y" having a prime number of set bits in their binary representation.

The number of set bits an integer has is the number of 1's present when written in binary.
For example, 21 written in binary is 10101, which has 3 set bits.

Example 1:
Input: 6
10
Output: 4
Explanation:
6  -> 110 (2 set bits, 2 is prime)
7  -> 111 (3 set bits, 3 is prime)
8  -> 1000 (1 set bit, 1 is not prime)
9  -> 1001 (2 set bits, 2 is prime)
10 -> 1010 (2 set bits, 2 is prime)
4 numbers have a prime number of set bits.

Example 2:
Input:10
15
Output:5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
5 numbers have a prime number of set bits.
'''


# def is_prime(x):
#     if x < 2:
#         return False
#     for i in range(2, int(x**0.5) + 1):
#         if x % i == 0:
#             return False
#     return True

# n1=int(input())
# n2=int(input())
# r = 0

# for num in range(n1, n2 + 1):
#     c = bin(num).count('1')
#     if is_prime(c):
#         r += 1

# print(r)


n1 = int(input())
n2 = int(input())
r = 0
for num in range(n1, n2 + 1):
    c = 0
    i = num
    while i != 0:
        if i & 1 == 1:
            c += 1
        i = i >> 1
    flag = True
    if c < 2:
        flag = False
    else:
        for j in range(2, int(c**0.5) + 1):
            if c % j == 0:
                flag = False
                break
    if flag:
        r += 1
print(r)

