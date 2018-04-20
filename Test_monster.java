public class Test_monster {
	public static void main(String argv[]) {
		Position pos = new Position(2,2);
		Minion m1 = new Minion(pos);
		Position pos2 = new Position(2,0);
		Hero m2 = new Sword(pos2);
		m1.calculateMoveArea(null);
		System.out.println(m1.getCurrentPosition().getX() + "," + m1.getCurrentPosition().getY());
		m1.move(pos2,null);
		System.out.println(m1.getCurrentPosition().getX() + "," + m1.getCurrentPosition().getY());
	}
}
