package settings;

import java.util.Random;

import javax.security.auth.Destroyable;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Main3 extends BasicGameState {
	
	private int q = 0;
	private Image backGround;
	private float backGroundX = 0;
	private float totalX = 0;
	private float backGroundEnemy = 0;
	private int lastMove = Character.NORMAL;
	private Player pl;
	private Enemy []en;
	private double maxLength = 22000;
	private float totalSteps = 0;
	private Obstacle [] obs;
	private PowerUp [] pows;
	private int [] pos;
	private int [] obspos;
	private int [] powpos;
	public static Sound HIT;
	public static boolean IS_HIT;
	public static Sound DESTROY;
	private Image gover;
	public Main3(int state) {
		// TODO Auto-generated constructor stub
	}
	
	public void setQ(int q) {
		this.q = q;
	}
	
	public int getQ() { return q; }

	public void render(GameContainer gc,StateBasedGame sbg ,Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		if(pl.getHealth() <1)
		{
			//sbg.enterState(9);
			gover.draw(0,0,800,480);
		}
		else if(pl.getStepCount()>=maxLength) {
			gover=new Image("//images/WinScreen.png");
			gover.draw(0,0,800,480);
		}
		else
		{
		g.drawImage(backGround, backGroundX, 0);
		g.drawString("Health: "+ pl.getHealth(), 630, 0);
		g.drawString("Score: " + pl.getScore(), 100, 0);
		pl.display();
		
		for(int i = 0; i < en.length; i++){
			
			en[i].setBackGroundX(backGroundEnemy + pos[i]);
			obs[i].setX(backGroundEnemy + obspos[i]);
			pows[i].setX(backGroundEnemy + powpos[i]);
			en[i].display();
			obs[i].draw();
			pows[i].draw();
		}
		
		for(int i = 0; i < en.length; i++){
			if(i == 0){
				if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1))) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 400)){
					if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY() + 4000))){
						pl.updateHealth(pl.getHealth() - 0.1);
					}
				}
				
				if(Main.IS_HIT && !en[i].getDestroyed()){
					if(pl.getRight()){
						
						if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1) + 200)) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 470)){
							if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY()))){
								en[i].destroy(Main.DESTROY);
								pl.setScore(pl.getScore() + 50);
							}
						}
					}
					else{
						if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1) + 600)) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 1000)){
							if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY()))){
								en[i].destroy(Main.DESTROY);
								pl.setScore(pl.getScore() + 50);
							}
						}
					}
				}
			}
			else{
				if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1) + 330)) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 400)){
					if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY()))){
						pl.updateHealth(pl.getHealth() - 0.05);
					}
				}
				
				if(Main.IS_HIT && !en[i].getDestroyed()){
					if(pl.getRight()){
						
						if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1) + 400)) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 470)){
							if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY()))){
								en[i].destroy(Main.DESTROY);
								pl.setScore(pl.getScore() + 10);
							}
						}
					}
					else{
						if((((int)en[i].getX() + pos[i]) >= ((int)(totalX * -1) + 230)) && (en[i].getX() + pos[i]) <= ((int)(totalX * -1) + 320)){
							if(((int)en[i].getY()>= (int)(pl.getY() - 70)) && ((int)en[i].getY() <= (int)(pl.getY()))){
								en[i].destroy(Main.DESTROY);
								pl.setScore(pl.getScore() + 10);
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < obs.length; i++){
			
			if((((int)obs[i].getX() + obspos[i]) >= ((int)(totalX * -1) + 200)) && (obs[i].getX() + obspos[i]) <= ((int)(totalX * -1)) + 300){
				if(((int)obs[i].getY()>= (int)(pl.getY() - 70)) && ((int)obs[i].getY() <= (int)(pl.getY() + 70))){
					pl.updateHealth(pl.getHealth() - 0.05);
				}
			}
			
		}
		
		for(int i = 0; i < pows.length; i++){
			
			if((((int)pows[i].getX() + powpos[i]) >= ((int)(totalX * -1) + 330)) && (pows[i].getX() + powpos[i]) <= ((int)(totalX * -1)) + 400){
				if(((int)pows[i].getY()>= (int)(pl.getY() - 70)) && ((int)pows[i].getY() <= (int)(pl.getY() + 200))){
					pows[i].reapAdvantage(pl);
					pl.setScore(pl.getScore() + 5);
				}
			}
			
		}
		}
	}

	public void init(GameContainer arg0,StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
		backGround = new Image("//images/bsg2.png");
		
		gover=new Image("//images/GameOver.png");
		Main.HIT = new Sound("//images/pp.wav");
		Main.DESTROY = new Sound("//images/ppb.wav");
		
		pl = new Player("Jibran");
		pl.setImages(new Image("//images/charp.png"), new Image("//images/charpl1.png"), new Image("//images/charpl2.png"), new Image("//images/charpr1.png"), new Image("//images/charpr2.png"));
		
		Weapon w = new Weapon();
		w.setImages(new Image("//images/sl1.png"), new Image("//images/sl2.png"), new Image("//images/sr1.png"), new Image("//images/sr2.png"));
		pl.setWeapon(w);
		
		en = new Enemy[20];
		pos = new int[20];
		
		obs = new Obstacle[20];
		obspos = new int[20];
		
		pows = new PowerUp[20];
		powpos = new int[20];
		
		for(int i = 0; i < en.length; i++){
			
			obs[i] = new Obstacle();
			obs[i].setImage(new Image("//images/obs1.png"));
			pows[i] = new PowerUp();
			
			
			Random r1 = new Random();
			
			if(i == 0){
				en[i] = new Boss((int) maxLength);
				en[i].setImages(new Image("//images/boss.png"), null, null, null, null);
				
			}
			else{
				if(r1.nextInt(2) == 0){
					en[i] = new UpDownEnemy((int) maxLength);
					en[i].setImages(new Image("//images/engd.png"), null, null, null, null);
					
				}
				else{
					
					en[i] = new RightLeftEnemy((int) maxLength);
					en[i].setImages(new Image("//images/engd.png"), null, null, null, null);
					
				}
			}
			
			Random r = new Random();
			Random r2 = new Random();
			
			if(i == 0){
				pos[i] = 6850;
				obspos[i] = r.nextInt(6200);
				powpos[i] = r2.nextInt(6200);
			}
			else{
				pos[i] = r.nextInt(6200);
				obspos[i] = r.nextInt(6200);
				powpos[i] = r2.nextInt(6200);
			}
		}
	}

	public void update(GameContainer gc,StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		pl.display(gc, delta);
		
		Input input = gc.getInput();
		
		for(int i = 0; i < en.length; i++){
			en[i].display(gc, delta);
		}
		if(input.isKeyDown(input.KEY_BACK)) {
			sbg.enterState(5);
		}
		if(totalSteps < 0){
			
			playerRight(input, delta);
			return;
		}
		else if(totalSteps > maxLength){
			
			playerLeft(input, delta);
			return;
		}
		else{
			playerUp(input);
			playerRight(input, delta);
			playerLeft(input, delta);
			playerHit(input, delta);
		}
	}
	
	private void playerHit(Input input, int delta){
		if(input.isKeyDown(Input.KEY_H)){
			Main.IS_HIT = true;
			pl.hit(HIT);
		}
		else{
			Main.IS_HIT = false;
		}
	}
	
	private void playerRight(Input input, int delta){
		if(input.isKeyDown(Input.KEY_RIGHT)){
			
			pl.setRight();
			
			if(backGroundX >= -480){
				backGroundX -= (0.15 * delta);
				backGroundEnemy -=(0.15 * delta);
				totalX -= (0.15 * delta);
				totalSteps++;
				
				if(pl.getIsJumping()){
					backGroundX -= (0.15 * delta);
					backGroundEnemy -=(0.15 * delta);
					totalX -= (0.15 * delta);
					totalSteps++;
				}
			}
			else{
				backGroundX = 0;
				backGroundEnemy -=(0.15 * delta);
				totalX -= (0.15 * delta);
				totalSteps++;
			}
			
			
			if(lastMove == Character.NORMAL){
				pl.setCurrentImage(pl.getRight1Image());
				lastMove = Character.RIGHT_1;
			}
			else if(lastMove == Character.RIGHT_1){
				pl.setCurrentImage(pl.getRight2Image());
				lastMove = Character.RIGHT_2;
			}
			else if(lastMove == Character.RIGHT_2){
				pl.setCurrentImage(pl.getRight1Image());
				lastMove = Character.RIGHT_1;
			}
			else if(lastMove == Character.LEFT_1 || lastMove == Character.LEFT_2){
				pl.setCurrentImage(pl.getNormalImage());
				lastMove = Character.NORMAL;
			}
		}
	}
	
	private void playerLeft(Input input, int delta){
		if(input.isKeyDown(Input.KEY_LEFT)){
			
			pl.setLeft();
			
			if(backGroundX < 0){
				backGroundX += (0.15 * delta);
				totalX += (0.15 * delta);
				backGroundEnemy +=(0.15 * delta);
				totalSteps--;
				
				if(pl.getIsJumping()){
					backGroundX += (0.15 * delta);
					totalX += (0.15 * delta);
					backGroundEnemy +=(0.15 * delta);
					totalSteps--;
				}
			}
			else{
				backGroundX = -480;
				totalX += (0.15 * delta);
				backGroundEnemy +=(0.15 * delta);
				totalSteps--;
			}
			
			if(lastMove == Character.NORMAL){
				pl.setCurrentImage(pl.getRight1Image());
				lastMove = Character.LEFT_1;
			}
			else if(lastMove == Character.LEFT_1){
				pl.setCurrentImage(pl.getLeft2Image());
				lastMove = Character.LEFT_2;
			}
			else if(lastMove == Character.LEFT_2){
				pl.setCurrentImage(pl.getLeft1Image());
				lastMove = Character.LEFT_1;
			}
			else if(lastMove == Character.RIGHT_1 || lastMove == Character.RIGHT_2){
				pl.setCurrentImage(pl.getNormalImage());
				lastMove = Character.NORMAL;
			}
		}
	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return 12;
	}
	private void playerUp(Input input){
		if(input.isKeyDown(Input.KEY_UP)){
			if(!pl.getIsJumping()){
				pl.setIsJumping(true);
				pl.setGoingUp(true);
			}
		}
	}
}
