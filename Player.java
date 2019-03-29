package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Sound;

public class Player extends Character {

	private Weapon w;
	private int score = 0;
	
	public int getScore(){ return score; }; 
	public void setScore(int s){ score = s; }
	
	public Player(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		health = 100;
	}
	
	public void setWeapon(Weapon ww){
		w = ww;
	}

	@Override
	public void display(GameContainer gc, int delta) {
		// TODO Auto-generated method stub
		
		if(getGoingUp()){
			setY(getY() - (float)(0.4 * delta));
			
			if(getY() <= 170){
				setGoingUp(false);
				setGoingDown(true);
			}
		}
		else if(getGoingDown()){
			setY(getY() + (float)(0.4 * delta));
			
			if(getY() >= 330){
				setGoingDown(false);
				setIsJumping(false);
				setY(330);
			}
		}
	}
	
	private boolean isGoingRight = false;
	
	public void setRight(){
		isGoingRight = true;
	}
	
	public void setLeft(){
		isGoingRight = false;
	}
	
	public void hit(Sound s){
		w.hit(isGoingRight, s);
	}
	
	public boolean getRight(){ return isGoingRight; }
	
	public Weapon getWeapon(){ return w; }
	
	public void display(){
		this.getCurrentImage().draw(this.getX(), this.getY(), 0.2f);
		if(w != null){
			w.draw(Main.IS_HIT, isGoingRight, getX(), getY(), Main.HIT);
		}
	}

}
