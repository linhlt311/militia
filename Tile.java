import java.awt.Image;

public class Tile extends DrawInterface {
    public Tile(int x, int y) {
        super(x, y, "/tile1.png");
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
