import java.awt.Graphics;

public class HeroAction {
	
	private Hero activeHero;
	private Graphics g;
	
	public void update(Hero hero, Graphics g) {
		this.g = g;
		this.activeHero = hero;
	}
	
	public void showMoveArea() {
		if (this.activeHero != null && this.activeHero.getState() == Hero.State.SELECTING) {
			this.activeHero.calMoveArea();
	        this.activeHero.drawMoveArea(g);
		}
	}
	
	public void showAttackArea() {
		if (this.activeHero != null && this.activeHero.getState() == Hero.State.MOVED) {
			this.activeHero.calAttackArea();
			this.activeHero.drawAttackArea(g);
		}
	}
	
}
