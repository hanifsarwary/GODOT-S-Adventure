package settings;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Obstacle {
	float x = 0;
	private Image i;
	private float backGroundX;
	
	Obstacle(){
	}
	
	public float getX(){ return x; }
	public float getY(){ return 300; }
	
	public void setX(float xx){ backGroundX = xx; }
	
	public void draw(){
		i.draw(backGroundX + x, 300, 0.4f);
	}
	
	public void setImage(Image t){
		i = t;
	}
}
