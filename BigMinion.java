import java.util.ArrayList;

public class BigMinion extends Monster{
	private int shield;
	public int getShield() {
		return shield;
	}
	public void lowerShield() {
		shield = 0;
	}
	BigMinion(Position pos) {
		super(pos);
		shield = 1;
	}

	@Override
	void calculateMoveArea(ArrayList<Monster> pos) {
		moveArea.clear();
		Position tmp = new Position(curPosition.getX()+1,curPosition.getY());
		if (tmp.getX() <= Config.GAME_WIDTH) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY());
		this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-1,curPosition.getY());
		if (tmp.getX() >= 0) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY()+1);
		if (tmp.getY() <= Config.GAME_HEIGHT) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY()-1);
		if (tmp.getY() >= 0) this.moveArea.add(tmp);
		
	}

	@Override
	public boolean move(Position pos, ArrayList<Monster> mons) {
		calculateMoveArea(mons);
		Position min = curPosition;
		for (Position position: moveArea) {
			if (min.getDistance(pos) > position.getDistance(pos)) {
				min = position;
			}
		}
		curPosition = min;
		return true;
	}
}
