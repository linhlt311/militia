import java.util.ArrayList;

public class Minion extends Monster {
	@Override
	public ArrayList<Position<Integer, Integer>> calculateMoveArea() {
		moveArea.clear();
		Position<Integer, Integer> tmp = new Position<Integer, Integer>(curPosition.getX()+1,curPosition.getY());
		if (tmp.getX() <= 7) this.moveArea.add(tmp);
		tmp = new Position<Integer, Integer>(curPosition.getX(),curPosition.getY());
		this.moveArea.add(tmp);
		tmp = new Position<Integer, Integer>(curPosition.getX()-1,curPosition.getY());
		if (tmp.getX() <= 7) this.moveArea.add(tmp);
		tmp = new Position<Integer, Integer>(curPosition.getX(),curPosition.getY()+1);
		if (tmp.getX() <= 7) this.moveArea.add(tmp);
		tmp = new Position<Integer, Integer>(curPosition.getX(),curPosition.getY()-1);
		if (tmp.getX() <= 7) this.moveArea.add(tmp);
		return null;
	}
	
	@Override
	public boolean move(Position<Integer, Integer> pos) {
		curPosition = pos;
		return false;
	}
	
}
