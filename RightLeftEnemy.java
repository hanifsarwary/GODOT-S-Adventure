package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

public class RightLeftEnemy extends Enemy{

	private boolean isGoingRight = true;
	private boolean isGoingLeft = false;
	private int startX = 0;
	
	public RightLeftEnemy(int maxLength) throws SlickException {
		super(maxLength);
		startX = (int)getX();
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
		
		if(isGoingRight){
			this.setX(getX() + (float)(0.1 * delta));
			
			if(this.getX() >= startX + 100){
				isGoingRight = false;
				isGoingLeft = true;
			}
		}
		else if(isGoingLeft){
			this.setX(this.getX() - (float)(0.1 * delta));
			
			if(this.getX() <= startX - 100){
				this.isGoingLeft = false;
				this.isGoingRight = true;
			}
		}
	}
	
	@Override
	public void setBoundingBox(){
		
		if(getDestroyed()){
			return;
		}
		
		if(boundingBox == null)
    		boundingBox = new Circle(x, y, 0.2f);
		
		boundingBox.setX(backGroundX + x);
    	boundingBox.setY(y);
	}
	
	public void display(){

		if(getDestroyed()){
			
			if(xo < 100){
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
