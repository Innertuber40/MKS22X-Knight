public class KnightDriver {
	public static void main(String[] args) {
		KnightBoard firstBoard = new KnightBoard(6, 8);
		System.out.println(firstBoard);
		try {
			KnightBoard illegitimate = new KnightBoard(0, 1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(1, 0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(-1, 1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(1, -1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(0, 0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(-1, -1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			KnightBoard illegitimate = new KnightBoard(0, -1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		KnightBoard preFilled = new KnightBoard(7, 8);
		try {
			preFilled.solve(-1, 6);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(6, -54);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(2, 8);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(20, 4);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		preFilled.fillBoard();
		try {
			preFilled.solve(3, 6);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
	}
}
