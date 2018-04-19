import java.util.ArrayList;

abstract class Hero {
    protected Position curPosition;
    protected ArrayList<Position> moveArea;
    protected ArrayList<Position> attackArea;
    
    Hero(Position pos) {
        curPosition = new Position(pos.getX(), pos.getY());
        moveArea = new ArrayList<Position> ();
        attackArea = new ArrayList<Position> ();
    }
    
    void getDetail() {
        calMoveArea();
        calAttackArea();
        System.out.println("Vi tri di chuyen");
        for(Position pos: moveArea) {
            System.out.print('('+Integer.toString(pos.getX())+','+pos.getY()+')');
        }
        System.out.println();
        System.out.println("Vi tri tan cong");
        for(Position pos: attackArea) {
            System.out.print('('+Integer.toString(pos.getX())+','+pos.getY()+')');
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Hero) 
            return curPosition.equals(((Hero) o).curPosition);
        return false;
    }
    
    abstract void calMoveArea();
    abstract void calAttackArea();
    abstract boolean move(Position pos);
    abstract boolean attack(Position pos);
}
