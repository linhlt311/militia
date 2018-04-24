import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;


public class LoadingBackground extends DrawInterface implements ImageObserver {
	
	public LoadingBackground() {
        super(0, 0, "/loading-background.jpg");
    }
	
	@Override
    public void draw(Graphics g) {
         g.drawImage(image, 0, 0, Game.WIDTH*Game.SCALE+200, Game.HEIGHT*Game.SCALE, this);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
