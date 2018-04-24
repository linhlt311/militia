import java.awt.Graphics;

public class HeroAction {
	
	private Hero activeHero;
	private HeroInterface heroInterface = new HeroInterface();
	private Graphics g;
	
	public void update(Hero hero, Graphics g) {
		this.g = g;
		this.activeHero = hero;
	}
	
	public void showMoveArea() {
		if (this.activeHero != null && this.activeHero.getState() == Hero.State.SELECTING) {
			this.activeHero.calMoveArea();
	        heroInterface.drawMoveArea(this.g, activeHero.moveArea);
		}
	}
	
	public void showAttackArea() {
		if (this.activeHero != null && this.activeHero.getState() == Hero.State.MOVED) {
			this.activeHero.calAttackArea();
			heroInterface.drawAttackArea(this.g, activeHero.attackArea);
		}
	}
	
}
