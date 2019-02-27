public class KnightDriver {
	public static void main(String[] args) {
		KnightBoard firstBoard = new KnightBoard(5, 5);
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
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(6, -54);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(2, 8);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.solve(20, 4);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.countSolutions(-1, 6);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.countSolutions(6, -54);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.countSolutions(2, 8);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			preFilled.countSolutions(20, 4);
			System.out.println(preFilled);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		preFilled.fillBoard();
		System.out.println(preFilled);
		try {
			preFilled.solve(3, 6);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		try {
			preFilled.countSolutions(3, 6);
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		System.out.println(preFilled.helperToString());
		KnightBoard small = new KnightBoard(2, 17);
		System.out.println(small.helperToString());
		System.out.println(firstBoard.helperToString());
		System.out.println(firstBoard.countSolutions(0, 0));
		System.out.println(firstBoard);
		System.out.println(firstBoard.solve(0, 0));
		System.out.println(firstBoard.helperToString());
		System.out.println(firstBoard);
		System.out.println(small.solve(0, 0));
		System.out.println(small);
		KnightBoard threeByThree = new KnightBoard(3, 3);
		System.out.println(threeByThree.countSolutions(0,0));
		System.out.println(threeByThree.solve(0, 0));
		System.out.println(threeByThree);
	}
}
