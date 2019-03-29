package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Boss extends Enemy {

	private boolean isGoingUp = true;
	private boolean isGoingDown = false;
	
	public Boss(int maxLength) throws SlickException {
		super(maxLength);
		x = 250;
	}

	@Override
	public boolean hit(float x, float y) {
		return false;
	}

	@Override
	public void display(GameContainer gc, int delta) {
		
		if(getDestroyed()){
			return;
		}
		
		if(isGoingUp){
			this.setY(getY() - (float)(0.1 * delta));
			
			if(this.getY() <= 80){
				isGoingUp = false;
				isGoingDown = true;
			}
		}
		else if(isGoingDown){
			this.setY(this.getY() + (float)(0.1 * delta));
			
			if(this.getY() >= 220){
				this.isGoingDown = false;
				this.isGoingUp = true;
				this.setY(220);
			}
		}
	}
	
	public void display(){
		if(getDestroyed()){
			
			if(xo < 100){
				this.getCurrentImage().draw(backGroundX + getX(), getY(), 0.5f);
				xo++;
			}
			
			return;
		}
		else{
			this.getCurrentImage().draw(backGroundX + getX(), getY(), 0.5f);
		}
	}
}
