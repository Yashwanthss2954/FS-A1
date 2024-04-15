/*

Mr. Balu is working in a lingustic company as part of his job he need to design an tool called diff utility tool.

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
import java.util.*;
class Main
{
	// Function to display the differences between two strings
	public static void diff(String X, String Y, int m, int n, int[][] lookup)
	{
		// if the last character of `X` and `Y` matches
		if (m > 0 && n > 0 && X.charAt(m - 1) == Y.charAt(n - 1))
		{
			diff(X, Y, m - 1, n - 1, lookup);
			System.out.print(" " + X.charAt(m - 1));
		}
		// if the current character of `Y` is not present in `X`
		else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n]))
		{
			diff(X, Y, m, n - 1, lookup);
			System.out.print(" +" + Y.charAt(n - 1));
		}
		// if the current character of `X` is not present in `Y`
		else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n]))
		{
			diff(X, Y, m - 1, n, lookup);
			System.out.print(" -" + X.charAt(m - 1));
		}
	}
	// Function to fill the lookup table by finding the length of LCS
	// of substring X[0…m-1] and Y[0…n-1]
	public static int[][] findLCS(String X, String Y, int m, int n)
	{
		// lookup[i][j] stores the length of LCS of substring X[0…i-1] and Y[0…j-1]
		int[][] lookup = new int[X.length() + 1][Y.length() + 1];
		// first column of the lookup table will be all 0
		for (int i = 0; i <= m; i++) {
			lookup[i][0] = 0;
		}
		// first row of the lookup table will be all 0
		for (int j = 0; j <= n; j++) {
			lookup[0][j] = 0;
		}
		// fill the lookup table in a bottom-up manner
		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				// if current character of `X` and `Y` matches
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + 1;
				}
				// otherwise, if the current character of `X` and `Y` don't match
				else {
					lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
				}
			}
		}
		return lookup;
	}
	// Implement diff utility in Java
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String X = sc.nextLine();
		String Y = sc.nextLine();

		// lookup[i][j] stores the length of LCS of substring X[0…i-1] and Y[0…j-1]
		int[][] lookup = findLCS(X, Y, X.length(), Y.length());

		// find the difference
		diff(X, Y, X.length(), Y.length(), lookup);
	}
}
/*
Test cases 
case =1
input =hellokmit
ngit
output=-h -e -l -l -o -k -m +n +g i t
case =2
input=kmit
KMIT
output=-k -m -i -t +K +M +I +T
case=3
input=hello
12345
output=-h -e -l -l -o +1 +2 +3 +4 +5
case =4
input=hello
hello
output=h e l l o
*/