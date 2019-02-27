public class Coords implements Comparable<Coords> {
    private int x;
    private int y;
    private int value;

    public Coords(int myX, int myY, int myVal) {
        x = myX;
        y = myY;
        value = myVal;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getVal() {
        return value;
    }
    public int compareTo(Coords other) {
        if (value > other.getVal()) {
            return 1;
        }
        if (value < other.getVal()) {
            return -1;
        }
        return 0;
    }
}