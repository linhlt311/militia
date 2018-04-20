
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
	void calculateMoveArea() {
		moveArea.clear();
		Position tmp = new Position(curPosition.getX()+2,curPosition.getY()+2);
		if (tmp.getX() <= 7 && tmp.getY() <= 7) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX(),curPosition.getY());
		this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()+2,curPosition.getY()-2);
		if (tmp.getX() <= 7 && tmp.getY() >= 0) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-2,curPosition.getY()+2);
		if (tmp.getX() >= 0 && tmp.getY() <= 7) this.moveArea.add(tmp);
		tmp = new Position(curPosition.getX()-2,curPosition.getY()-2);
		if (tmp.getX() >= 0 && tmp.getY() >= 0) this.moveArea.add(tmp);		
	}

	@Override
	boolean move(Position pos) {
		calculateMoveArea();
		int tmp = (int)(Math.random() * this.moveArea.size());
		curPosition = this.moveArea.get(tmp);
		setCloak();
		return true;
	}
	
}
