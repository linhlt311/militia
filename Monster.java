import java.util.ArrayList;

public abstract class Monster {
	protected Position curPosition;
	protected ArrayList<Position> moveArea;
	protected ArrayList<Position> attackArea;
	public Position getCurrentPosition() {
		return curPosition;
	}
	Monster(Position pos) {
		curPosition = pos;
		moveArea = new ArrayList<Position>();
	}
	public ArrayList<Position> getMoveArea() {
		return moveArea;
	}
	public boolean equals(Object obj) {
        if(obj instanceof Monster) 
            return curPosition.equals(((Monster) obj).curPosition);
        return false;
    }
	abstract void calculateMoveArea();
	abstract boolean move();
}
