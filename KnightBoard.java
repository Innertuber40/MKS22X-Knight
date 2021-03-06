import java.util.ArrayList;

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
					returns = returns + board[i][j] + " ";
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
		if (startY < 0 || startY >= board.length || startX < 0 || startX >= board[0].length) {
			throw new IllegalArgumentException("You expect me to check a knight that doesn't even start on the board? I'm a doctor, not a magician!");
		}
		if (board.length < 3 || board[0].length < 3) {
			return false;
		}
		return solver(startX, startY, 1);
	}
	private boolean solver(int x, int y, int move) {
		board[y][x] = move;
		if (move == board.length * board[0].length) {
			return true;
		}
		ArrayList<Coords> order = new ArrayList<Coords>();
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (i != 0 && j != 0 && i != j && -i != j && x + j < board[0].length && x + j >= 0 && y + i < board.length && y + i >= 0 && possibleMoves[y + i][x + j] != 0) {
					possibleMoves[y + i][x + j]--;
					if (board[y + i][x + j] == 0) {
						Coords adding = new Coords(x + j, y + i, possibleMoves[y + i][x + j]);
						order.add(adding);
					}
				}
			}
		}
		/*System.out.println();
		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i).getVal() + ", ");
		}*/
		for (int i = 1; i < order.size(); i++) {                         // check each value only once      
            int j = i;
            Coords toInsert = order.get(i);                                       // save the value we are swapping back
            while (j > 0 && (order.get(j - 1)).compareTo(toInsert) > 0) {    // occurs until the end or a smaller element
                order.set(j, order.get(j - 1));                                // move up
                j--;                                                      // move on to the next pair
            }
            order.set(j, toInsert);                                         // put the value in
        }
		/*System.out.println();
		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i).getVal() + ", ");
		}*/
		for (int i = 0; i < order.size(); i++) {
			if (solver(order.get(i).getX(), order.get(i).getY(), move + 1)) {
				return true;
			}
		}
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (i != 0 && j != 0 && i != j && -i != j && x + j < board[0].length && x + j >= 0 && y + i < board.length && y + i >= 0) {
					possibleMoves[y + i][x + j]++;
				}
			}
		}
		board[y][x] = 0;
		return false;
	}


	public int countSolutions(int startY, int startX) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException("You cannot solve an already solved board, silly.");
				}
			}
		}
		if (startY < 0 || startY >= board.length || startX < 0 || startX >= board[0].length) {
			throw new IllegalArgumentException("You expect me to check a knight that doesn't even start on the board? I'm a doctor, not a magician!");
		}
		return counter(startX, startY, 1, 0);
	}
	private int counter(int x, int y, int move, int count) {
		if (move == board.length * board[0].length) {
			return count + 1;
		}
		board[y][x] = move;
		ArrayList<Coords> order = new ArrayList<Coords>();
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (i != 0 && j != 0 && i != j && -i != j && x + j < board[0].length && x + j >= 0 && y + i < board.length && y + i >= 0 && possibleMoves[y + i][x + j] != 0) {
					possibleMoves[y + i][x + j]--;
					if (board[y + i][x + j] == 0) {
						Coords adding = new Coords(x + j, y + i, possibleMoves[y + i][x + j]);
						order.add(adding);
					}
				}
			}
		}
		/*System.out.println();
		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i).getVal() + ", ");
		}*/
		for (int i = 1; i < order.size(); i++) {                         // check each value only once      
            int j = i;
            Coords toInsert = order.get(i);                                       // save the value we are swapping back
            while (j > 0 && (order.get(j - 1)).compareTo(toInsert) > 0) {    // occurs until the end or a smaller element
                order.set(j, order.get(j - 1));                                // move up
                j--;                                                      // move on to the next pair
            }
            order.set(j, toInsert);                                         // put the value in
        }
		/*System.out.println();
		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i).getVal() + ", ");
		}*/
		for (int i = 0; i < order.size(); i++) {
			if (board[order.get(i).getY()][order.get(i).getX()] == 0) {
				count = counter(order.get(i).getX(), order.get(i).getY(), move + 1, count);
			}
		}
		board[y][x] = 0;
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (i != 0 && j != 0 && i != j && -i != j && x + j < board[0].length && x + j >= 0 && y + i < board.length && y + i >= 0) {
					possibleMoves[y + i][x + j]++;
				}
			}
		}
		return count;
	}
}