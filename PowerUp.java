package settings;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PowerUp {
	float x = 0;
	private Image i;
	private float backGroundX;
	boolean isDone = true;
	
	PowerUp()throws SlickException{
		i = new Image("//images/prpg.png");
	}
	
	public float getX(){ return x; }
	public float getY(){ return 280; }
	
	public void setX(float xx){
		
		if(!isDone)
			return;
		
		backGroundX = xx;
	}
	
	public void draw(){
		
		if(!isDone){
			return;
		}
		
		i.draw(backGroundX + x, 280, 0.2f);
	}
	
	public void setImage(Image y){
		i = y;
	}
	
	public void reapAdvantage(Player p){
		p.updateHealth(p.getHealth() + 20);
		isDone = false;
		
		x = -10000;
		backGroundX = -10000;
	}
}
