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
        
        random();
    }
    
    @Override
    void update(Event eventType, Position pos) {
    	switch(eventType) {
	        case SWORD_MOVE:
	            board[pos.getX()][pos.getY()] = Symbol.SWORD;
	            Sword sw1 = new Sword(pos);
	            Minion m1 = new Minion(pos);
	            if (monsters.contains(m1)) monsters.remove(m1);
	            BigMinion bm1 = new BigMinion(pos);
	            if (monsters.contains(bm1)) heros.remove(sw1);
	            break;
	        case SWORD_ATTACK:
	            Minion m2 = new Minion(pos);
	            if (monsters.contains(m2)) {
	                monsters.remove(m2);
	                board[pos.getX()][pos.getY()] = Symbol.DEFAULT;
	            }
	            BigMinion bm2 = new BigMinion(pos);
	            if (monsters.contains(bm2)) {
	                int shield = bm2.getShield();
	                if (shield == 0) {
	                	monsters.remove(bm2);
	                	board[pos.getX()][pos.getY()] = Symbol.DEFAULT;
	                } else {
	                	bm2.lowerShield();
	                }                
	            }
	            break;
	        case SPEAR_MOVE:
	            board[pos.getX()][pos.getY()] = Symbol.SPEAR;
	            Sword sp1 = new Sword(pos);
	            Minion m3 = new Minion(pos);
	            if (monsters.contains(m3)) monsters.remove(m3);
	            BigMinion bm3 = new BigMinion(pos);
	            if (monsters.contains(bm3)) heros.remove(sp1);
	            break;
	        case SPEAR_ATTACK:
//	            Minion m4 = new Minion(pos);
//	            if (monsters.contains(m2)) {
//	                monsters.remove(m2);
//	                board[pos.getX()][pos.getY()] = Symbol.DEFAULT;
//	            }
//	            Minion m5 = new Minion(pos);
//	            if (monsters.contains(m5)) {
//	                monsters.remove(m5);
//	                board[pos.getX()][pos.getY()] = Symbol.DEFAULT;
//	            }
//	            BigMinion bm2 = new BigMinion(pos);
//	            if (monsters.contains(bm2)) {
//	                int shield = bm2.getShield();
//	                if (shield == 0) {
//	                	monsters.remove(bm2);
//	                	board[pos.getX()][pos.getY()] = Symbol.DEFAULT;
//	                } else {
//	                	bm2.lowerShield();
//	                }                
//	            }
//	            break;
	        case MINION_MOVE:
	            board[pos.getX()][pos.getY()] = Symbol.MINION;
	            Sword sw3 = new Sword(pos);
	            if (heros.contains(sw3)) heros.remove(sw3);
	            Spear sp3 = new Spear(pos);
	            if (heros.contains(sp3)) heros.remove(sp3);
	            break;
	        case BIG_MINION_MOVE:
	            board[pos.getX()][pos.getY()] = Symbol.BIG_MINION;
	            Sword sw4 = new Sword(pos);
	            if (heros.contains(sw4)) heros.remove(sw4);
	            Spear sp4 = new Spear(pos);
	            if (heros.contains(sp4)) heros.remove(sp4);
	            break;
	        default:
	            break;
    	}
    	draw();
    }

    @Override
    void random() {
        Minion minion = new Minion(new Position(0, 0));
        BigMinion big_minion = new BigMinion(new Position(0, 0));
        randomUtility(minion, 5);
        randomUtility(big_minion, 1);
    }    
}
