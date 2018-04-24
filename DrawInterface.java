
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public abstract class DrawInterface  implements ImageObserver  {
    protected int x;
    protected int y;
    protected BufferedImage image;
    protected String imageLink;
    public static final int WIDTH = 80;
    
    DrawInterface(int x, int y, String imageLink){
        this.x = x;
	this.y = y;		
	BufferedImageLoader loader = new BufferedImageLoader();
	try {
            this.image = loader.loadImage(imageLink);
            System.out.println("Call");
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
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
    
    public void draw(Graphics g){
        g.drawImage(image, (this.x+2)*WIDTH, this.y*WIDTH, WIDTH, WIDTH, (ImageObserver) this);
    };
}
