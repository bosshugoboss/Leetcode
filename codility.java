/*
A matrix A of size N*M containing Boolean values is given. We say that a square of size L can be placed in A at position (X,Y) if:
0 < L ≤ min(N,M),
0 ≤ X ≤ N−L,
0 ≤ Y ≤ M−L, and
A[X+I][Y+J] = true for all 0 ≤ I < L and 0 ≤ J < L.
If a square of size L can be placed at (X,Y), and at (X+1,Y) or (X,Y+1), then we say that it can be moved (in a single move) from (X,Y) to, respectively, (X+1,Y) or (X,Y+1).
We are looking for the largest L such that:
A square of size L can initially be placed at (0,0);
The square can be moved, by a sequence of moves, from (0,0) to (N−L, M−L).
In other words, we are looking for the largest square that can be moved from the upper-left to the lower-right corner, over elements of the matrix that are equal to true, by moving it downwards and to the right. In particular, if array A contains only true elements, then L = min(N,M).
Write a function:
class Solution { public int solution(boolean[][] A); }
that, given a matrix A of size N*M containing Boolean values, returns size L of the largest square satisfying the above conditions. If there is no such L, the function should return 0.
For example, given array A:
A[0][0]=true   A[0][1]=true   A[0][2]=true   A[0][3]=false
A[1][0]=true   A[1][1]=true   A[1][2]=true   A[1][3]=false
A[2][0]=true   A[2][1]=true   A[2][2]=true   A[2][3]=false
A[3][0]=true   A[3][1]=true   A[3][2]=true   A[3][3]=true
A[4][0]=false  A[4][1]=true   A[4][2]=true   A[4][3]=true
A[5][0]=true   A[5][1]=false  A[5][2]=true   A[5][3]=true
the function should return 2.
Given array A:
A[0][0]=true   A[0][1]=true   A[0][2]=false  A[0][3]=false
A[1][0]=true   A[1][1]=false  A[1][2]=false  A[1][3]=false
A[2][0]=false  A[2][1]=true   A[2][2]=false  A[2][3]=true
the function should return 0.
Given array A:
A[0][0]=true
the function should return 1.
Assume that:
N and M are integers within the range [1..200].
Complexity:
expected worst-case time complexity is O(N*M*(log(N)+log(M)));
expected worst-case space complexity is O(N*M).
*/

// you can also use imports, for example:
// import java.math.*;
class Solution {
   public static int result = 0;
   public static int solution(boolean[][] A) {
    	result = 0;
        int[][] maxSquare = new int[A.length][A[0].length];
        if(!A[0][0]) return 0;
        maxSquare[0][0] = 1;
        for(int i = 1; i < A.length; i ++){
        	maxSquare[i][0] = A[i][0] ? 1 : 0;
        }
        for(int i = 1; i < A[0].length; i ++){
        	maxSquare[0][i] = A[0][i] ? 1 : 0;
        }
    	for(int i = 1; i < A.length; i ++){
    		for(int j = 1; j < A[0].length; j ++){
    			if(!A[i][j]){
    				maxSquare[i][j] = 0;
    				continue;
    			}
    			if(maxSquare[i-1][j] == maxSquare[i][j-1]){
    			   int squareLength = maxSquare[i-1][j];
    			   maxSquare[i][j] = A[i-squareLength][j-squareLength] 
    					             ? squareLength + 1 : squareLength;
    			}
    			else{
    			  maxSquare[i][j] = Math.min(maxSquare[i-1][j], maxSquare[i][j-1]) + 1;
    			}
    		}
    	}
    	int length = maxSquare.length - 1;
    	int width = maxSquare[0].length - 1;
        BFS(length, width, maxSquare[length][width], maxSquare);  	
    	return result;
    }
    private static void BFS(int row, int column, int L, int[][] maxSquare){
    	if(row < 0 || column < 0) return;
    	int length = maxSquare[row][column];
    	if(length == 0) return;
    	else if(row - L == -1 && column - L == -1){
    		   result = Math.max(result, L);
    		   return;
    	}
    	else{
    		  BFS(row - 1, column, Math.min(L, length), maxSquare);
    	      BFS(row, column - 1, Math.min(L, length), maxSquare);
    	} 	
    }
}
