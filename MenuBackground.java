import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class MenuBackground extends DrawInterface implements ImageObserver {

    public MenuBackground() {
        super(0, 0, "/menu-background1.png");
    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, Game.WIDTH*Game.SCALE+200, Game.HEIGHT*Game.SCALE, this);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
