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
}
