import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

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

    private TileGrid grid;
    private Background bg = new Background();
    private MenuBackground menuBg;
    private Bracket bracket = new Bracket(0, 0);
    public static enum STATE{
        MENU,
        GAME
    }
    public static STATE State = STATE.MENU;
    public static enum PLAYSTATE {
    	HERO,
    	MONSTER
    }
    public static PLAYSTATE Playstate = PLAYSTATE.HERO;
    public static MenuButton menuButton;
    public MapLV1 maplv1;
    public static HeroInterface heroInterface;
    private Hero activeHero;
    private HeroAction heroAction;
    
	public void init() {
            grid = new TileGrid(ROWS, LINES);
            this.addMouseListener(new MouseInput());
            menuButton = new MenuButton();
            menuBg = new MenuBackground();
            maplv1 = new MapLV1();
            heroInterface = new HeroInterface();
            heroAction = new HeroAction();
            Playstate = PLAYSTATE.HERO;
            activeHero = null;
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

		if (State == STATE.GAME){
			bg.draw(g);
//		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            grid.draw(g);
            menuButton.drawMenuInGame(g);                  
//          draw monster and hero
            
            //Hero action
            
            if (Game.Playstate == PLAYSTATE.HERO) {
            	heroAction.update(activeHero, g);
                heroAction.showMoveArea();
                heroAction.showAttackArea();
            }
            
            //End hero action
            
            for(Hero hero: maplv1.heros) {
  	           Game.heroInterface.drawHero(g, hero.curPosition.getX()+1, hero.curPosition.getY()+1, hero.getClass().getSimpleName());
            }
         
            //Monster action
            
            //End monster action
            
            ////////////////////////
            if(bracketboo){
            	bracket.draw(g);
            }
		}
        else if(State == STATE.MENU){
            menuBg.draw(g);
            menuButton.drawButtons(g);
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
			public void mouseClicked(MouseEvent e) {
                if (State == STATE.GAME) {
                	
                	int x = (int)(e.getX()/80) - 2;
                	int y = (int)(e.getY()/80);
                	/// On click get position
				
                	Hero tmpHero = game.maplv1.getHero(x-1,y-1);
                	if (tmpHero != null && !(game.activeHero != null && game.activeHero.getState() == Hero.State.MOVED)) {
                		if (game.activeHero != null) {
                    		game.activeHero.setState(Hero.State.UNSELECT);
                		}
                		game.activeHero = tmpHero;
                	}
                	if (game.activeHero != null) {
                		if (Game.Playstate == Game.PLAYSTATE.HERO) {
//                    		/////
                    		if (game.activeHero.getState() == Hero.State.MOVED) {
                    			System.out.println("MOVED STATE. Ready to attack");
                    			if (game.activeHero.attack(new Position(x-1, y-1))) {
                    				game.maplv1.update(game.activeHero, Map.Event.HERO_ATTACK, new Position(x-1,y-1));
                        			System.out.println("ATTACKED");
                        			game.activeHero.setState(Hero.State.DONE);
                    			}
                    		} else if (game.activeHero.getState() == Hero.State.UNSELECT) {
                    			System.out.println("UNSELECT STATE");
                    			game.activeHero.setState(Hero.State.SELECTING);
                    		} else if (game.activeHero.getState() == Hero.State.SELECTING) {
                    			System.out.println("SELECTING STATE");
                    			if (game.activeHero.move(new Position(x-1, y-1))) {
                    				game.maplv1.update(game.activeHero, Map.Event.HERO_MOVE, new Position(x-1,y-1));
                    				game.activeHero.setState(Hero.State.MOVED);
                    			}
                    		} else {
                    			System.out.println("Done state");
                    		}
                    		
                    		////
                    		if (game.maplv1.checkEndTurn())
                    			Game.Playstate = PLAYSTATE.MONSTER;
//                    		System.out.println((game.activeHero.getAttackArea().get(0).getX()+1) + "," + (game.activeHero.getAttackArea().get(0).getY()+1));
    					}
                	}				
                	////////////
				
                	//Get click position (not important)
                	if (1<=x && 8>=x && 1<=y && 8>=y)
                    {
                    	bracketboo = true;
//                        System.out.println(x + "," + y);
                        game.bracket.setX(x);
                        game.bracket.setY(y);
                     }
                     else {
                        bracketboo = false;
                     }
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
