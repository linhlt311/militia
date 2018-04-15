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
		moveArea = new ArrayList();
	}
	public ArrayList<Position> getMoveArea() {
		return moveArea;
	}
	abstract void calculateMoveArea();
	abstract boolean move();
}
