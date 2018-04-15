

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class TileGrid implements ImageObserver {
	private BufferedImage tile;
	private int total;
	private Tile tiles[];
	public static final int TILEWIDTH = 80;
	
	TileGrid(int x, int y) {
		this.total = x*y;
		int count = 0;
		tiles = new Tile[total];
		for(int i = 0; i < x ; i++)
			for(int j = 0; j < y; j++) {
				tiles[count] = new Tile(i+3, j+1);
				count++;
			}
	}
	
	public void drawGrid(Graphics g) {
		for(int i = 0; i < total; i++) {
			this.tile = tiles[i].getTileSprite();
			g.drawImage(tile, tiles[i].getX()*TILEWIDTH, tiles[i].getY()*TILEWIDTH, TILEWIDTH, TILEWIDTH, this);
		}
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
}
