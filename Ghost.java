import java.util.ArrayList;

public class Ghost extends Monster{
	private int cloak;
	public int getCloak() { return cloak; }
	public void setCloak() {
		cloak = 1 - cloak;
	}
	Ghost(Position pos) {
		super(pos);
		cloak = 1;
	}
	@Override
	void calculateMoveArea(ArrayList<Monster> monsters) {
		moveArea.clear();
		Position tmp = new Position(curPosition.getX()+2,curPosition.getY()+2);
		if (tmp.getX() <= Config.GAME_WIDTH && tmp.getY() <= Config.GAME_HEIGHT) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY());
		this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()+2,curPosition.getY()-2);
		if (tmp.getX() <= Config.GAME_WIDTH && tmp.getY() >= 0) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-2,curPosition.getY()+2);
		if (tmp.getX() >= 0 && tmp.getY() <= Config.GAME_HEIGHT) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-2,curPosition.getY()-2);
		if (tmp.getX() >= 0 && tmp.getY() >= 0) this.moveArea.add(tmp);		
		for(Monster mons: monsters) {
			Position pos = mons.curPosition;
			moveArea.remove(pos);
		}
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
