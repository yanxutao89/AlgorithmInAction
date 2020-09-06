package others;

/*Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.

Alex and Lee take turns, with Alex starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.



Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.


Constraints:

1 <= piles.length <= 100
1 <= piles[i] <= 10 ^ 4*/
public class StoneGameII {

	/*
	 * Runtime: 9 ms, faster than 20.32% of Java online submissions for Stone Game II.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Stone Game II.
	 */
	public int m;
    public int stoneGameII(int[] piles) {
        m = piles.length;
        int[][] memo = new int[m][m];
        return helper(piles, 0, true, 1, memo);
    }
    public int helper(int[] piles, int index, boolean flag, int M, int[][] memo){

    	if(index == m) {
        	return 0;
        }

        if(flag){
            if(memo[index][M] > 0) {
            	return memo[index][M];
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i = index; i <= index + 2 * M - 1 && i < m; i++){
                sum += piles[i];
                max = Math.max(max, sum + helper(piles, i + 1, false, Math.max(M, i - index + 1), memo));
            }
            memo[index][M] = max;
        }else{
            int min = Integer.MAX_VALUE;
            for(int i = index; i <= index + 2 * M - 1 && i < m; i++){
                min = Math.min(min, helper(piles, i + 1, true, Math.max(M, i - index + 1), memo));
            }
            return min;
        }

        return memo[index][M];
    }

	public static void main(String[] args) {

		int[] piles = {2,7,9,4,4};

		System.out.println(new StoneGameII().stoneGameII(piles));
	}
}
