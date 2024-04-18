/*Mr.Sathya is playing a game, where he has some intial power and starts with initial score 0. He will be given box of coins as an integer array coins, where each coins[i] denotes the value of coin_i. 

His goal is to maximize the total score by strategically playing with these coins. In one move, you can play an unplayed coin in one of the two ways (but not both for the same coin):

Face-up: If sathya's current power is at least coins[i], he may play coin_i, losing coins[i] power and gaining 1 score.

Face-down: If sathya's current score is at least 1, he may play coin_i, gaining coins[i] power and losing 1 score.

Return the maximum possible score he can achieve after playing any number of coins.

input format :	an integer n
				n number of integers
				an integer (power)
output format : an integer

Example 1:
Input=1
100
50
Output: 0

Explanation: Since your score is 0 initially, you cannot play the coin face-down. You also cannot play it face-up since your power (50) is less than coins[0] (100).

Example 2:

Input=2
200 100
150
Output: 1

Explanation: Play coin_1 (100) face-up, reducing your power to 50 and increasing your score to 1.

There is no need to play coin_0, since you cannot play it face-up to add to your score. The maximum score achievable is 1.

Example 3:
Input=4
100 200 300 400
200
Output: 2

Explanation: Play the coins in this order to get a score of 2:

Play coin0 (100) face-up, reducing power to 100 and increasing score to 1.
Play coin3 (400) face-down, increasing power to 500 and reducing score to 0.
Play coin1 (200) face-up, reducing power to 300 and increasing score to 1.
Play coin2 (300) face-up, reducing power to 0 and increasing score to 2.
The maximum score achievable is 2.

 

Constraints:

0 <= coins.length <= 1000
0 <= coins[i], power < 104 */