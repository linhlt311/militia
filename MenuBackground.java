import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class MenuBackground extends DrawInterface implements ImageObserver {
    MenuBackground(){
            BufferedImageLoader loader = new BufferedImageLoader();
		try {
			this.image = loader.loadImage("/menu-background1.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
        }
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, Game.WIDTH*Game.SCALE+200, Game.HEIGHT*Game.SCALE, this);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
