package others;

/*Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.



Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


Note:

1 <= N <= 1000*/
public class DivisorGame {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Divisor Game.
	 * Memory Usage: 33.2 MB, less than 13.33% of Java online submissions for Divisor Game.
	 */
	public boolean divisorGame(int N) {
        return divisorGameHelper(N, true);
    }

    public boolean divisorGameHelper(int N, boolean aliceMove) {

    	if(N == 1 && aliceMove) {
            return false;
        }

        for(int i = 1; i < N; i++) {
            if(N % i == 0) {
                N = N - i;
                if(N >= 1) {
                    return divisorGameHelper(N, !aliceMove);
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {

		int N = 2;

		System.out.println(new DivisorGame().divisorGame(N));
	}
}
