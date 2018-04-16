
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MONMON
 */
public class Menu {
    public Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 200, 100, 50);
    public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 300, 100, 50);
    public void render (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font fn1 = new Font("arial", Font.BOLD, 100);
        g.setFont(fn1);
        g.setColor(Color.black);
        g.drawString("MILITIA", Game.WIDTH / 2, 150);
        g2d.draw(playButton);
        g2d.draw(quitButton);
    }
}
