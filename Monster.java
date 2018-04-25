import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Monster {
	protected Position curPosition;
	protected ArrayList<Position> moveArea;
	protected ArrayList<Position> attackArea;
	protected DrawTile monsterImage;
	public Position getCurrentPosition() {
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
	public void draw(Graphics g) {
		this.monsterImage.setX(this.curPosition.getX()+1);
		this.monsterImage.setY(this.curPosition.getY()+1);
		this.monsterImage.draw(g);
	}
	abstract void calMoveArea(ArrayList<Monster> pos);
	abstract boolean move(ArrayList<Hero> heros, ArrayList<Monster> mons);
}
