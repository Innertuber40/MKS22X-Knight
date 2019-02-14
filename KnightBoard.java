import java.lang.Math;
import java.util.Arrays;

public class KnightBoard {
	private int[][] board;
	public KnightBoard(int height, int length) {
		if (height <= 0 || length <= 0) {
			throw new IllegalArgumentException("Please use a legitimate board");
		}
		board = new int[height][length];
	}

	public String toString() {
		String returns = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					returns += " _ ";
				} else if (board[i][j] < 10) {
					returns = returns + " " + board[i][j] + " ";
				} else {
					returns += returns + board[i][j] + " ";
				
				}
			}
			returns += "\n";
		}
		return returns;
	}
	public void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = (int)(10 * Math.random());
			}
		}
	}
	public ArrayList<int> accessTheBoard() {
		Integer[][] = new Integer[board.length][board[0].length];
		return Arrays.asList(ArrayUtils.integerBoard);
	}

	public boolean solve(int startY, int startX) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException("You cannot solve an already solved board, silly.");
				}
			}
		}
		if (startY < 0 || startY >= board.length || startX < 0 || startX >= board.length) {
			throw new IllegalArgumentException("You expect me to check a knight that doesn't even start on the board? I'm a doctor, not a magician!");
		}
		return true;
	}

	public int countSolutions(int startY, int startX) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException("You cannot solve an already solved board, silly.");
				}
			}
		}
		if (startY < 0 || startY >= board.length || startX < 0 || startX >= board.length) {
			throw new IllegalArgumentException("You expect me to check a knight that doesn't even start on the board? I'm a doctor, not a magician!");
		}
		return 6;
	}
}
