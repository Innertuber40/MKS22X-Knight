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
	}
}
