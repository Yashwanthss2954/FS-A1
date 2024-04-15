/*Mr. Balu is working in a lingustic company as part of his job he need to design an tool called diff utility tool.

The diff utility is a data comparison tool that calculates and displays the differences between the two texts. It tries to determine the smallest set of deletions and insertions and create one text from the other. Diff is line-oriented rather than character-oriented, unlike edit distance.

input format : two strings
output format : string which consists of alphabets and '+' and '-'

 For example,

Input=XMJYAUZ 
      XMJAATZ
Output= X M J -Y A -U +A +T Z
(- indicates that character is deleted from Y but it was present in X)
(+ indicates that character is inserted in Y but it was not present in X)

Example 2:
input = hellokmit
ngit
 output=-h -e -l -l -o -k -m +n +g i t
 */