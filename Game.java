
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public static final int ROWS = 8;
	public static final int LINES = 8;
    public static boolean bracketboo = false;
	public final String TITLE = "Militia";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private TileGrid grid;
    private Bracket bracket = new Bracket(0,0);
	
	public void init() {
		grid = new TileGrid(ROWS, LINES);
	}
	
	private synchronized void start() {
		if (running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() throws InterruptedException {
		if (!running) {
			return;
		}
		
		running = false;
		thread.join();
		System.exit(1);
	}

	@Override
	public void run() {
		init();
		int secs = 0;
		int frames = 0;
		while (running) {
			frames++;
			if (frames % 20 == 0) {
//				System.out.println(++secs);
			}
			render();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		grid.drawGrid(g);
		if(bracketboo){
            bracket.drawBracket(g);
        }
		//////////////////////////////
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		game.addMouseListener(new MouseAdapter() {
			// provides empty implementation of all
            // MouseListener`s methods, allowing us to
            // override only those which interests us
			@Override //I override only one method for presentation
			public void mousePressed(MouseEvent e) {
				int x = (int)(e.getX()/80) - 2;
				int y = (int)(e.getY()/80);
                                if (1<=x && 8>=x && 1<=y && 8>=y)
                                {
                                    bracketboo = true;
                                    System.out.println(x + "," + y);
                                    game.bracket.setX(x);
                                    game.bracket.setY(y);
                                }
			}
		});
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
		
		// Start game
		game.start();

	}


}
