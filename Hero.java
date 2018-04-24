import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

abstract class Hero {
    protected Position curPosition;
    protected ArrayList<Position> moveArea;
    protected ArrayList<Position> attackArea;
    private State state;
    protected DrawTile heroImage;
    protected DrawTile moveAreaTile;
    protected DrawTile attackAreaTile;
    
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
        moveAreaTile = new DrawTile("/move-tile.png");
        attackAreaTile = new DrawTile("/attack-tile.png");
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
    
    public void draw(Graphics g) {
    	this.heroImage.setX(this.curPosition.getX()+1);
    	this.heroImage.setY(this.curPosition.getY()+1);
    	this.heroImage.draw(g);
    }
    
    public void drawMoveArea(Graphics g) {
    	for(Position pos: moveArea) {
    		this.moveAreaTile.setX(pos.getX()+1);
    		this.moveAreaTile.setY(pos.getY()+1);
    		this.moveAreaTile.draw(g);
    	}
    }
    
    public void drawAttackArea(Graphics g) {
    	for(Position pos: attackArea) {
    		this.attackAreaTile.setX(pos.getX()+1);
    		this.attackAreaTile.setY(pos.getY()+1);
    		this.attackAreaTile.draw(g);
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
    abstract ArrayList<Position> calDamageArea(Position pos);
}
