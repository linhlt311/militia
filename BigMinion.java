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
	public void calMoveArea(ArrayList<Monster> monsters) {
		ArrayList<Position> mArea = new ArrayList<Position>();
		Position tmp = new Position(getCurPosition().getX()+1,getCurPosition().getY());
		if (tmp.getX() < Config.GAME_WIDTH) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX(),getCurPosition().getY());
		mArea.add(tmp);
		tmp = new Position(getCurPosition().getX()-1,getCurPosition().getY());
		if (tmp.getX() >= 0) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX(),getCurPosition().getY()+1);
		if (tmp.getY() <= Config.GAME_HEIGHT) mArea.add(tmp);
		tmp = new Position(getCurPosition().getX(),getCurPosition().getY()-1);
		if (tmp.getY() >= 0) mArea.add(tmp);
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
