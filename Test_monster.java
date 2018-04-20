import java.util.ArrayList;

public class Test_monster {
	public static void main(String argv[]) {
		Position pos = new Position(2,2);
		Minion m1 = new Minion(pos);
		Position pos2 = new Position(2,1);
		Minion m2 = new Minion(pos2);
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add(m2);
		m1.calculateMoveArea(monsters);
		System.out.println(m1.getCurrentPosition().getX() + "," + m1.getCurrentPosition().getY());
		System.out.println(m1.moveArea.size());
//		m1.move(pos2,null);
//		System.out.println(m1.getCurrentPosition().getX() + "," + m1.getCurrentPosition().getY());
	}
}
