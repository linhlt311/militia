
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MONMON
 */
public class Bracket extends DrawInterface implements ImageObserver {
        public static final int BRACKETWIDTH = 80;
	Bracket(int x, int y) {
		this.x = x;
		this.y = y;		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
                    this.image = loader.loadImage("/bracket.png");
		} catch (IOException e) {
                    e.printStackTrace();
		}
	}       
        @Override
        public void draw(Graphics g) {
            g.drawImage(image, (this.x+2)*BRACKETWIDTH, this.y*BRACKETWIDTH, BRACKETWIDTH, BRACKETWIDTH, (ImageObserver) this);
	}

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
