public class Test_monster {
	public static void main(String argv[]) {
		Position pos = new Position(2,2);
		Minion m1 = new Minion(pos);
		m1.calculateMoveArea();
		for(Position p: m1.getMoveArea()) {
			System.out.println(p.getX() + ", " + p.getY()); 
        }
		m1.move();
		System.out.println(m1.getCurrentPosition().getX() + ", " + m1.getCurrentPosition().getY());
	}
}
