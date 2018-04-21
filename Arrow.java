
import java.util.ArrayList;

public class Arrow extends Hero {
    public Arrow(Position pos) {
        super(pos);
    }
    
    @Override
    void calMoveArea() {
        int x = curPosition.getX();
        int y = curPosition.getY();
        moveArea.clear();
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
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
        Position tmp;
        for(int i = 0; i < Config.GAME_WIDTH; i++) {
            tmp = new Position(i, y);
            attackArea.add(tmp);
        }
        for(int i = 0; i < Config.GAME_HEIGHT; i++) {
            tmp = new Position(x, i);
            attackArea.add(tmp);
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
        
        return damageArea;
    }
}

