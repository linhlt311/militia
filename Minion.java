public class Minion extends Monster {
	@Override
	public boolean move(Position<Integer, Integer> pos) {
		curPosition = pos;
		return false;
	}
	
}
