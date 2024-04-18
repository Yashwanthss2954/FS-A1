# /*TRY TO SOLVE USING TWO POINTER APPROACH

# Input an array 'nums' and an integer value 'K'.
# You are required to move all 'K's to the end of the array.
# You should maintain the relative order of the non-K elements.

# Solve this problen without making a copy of the array(Extra space).

# Sample Test Cases:
# case=1
# input=5 1 5 3 12
# 5
# output=1 3 12 5 5

# case=2
# input=12 15 45 45 20 35 45 25 18 45
# 45
# output=12 15 20 35 25 18 45 45 45 45

# case=3
# input=7 7
# 7
# output=7 7
# '''
# USE FOLLOWING PYTHON CODE TO SOLVE THE PROBLEM
# class Solution(object):
#     def moveKs(self, nums,k):
#         #WRITE YOUR CODE HERE
                
# sol = Solution()
# List = list( map(int, input().split()) )
# K=int(input())
# sol.moveKs(List,K)
# print(List)


class Solution(object):
    def moveKs(self, nums,k):
        left=0
        right=0
        for right in range(0,len(nums)):
            if(nums[right]!=k):
                temp=nums[right]
                nums[right]=nums[left]
                nums[left]=temp
                left=left+1
        return nums
        
                
sol = Solution()
List = list( map(int, input().split()) )
K=int(input())
sol.moveKs(List,K)
print(List)