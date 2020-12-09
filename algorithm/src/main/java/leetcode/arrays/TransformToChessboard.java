package arrays;

/**
 * An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.
 *
 * What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.
 *
 * Examples:
 * Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * Output: 2
 * Explanation:
 * One potential sequence of moves is shown below, from left to right:
 *
 * 0110     1010     1010
 * 0110 --> 1010 --> 0101
 * 1001     0101     1010
 * 1001     0101     0101
 *
 * The first move swaps the first and second column.
 * The second move swaps the second and third row.
 *
 *
 * Input: board = [[0, 1], [1, 0]]
 * Output: 0
 * Explanation:
 * Also note that the board with 0 in the top left corner,
 * 01
 * 10
 *
 * is also a valid chessboard.
 *
 * Input: board = [[1, 0], [1, 0]]
 * Output: -1
 * Explanation:
 * No matter what sequence of moves you make, you cannot end with a valid chessboard.
 * Note:
 *
 * board will have the same number of rows and columns, a number in the range [2, 30].
 * board[i][j] will be only 0s or 1s.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/18 18:39
 */
public class TransformToChessboard {

	/**
	 * Runtime: 1 ms, faster than 98.15% of Java online submissions for Transform to Chessboard.
	 * Memory Usage: 38.8 MB, less than 62.96% of Java online submissions for Transform to Chessboard.
	 * @param board
	 * @return
	 */
	public int movesToChessboard(int[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return -1;
		}
		int N = board.length;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
					return -1;
				}
			}
		}
		int rowSum = 0;
		int colSum = 0;
		int rowSwap = 0;
		int colSwap = 0;
		for (int i = 0; i < N; ++i) {
			rowSum += board[0][i];
			colSum += board[i][0];
			if (board[i][0] == i % 2) {
				++rowSwap;
			}
			if (board[0][i] == i % 2) {
				++colSwap;
			}
		}
		if (N / 2 > rowSum || N / 2 > (N - rowSum) ||
				N / 2 > colSum || N / 2 > (N - colSum)) {
			return -1;
		}
		if ((N & 1) == 0) {
			rowSwap = Math.min(rowSwap, N - rowSwap);
			colSwap = Math.min(colSwap, N - colSwap);
		} else {
			if ((colSwap & 1) == 1) {
				colSwap = N - colSwap;
			}
			if ((rowSwap & 1) == 1) {
				rowSwap = N - rowSwap;
			}
		}
		return (rowSwap + colSwap) / 2;

	}

	public static void main(String[] args) {
		int[][] board = {{0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}};
		System.out.println(new TransformToChessboard().movesToChessboard(board));
	}
}
