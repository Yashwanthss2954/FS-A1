'''
The emplyee typed his name but as key board is dammaged when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

Let's examine the typed characters of the keyboard. 
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
Return false if name was wrongly spelled.

 
Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 

Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.

Input Format:
First line is actual name
Second line is name typed

Ouput Format:
Display boolean value True or False
'''

# n=input()
# t=input()
# p1=0
# p2=0
# c=0
# for i in range(len(n)):
#     if(n[p1]==t[p2]):
#         p1+=1
#         k=p1
#         p2+=1
#         c+=1
#     else:
#         if(n[k]==t[p2]):
#             if(c<=1):
#                 c+=1
#             else:
#                 print('false')
#                 break
#         else:
#             print('false')
#     if(p1==len(n)):
#         print('true')

n = input()
t = input()
p1 = 0
p2 = 0
while p2<len(t):
    if p1<len(n) and n[p1]==t[p2]:
        p1+=1
        p2+=1
    elif p1>0 and n[p1-1]==t[p2]:
        p2+=1
    else:
        print('false')
        break
if p1==len(n):
    print('true')
else:
    print('false')
