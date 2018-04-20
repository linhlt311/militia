public class MapLV1 extends Map {
     
    MapLV1() {
        super();
        board[1][1] = Symbol.MINION;
        monsters.add(new Minion(new Position(1, 1)));
        
        board[1][3] = Symbol.MINION;
        monsters.add(new Minion(new Position(1, 3)));
        
        board[1][6] = Symbol.SWORD;
        heros.add(new Sword(new Position(1, 6)));
        
        board[5][2] = Symbol.BIG_MINION;
        monsters.add(new BigMinion(new Position(5, 2)));
        
        board[6][4] = Symbol.SPEAR;
        heros.add(new Spear(new Position(6, 4)));
    }
    
    @Override
    void update(Event eventType, Position pos) {}

    @Override
    void random() {
        Minion minion = new Minion(new Position(0, 0));
        BigMinion big_minion = new BigMinion(new Position(0, 0));
        randomUtility(minion, 5);
        randomUtility(big_minion, 1);
    }    
}
