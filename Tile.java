package com.game.src.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {
	private int x;
	private int y;
	private BufferedImage tile;
	
	Tile(int x, int y) {
		this.x = x;
		this.y = y;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			this.tile = loader.loadImage("/tile1.png");
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
	
	public BufferedImage getTileSprite() {
		return tile;
	}
}
