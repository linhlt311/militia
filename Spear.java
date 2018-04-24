
import java.util.ArrayList;

public class Spear extends Hero {
		
    public Spear(Position pos) {
        super(pos);
        this.heroImage = new DrawTile("/spear3.png");
    }
    
    @Override
    void calMoveArea() {
        int x = curPosition.getX();
        int y = curPosition.getY();
        moveArea.clear();
        for(int i = -2; i <= 2; i++) {
            for(int j = -2; j <= 2; j++) {
                Position tmp = new Position(x+i, y+j);
                if(tmp.valid()) moveArea.add(tmp);
            }
        }
    }

    @Override
    void calAttackArea() {
        int x = curPosition.getX();
        int y = curPosition.getY();
        attackArea.clear();
        for(int i = -2; i <= 2; i++) {
            Position tmp_1 = new Position(x+i, y-i);
            if (tmp_1.valid()) attackArea.add(tmp_1);
            Position tmp_2 = new Position(x+i, y+i);
            if (tmp_2.valid()) attackArea.add(tmp_2);
        }
        attackArea.remove(new Position(x, y));
        attackArea.remove(new Position(x, y));
    }

    @Override
    boolean move(Position pos) {
        calMoveArea();
        for(Position p: moveArea) {
            if (pos.equals(p)) {
                curPosition.setX(pos.getX());
                curPosition.setY(pos.getY());
                return true;
            }
        }
        return false;
    }

    @Override
    boolean attack(Position pos) {
        calAttackArea();
        for(Position p: attackArea) {
            if (pos.equals(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    ArrayList<Position> calDamageArea(Position pos) {
        ArrayList<Position> damageArea = new ArrayList<Position>();
        
        damageArea.add(pos);
        
        int x = curPosition.getX(), y = curPosition.getY();
        int sub_x = pos.getX() - x, sub_y = pos.getY() - y;
        sub_x = (sub_x % 2 == 0) ? sub_x/2 : sub_x*2;
        sub_y = (sub_y % 2 == 0) ? sub_y/2 : sub_y*2;
        
        damageArea.add(new Position(x + sub_x, y + sub_y));
        
        return damageArea;
    }
}

