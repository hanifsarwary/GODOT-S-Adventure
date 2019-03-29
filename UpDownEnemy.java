package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class UpDownEnemy extends Enemy{

	private boolean isGoingUp = true;
	private boolean isGoingDown = false;
	
	public UpDownEnemy(int maxLength) throws SlickException {
		super(maxLength);
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
			
			if(this.getY() <= 170){
				isGoingUp = false;
				isGoingDown = true;
			}
		}
		else if(isGoingDown){
			this.setY(this.getY() + (float)(0.1 * delta));
			
			if(this.getY() >= 330){
				this.isGoingDown = false;
				this.isGoingUp = true;
				this.setY(330);
			}
		}
	}
	
	public void display(){
		
		if(getDestroyed()){
			
			if(xo < 500){
				this.getCurrentImage().draw(backGroundX + getX(), getY(), 0.2f);
				xo++;
			}
			
			return;
		}
		else{
			this.getCurrentImage().draw(backGroundX + getX(), getY(), 0.2f);
		}
	}
}
