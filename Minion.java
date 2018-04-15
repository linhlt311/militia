import java.util.ArrayList;

public class Minion extends Monster {
	Minion(Position pos) {
		super(pos);
	}

	@Override
	public void calculateMoveArea() {
		moveArea.clear();
		Position tmp = new Position(curPosition.getX()+1,curPosition.getY());
		if (tmp.getX() <= 7) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY());
		this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-1,curPosition.getY());
		if (tmp.getX() >= 0) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY()+1);
		if (tmp.getY() <= 7) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY()-1);
		if (tmp.getY() >= 0) this.moveArea.add(tmp);
	}
	
	@Override
	public boolean move() {
		int tmp = (int)(Math.random() * this.moveArea.size());
		curPosition = this.moveArea.get(tmp);
		return true;
	}
	
}
