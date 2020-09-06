package others;

public class BattleshipsInABoard {

	/*
	 * Runtime: 1 ms, faster than 92.82% of Java online submissions for Battleships in a Board.
	 * Memory Usage: 43 MB, less than 65.22% of Java online submissions for Battleships in a Board.
	 */
	 public int countBattleships(char[][] board) {

		 int count = 0;
         for(int i  =0; i < board.length; i++)
             for(int j = 0; j < board[0].length; j++){

                 char ch = board[i][j];
                 if(ch =='X' && (j == 0 || board[i][j-1] == '.') && (i == 0 || board[i-1][j] == '.')){

                	 count++;
                 }
             }
         return count;
	 }

	 public static void main(String[] args) {

		 char[][] board = {{'x', '.', '.', 'x'},
				 			{'.', '.', '.', 'x'},
				 			{'.', '.', '.', 'x'}};

		 System.out.println(new BattleshipsInABoard().countBattleships(board));
	 }
}
