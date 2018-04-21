import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

public class HeroInterface implements ImageObserver {
	private BufferedImage heroSword;
	private BufferedImage heroSpear;
	private BufferedImage moveInterface;
	private BufferedImage attackInterface;
        public static final int HEROWIDTH = 80;
	
	HeroInterface() {		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			this.moveInterface = loader.loadImage("/move-tile.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.attackInterface = loader.loadImage("/tile2.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.heroSword = loader.loadImage("/short_sword.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.heroSpear = loader.loadImage("/spear3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
    public void drawHero(Graphics g, int x, int y, String name) {
    	if (name == "Sword") {
            g.drawImage(heroSword, (x+2)*HEROWIDTH, y*HEROWIDTH, HEROWIDTH, HEROWIDTH, (ImageObserver) this);
    	} else if (name == "Spear") {
            g.drawImage(heroSpear, (x+2)*HEROWIDTH, y*HEROWIDTH, HEROWIDTH, HEROWIDTH, (ImageObserver) this);
    	}
	}
    
    public void drawMoveArea(Graphics g, ArrayList<Position> positions) {
    	for(Position pos: positions) {
    		g.drawImage(moveInterface, (pos.getX()+3)*HEROWIDTH, (pos.getY()+1)*HEROWIDTH, HEROWIDTH, HEROWIDTH, (ImageObserver) this);
    	}
    }
    
    public void drawAttackArea(Graphics g, ArrayList<Position> positions) {
    	for(Position pos: positions) {
    		g.drawImage(attackInterface, (pos.getX()+3)*HEROWIDTH, (pos.getY()+1)*HEROWIDTH, HEROWIDTH, HEROWIDTH, (ImageObserver) this);
    	}
    }
         
        @Override
        public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
}
