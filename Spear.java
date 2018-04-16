public class Spear extends Hero {
    public Spear(Position pos) {
        super(pos);
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
}

