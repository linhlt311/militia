
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
public class Background implements ImageObserver {
    private BufferedImage bg;
    Background(){
             BufferedImageLoader loader = new BufferedImageLoader();
		try {
			this.bg = loader.loadImage("/game-background.png");
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
