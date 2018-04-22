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
	void calMoveArea(ArrayList<Monster> monsters) {
		ArrayList<Position> mArea = new ArrayList<Position>();
		Position tmp = new Position(getCurPosition().getX()+2,getCurPosition().getY()+2);
		if (tmp.getX() <= Config.GAME_WIDTH && tmp.getY() <= Config.GAME_HEIGHT) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX(),getCurPosition().getY());
		this.getMoveArea().add(tmp);
		tmp = new Position(getCurPosition().getX()+2,getCurPosition().getY()-2);
		if (tmp.getX() <= Config.GAME_WIDTH && tmp.getY() >= 0) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX()-2,getCurPosition().getY()+2);
		if (tmp.getX() >= 0 && tmp.getY() <= Config.GAME_HEIGHT) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX()-2,getCurPosition().getY()-2);
		if (tmp.getX() >= 0 && tmp.getY() >= 0) mArea.add(tmp);		
		for(Monster mons: monsters) {
			Position pos = mons.getCurPosition();
			mArea.remove(pos);
		}
		setMoveArea(mArea);
	}

	@Override
	public boolean move(Position pos, ArrayList<Monster> mons) {
		calMoveArea(mons);
		Position min = getCurPosition();
		for (Position position: getMoveArea()) {
			if (min.getDistance(pos) > position.getDistance(pos)) {
				min = position;
			}
		}
		setCurPosition(min);
		return true;
	}
	
}
