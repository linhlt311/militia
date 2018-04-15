import java.util.ArrayList;

public abstract class Monster {
	protected Position<Integer, Integer> curPosition;
	protected ArrayList<Position<Integer, Integer>> moveArea;
	protected ArrayList<Position<Integer, Integer>> attackArea;
	abstract boolean move(Position<Integer, Integer> pos);
}
