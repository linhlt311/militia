public class Position<X, Y> {
    X x;
    Y y;
    
    Position(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    
    public X getX() { return x; };
    public Y getY() { return y; };
    public void setX(X x) { this.x = x; };
    public void setY(Y y) { this.y = y; };
    public boolean equals(Object o) {
        if(o instanceof Position) {
            return ((Position) o).getX() == this.x && ((Position) o).getY() == this.y;
        }
        return false;
    }
}
