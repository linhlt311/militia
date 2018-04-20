
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class DrawInterface {
    protected int x;
    protected int y;
    protected BufferedImage image;
    public int getX() {
	return this.x;
    }
	
    public int getY() {
	return this.y;
    }    
     
    public void setX(int x){
        this.x = x;
    }
        
    public void setY(int y){
        this.y = y;
    }
    
    public BufferedImage getSprite() {
        return image;
    }
    
    abstract void draw(Graphics g);

}
