import java.util.ArrayList;

abstract class Map {
    ArrayList<Hero> heros;
    ArrayList<Monster> monsters;
    protected char[][] board;
    protected enum Event {
        HERO_MOVE,
        HERO_ATTACK,
        MONSTER_MOVE
    }
    
    Map() {
        board = new char[Config.GAME_WIDTH][Config.GAME_HEIGHT];
        for(int i = 0; i < Config.GAME_WIDTH; i++) {
            for(int j = 0; j < Config.GAME_HEIGHT; j++) {
                board[i][j] = '-';
            }
        }
        
        heros = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
    }
    
    /**
     * Use this function for test
     */
    protected void draw() {
        for(int i = 0; i < Config.GAME_WIDTH; i++) {
            for(int j = 0; j < Config.GAME_HEIGHT; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    public Hero getHero(int x, int y) {
        Position pos = new Position(x, y);
        
        for(Hero hero: heros) {
            if(hero.curPosition.equals(pos))
                return hero;
        }
        return null;
    }
    
    abstract void update(Event eventType, Position pos);
    abstract void random();
}