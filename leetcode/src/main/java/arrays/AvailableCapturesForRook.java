package arrays;

/**
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 *
 * Example 1:
 *
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 *
 * Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 *
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 *
 * Note:
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 */
public class AvailableCapturesForRook {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Available Captures for Rook.
	 * Memory Usage: 36.7 MB, less than 84.19% of Java online submissions for Available Captures for Rook.
	 * @param board
	 * @return
	 */
	public int numRookCaptures(char[][] board) {

	    int[] coordinate = new int[2];
	    int capture = 0;

	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (board[i][j] == 'R') {
	                coordinate[0] = i;
	                coordinate[1] = j;
	            }
	        }
	    }

	    for (int i = coordinate[1]; i < board[coordinate[0]].length; i++) {
	        if (board[coordinate[0]][i] == 'B') {
	            break;
	        } else if (board[coordinate[0]][i] == 'p') {
	            capture++;
	            break;
	        }
	    }

	    for (int i = coordinate[1]; i >= 0; i--) {
	        if (board[coordinate[0]][i] == 'B') {
	            break;
	        } else if (board[coordinate[0]][i] == 'p') {
	            capture++;
	            break;
	        }
	    }

	    for (int i = coordinate[0]; i < board.length; i++) {
	        if (board[i][coordinate[1]] == 'B') {
	            break;
	        } else if (board[i][coordinate[1]] == 'p') {
	            capture++;
	            break;
	        }
	    }

	    for (int i = coordinate[0]; i >= 0; i--) {
	         if (board[i][coordinate[1]] == 'B') {
	            break;
	        } else if (board[i][coordinate[1]] == 'p') {
	            capture++;
	            break;
	        }
	    }

	    return capture;
    }

	public static void main(String[] args) {

		char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};

		System.out.println(new AvailableCapturesForRook().numRookCaptures(board));
	}

}
