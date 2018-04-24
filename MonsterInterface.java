import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class MonsterInterface implements ImageObserver{
    private BufferedImage monsMinion;
    private BufferedImage monsBigMinion;
    public static final int MONSTERWIDTH = 80;
    MonsterInterface(){
        BufferedImageLoader loader = new BufferedImageLoader();		
	try {
            this.monsMinion = loader.loadImage("/monster1.png");
        } catch (IOException e) {
            e.printStackTrace();
	}
		
	try {
            this.monsBigMinion = loader.loadImage("/monster1.png");
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
    public void drawMons(Graphics g, int x, int y, String name) {
    	if (name == "Minion") {
            g.drawImage(monsMinion, (x+2)*MONSTERWIDTH, y*MONSTERWIDTH, MONSTERWIDTH, MONSTERWIDTH, (ImageObserver) this);
    	} else if (name == "BigMinion") {
            g.drawImage(monsBigMinion, (x+2)*MONSTERWIDTH, y*MONSTERWIDTH, MONSTERWIDTH, MONSTERWIDTH, (ImageObserver) this);
    	}
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}