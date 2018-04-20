import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private static char[][] board;
    private static int X, Y;
    public static ArrayList<Hero> heros;
    private static ArrayList<Monster> monsters;
    
    Board(int X, int Y) {
        this.X = X; this.Y = Y;
        heros = new ArrayList<Hero> ();
        monsters = new ArrayList<Monster> ();
        
        board = new char[X][Y];
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++)
                board[i][j] = '-';
        }
    }
    
    void random(int swordNumber, int minionNumber) {
        int total = swordNumber + minionNumber;
        int []rand = new Random().ints(0, X*Y)
                    .distinct()
                    .limit(total).toArray();
        
        for(int i = 0; i < swordNumber; i++) {
            int y = rand[i]%Y;
            int x = (rand[i] - y)/Y;
            //System.out.println(Integer.toString(rand[i])+','+x+','+y);
            heros.add(new Sword(new Position(x, y)));
            board[x][y] = 'S';
        }
        
        for(int i = swordNumber; i < total; i++) {
            int y = rand[i]%Y;
            int x = (rand[i] - y)/Y;
            monsters.add(new Minion(new Position(x, y)));
            board[x][y] = 'M';
        }
    }
    
    void draw() {
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
    
    enum Event {
        HERO_MOVE,
        HERO_ATTACK,
        MONS_MOVE
    }
    
    // update board atfer each event
    void update(Event event, Position pos) {
        switch(event) {
            case HERO_MOVE:
                board[pos.getX()][pos.getY()] = 'S';
                Minion minion_1 = new Minion(pos);
                if (monsters.contains(minion_1)) monsters.remove(minion_1);
                break;
            case HERO_ATTACK:
                Minion minion_2 = new Minion(pos);
                if (monsters.contains(minion_2)) {
                    monsters.remove(minion_2);
                    board[pos.getX()][pos.getY()] = '-';
                }
                break;
            case MONS_MOVE:
                board[pos.getX()][pos.getY()] = 'M';
                Sword sword = new Sword(pos);
                if (heros.contains(sword)) heros.remove(sword);
                break;
            default:
                break;
        }
        
        draw();
    }
    
    public Hero getHero(int x, int y) {
        Position tmp = new Position(x, y);
        for(Hero hero: heros) {
            if (hero.curPosition.equals(tmp))
                    return hero;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Sword (S) move area is 5*5 and attack area is 3*3");
        System.out.println("Minion (M) move random (Up, Down, Left, Right)");
        System.out.println("-------------> y");
        System.out.println("|");
        System.out.println("|   TRUC");
        System.out.println("|   TOA");
        System.out.println("|   DO");
        System.out.println("|");
        System.out.println("V");
        System.out.println("x");
        
        Board board = new Board(8, 8);
        board.random(0, 1);
        board.draw();
        
        int x;
        int y;
        Position tmp;
        
        //Game Loop-------------------------------------------------------------
        do {
            for(Hero sword: heros) {
                // move sword
                board.board[sword.curPosition.getX()][sword.curPosition.getY()] = '-';
                
                System.out.println("Move sword in" + '(' + 
                        Integer.toString(sword.curPosition.getX()) + ',' + 
                        sword.curPosition.getY() + ')');
                
                do {
                    System.out.print("Enter x: ");
                    x = in.nextInt();
                    System.out.print("Enter y: ");
                    y = in.nextInt();
                    tmp = new Position(x, y);
                    
                    // check valid position
                    // print notification
                    
                } while(!sword.move(tmp));
                
                board.update(Event.HERO_MOVE, tmp);
                if(monsters.isEmpty()) break;
                
                // sword attack
                System.out.println("Attack by sword in" + '(' + 
                        Integer.toString(sword.curPosition.getX()) + ',' + 
                        sword.curPosition.getY() + ')');
                
                do {
                    System.out.print("Enter x: ");
                    x = in.nextInt();
                    System.out.print("Enter y: ");
                    y = in.nextInt();
                    tmp = new Position(x, y);
                    
                    // check valid position
                    // print notification
                    
                } while(!sword.attack(tmp));
                
                board.update(Event.HERO_ATTACK, tmp);
                if(monsters.isEmpty()) break;
            }
            
            for(Monster minion: monsters) {
                board.board[minion.curPosition.getX()][minion.curPosition.getY()] = '-';
                minion.move();
                tmp = new Position(minion.curPosition.getX(),
                                   minion.curPosition.getY());
                board.update(Event.MONS_MOVE, tmp);
            }
        } while(!(monsters.isEmpty() || heros.isEmpty()));
        
        //----------------------------------------------------------------------
        
        //----------------------------------------------------------------------
        if(monsters.isEmpty()) System.out.println("You win");
        else System.out.println("Stupid");
    }
}
