
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class TileGrid extends DrawInterface implements ImageObserver {
    private int total;
    private Tile tiles[];
    public static final int TILEWIDTH = 80;
    TileGrid(int x, int y) {
        this.total = x*y;
        int count = 0;
        tiles = new Tile[total];
        for(int i = 0; i < x ; i++){
            for(int j = 0; j < y; j++) {
                tiles[count] = new Tile(i+3, j+1);
                count++;
            }
        }
    }
//    public void drawGrid(Graphics g) {
//	for(int i = 0; i < total; i++) {
//            this.image = tiles[i].getSprite();
//            g.drawImage(image, tiles[i].getX()*TILEWIDTH, tiles[i].getY()*TILEWIDTH, TILEWIDTH, TILEWIDTH, this);
//	}
//    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void draw(Graphics g) {
        for(int i = 0; i < total; i++) {
            this.image = tiles[i].getSprite();
            g.drawImage(image, tiles[i].getX()*TILEWIDTH, tiles[i].getY()*TILEWIDTH, TILEWIDTH, TILEWIDTH, this);
	}
    }
}
