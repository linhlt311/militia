public class BigMinion extends Minion{
	private int shield;
	public int getShield() {
		return shield;
	}
	public void lowerShield() {
		shield = 0;
	}
	BigMinion(Position pos) {
		super(pos);
		this.setMonsterImage(new DrawTile("/monster3.png"));
		shield = 1;
	}
}
