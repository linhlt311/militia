import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private static char[][] board;
    private static int X, Y;
    private static ArrayList<Sword> swords;
    private static ArrayList<Minion> minions;
    private static ArrayList<Position> list_hero;
    private static ArrayList<Position> list_mons;
    
    Board(int X, int Y) {
        this.X = X; this.Y = Y;
        swords = new ArrayList<Sword> ();
        minions = new ArrayList<Minion> ();
        list_hero = new ArrayList<Position> ();
        list_mons = new ArrayList<Position> ();
        
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
            swords.add(new Sword(new Position(x, y)));
            board[x][y] = 'S';
        }
        
        for(int i = swordNumber; i < total; i++) {
            int y = rand[i]%Y;
            int x = (rand[i] - y)/Y;
            minions.add(new Minion(new Position(x, y)));
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
    
    // update board afer each event
    void update(Event event, Position pos) {
        switch(event) {
            case HERO_MOVE:
                board[pos.getX()][pos.getY()] = 'S';
                if (list_mons.contains(pos)) list_mons.remove(pos);
                break;
            case HERO_ATTACK:
                if (list_mons.contains(pos)) {
                    list_mons.remove(pos);
                    board[pos.getX()][pos.getY()] = '-';
                }
                break;
            case MONS_MOVE:
                board[pos.getX()][pos.getY()] = 'M';
                if (list_hero.contains(pos)) list_hero.remove(pos);
                break;
            default:
                break;
        }
        
        draw();
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
        board.random(2, 1);
        board.draw();
        
        int x;
        int y;
        Position tmp;
        
        // get list position of hero and monster
        //----------------------------------------------------------------------
        for(Sword sword: swords) {
            tmp = new Position(sword.curPosition.getX(), sword.curPosition.getY());
            list_hero.add(tmp);
        }
     
        for(Minion minion: minions) {
            tmp = new Position(minion.curPosition.getX(), minion.curPosition.getY());
            list_mons.add(tmp);
        }
        //----------------------------------------------------------------------
        
        //Game Loop-------------------------------------------------------------
        do {
            if (list_hero.isEmpty()) break;
            for(Sword sword: swords) {
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
                if(list_mons.isEmpty()) break;
                
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
                if(list_mons.isEmpty()) break;
            }
            
            if(list_mons.isEmpty()) break;
            for(Minion minion: minions) {
                minion.move();
                tmp = new Position(minion.curPosition.getX(),
                                   minion.curPosition.getY());
                board.update(Event.MONS_MOVE, tmp);
            }
        } while(!(list_mons.isEmpty() || list_hero.isEmpty()));
        
        //----------------------------------------------------------------------
        
        //----------------------------------------------------------------------
        if(list_mons.isEmpty()) System.out.println("You win");
        else System.out.println("Stupid");
    }
}
