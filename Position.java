public class Position {
    private int x;
    private int y;
    
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; };
    public int getY() { return y; };
    public void setX(int x) { this.x = x; };
    public void setY(int y) { this.y = y; };
    public boolean equals(Object o) {
        if(o instanceof Position) {
            return ((Position) o).getX() == this.x && ((Position) o).getY() == this.y;
        }
        return false;
    }
    public boolean valid() {
        return (0 <= x && x <= 7 && 0 <= y && y <= 7);
    }
}