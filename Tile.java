
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Tile extends DrawInterface {
    public static final int TILEWIDTH = 80;
    Tile(int x, int y) {
	this.x = x;
	this.y = y;
        BufferedImageLoader loader = new BufferedImageLoader();
	try {
            this.image = loader.loadImage("/tile1.png");
	} catch (IOException e) {
            e.printStackTrace();
	}
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(image, (this.x+2)*TILEWIDTH, this.y*TILEWIDTH, TILEWIDTH, TILEWIDTH, (ImageObserver) this);
    }
}
