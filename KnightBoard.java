public class KnightBoard {
	private int[][] board;
	private int[][] possibleMoves;

	public KnightBoard(int height, int length) {
		if (height <= 0 || length <= 0) {
			throw new IllegalArgumentException("Please use a legitimate board");
		}
		board = new int[height][length];
		possibleMoves = new int[height][length];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				if (i - 2 >= 0 && j + 1 < length)
					possibleMoves[i][j]++;
				if (i - 1 >= 0 && j + 2 < length)
					possibleMoves[i][j]++;
				if (i + 1 < height && j + 2 < length)
					possibleMoves[i][j]++;
				if (i + 2 < height && j + 1 < length)
					possibleMoves[i][j]++;
				if (i + 2 < height && j - 1 >= 0)
					possibleMoves[i][j]++;
				if (i + 1 < height && j - 2 >= 0)
					possibleMoves[i][j]++;
				if (i - 1 >= 0 && j - 2 >= 0)
					possibleMoves[i][j]++;
				if (i - 2 >= 0 && j - 1 >= 0)
					possibleMoves[i][j]++;

			}
		}
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
	public String helperToString() {
		String returns = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				returns = returns + possibleMoves[i][j] + " ";
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
		return solver(startX, startY);
	}
	private static boolean solver(int x, int y) {
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
