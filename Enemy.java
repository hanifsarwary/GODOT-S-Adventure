package settings;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public abstract class Enemy extends Character{

	private boolean isDestroyed = false;
	protected float backGroundX;
	protected Image dead;
	protected int xo = 0;
	
	public Enemy(int maxLength) throws SlickException{
		// TODO Auto-generated constructor stub
		super("");
		dead = new Image("//images/engd.png");
	}
	
	public void setBackGroundX(float b){
		backGroundX = b;
	}
	
	public int getTotalX(){
		return ((int)backGroundX + (int)getX());
	}
	
	@Override
	public float getX(){
		if(isDestroyed)
			return -10000;
		else
			return super.getX();
	}
	
	@Override
	public float getY(){
		if(isDestroyed)
			return -10000;
		else
			return super.getY();
	}
	
	public boolean getDestroyed(){ return isDestroyed; }
	public abstract boolean hit(float x, float y);
	
	public void destroy(Sound s){
		s.play(1f, 1f);
		s.play();
		
		setCurrentImage(dead);
		
		isDestroyed = true;
	}
}
