import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class MenuBackground implements ImageObserver {
    private BufferedImage bg;
    MenuBackground(){
             BufferedImageLoader loader = new BufferedImageLoader();
		try {
			this.bg = loader.loadImage("/menu-background1.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
        }
    public void drawBackground(Graphics g) {
            g.drawImage(bg, 0, 0, Game.WIDTH*Game.SCALE+200, Game.HEIGHT*Game.SCALE, this);
	}

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
