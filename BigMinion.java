
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
	void calculateMoveArea() {
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
	boolean move() {
		calculateMoveArea();
		int tmp = (int)(Math.random() * this.moveArea.size());
		curPosition = this.moveArea.get(tmp);
		return true;
	}
}
