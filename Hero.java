import java.awt.image.BufferedImage;
import java.util.ArrayList;

abstract class Hero {
    protected Position curPosition;
    protected ArrayList<Position> moveArea;
    protected ArrayList<Position> attackArea;
    private State state;
    protected DrawTile heroImage;
    
    public enum State {
        UNSELECT,
        SELECTING,
        MOVING,
        MOVED,
        ATTACKING,
        DONE
    }
    
    Hero(Position pos) {
        curPosition = new Position(pos.getX(), pos.getY());
        moveArea = new ArrayList<Position> ();
        attackArea = new ArrayList<Position> ();
        state = State.UNSELECT;
    }
    
    public void setState(State state) { this.state = state; }
    public State getState() { return state; }
    
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
    
    public ArrayList<Position> getMoveArea() {
       calMoveArea();
       return moveArea;
    }
    
    public ArrayList<Position> getAttackArea() {
        calAttackArea();
        return attackArea;
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
    abstract ArrayList<Position> calDamageArea(Position pos);
}
