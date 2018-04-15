
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
public class Bracket implements ImageObserver {
        private int x;
	private int y;
	private BufferedImage bracket;
        public static final int BRACKETWIDTH = 80;
	
	Bracket(int x, int y) {
		this.x = x;
		this.y = y;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			this.bracket = loader.loadImage("/1.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
        
        public void setX(int x){
            this.x = x;
        }
        
        public void setY(int y){
            this.y = y;
        }
	
	public BufferedImage getBracketSprite() {
		return bracket;
	}
        
        public void drawBracket(Graphics g) {
            g.drawImage(bracket, (this.x+2)*BRACKETWIDTH, this.y*BRACKETWIDTH, BRACKETWIDTH, BRACKETWIDTH, (ImageObserver) this);
	}
        
        @Override
        public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
}
