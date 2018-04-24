import java.util.ArrayList;

public abstract class Monster {
	private Position curPosition;
	private ArrayList<Position> moveArea;
	public Position getCurPosition() {
		return curPosition;
	}
	public void setCurPosition(Position pos) {
		curPosition = pos;
	}
	public ArrayList<Position> getMoveArea() {
		return moveArea;
	}
	public void setMoveArea(ArrayList<Position> pos) {
		moveArea = pos;
	}
	Monster(Position pos) {
		curPosition = pos;
		moveArea = new ArrayList<Position>();
	}
	public boolean equals(Object obj) {
        if(obj instanceof Monster) 
            return curPosition.equals(((Monster) obj).curPosition);
        return false;
    }
	abstract void calMoveArea(ArrayList<Monster> pos);
	abstract boolean move(ArrayList<Hero> heros, ArrayList<Monster> mons);
}
