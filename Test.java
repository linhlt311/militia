import java.util.ArrayList;
import java.util.Random;

public class Test {
    // define custom exception
   static class MoveAreaException extends Exception {
       MoveAreaException(String message) {
           super(message);
       }    
   }
   
   static class AttackAreaException extends Exception {
       AttackAreaException(String message) {
           super(message);
       }    
   }
   
   static class MoveException extends Exception {
       MoveException(String message) {
           super(message);
       }    
   }
   
   static void TestHero(Hero hero, int moveAreaSize, int attackAreaSize) 
    throws MoveAreaException, AttackAreaException, MoveException {
       
      hero.calMoveArea();
      hero.calAttackArea();
      
      ArrayList<Position> heroMoveArea = hero.moveArea;
      if(!(heroMoveArea.size() == moveAreaSize)) 
          throw new MoveAreaException("Recalculate move area");
      
      ArrayList<Position> heroAttackArea = hero.attackArea;
      if(!(heroAttackArea.size() == attackAreaSize)) 
          throw new AttackAreaException("Recalculate attack area");
      
      int movIndex = new Random().nextInt(moveAreaSize);
      hero.move(heroMoveArea.get(movIndex));
      
      if (!hero.curPosition.equals(heroMoveArea.get(movIndex))) 
          throw new MoveException("Rewrite move function");
   }
   
   public static void main(String[] args) {
       // Test spear
       
       // Middle case
//       Spear spear_2_2 = new Spear(new Position(2, 2));
//       try {
//           TestHero(spear_2_2, 25, 8);
//           System.out.println("Pass Spear(2, 2)");
//       } catch (MoveAreaException e) {
//           e.printStackTrace();
//       } catch (AttackAreaException e) {
//           e.printStackTrace();
//       } catch (MoveException e) {
//           e.printStackTrace();
//       }
//       
//       // Corner case
//       Spear spear_0_0 = new Spear(new Position(0, 0));
//       try {
//           TestHero(spear_0_0, 9, 2);
//           System.out.println("Pass Spear(0, 0)");
//       } catch (MoveAreaException e) {
//           e.printStackTrace();
//       } catch (AttackAreaException e) {
//           e.printStackTrace();
//       } catch (MoveException e) {
//           e.printStackTrace();
//       }
        Sword sword = new Sword(new Position(2, 2));
        Spear spear = new Spear(new Position(2, 2));
        ArrayList<Hero> list_hero = new ArrayList<Hero> ();
        list_hero.add(sword);
        if(!list_hero.contains(spear)) list_hero.add(spear);
        System.out.println(list_hero.size());
        //if(sword.equals(spear)) System.out.println("ok");
   }
}
