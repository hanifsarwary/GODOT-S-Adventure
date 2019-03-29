package settings;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BuyWeapon extends BasicGameState 
{
	Image im1;
	Image im2;
	Image im3;
	Image im4;
	Image im5;
	Image im6;
	Image bg;
	final int width=800;
	final int height=480;
	

	public BuyWeapon(int state) 
	{
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		im1=new Image("//images/LRWeapon1.png");
		im2=new Image("//images/LRWeapon2.png");
		im3=new Image("//images/LRWeapon3.png");
		im4=new Image("//images/LRWeapon4.png");
		bg=new Image("//images/Weapon Shop2.png");
		im5=new Image("//images/sr1.png");
		im6=new Image ("//images/Sword2 Right1.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		bg.draw(0,0,width,height);
		im1.draw(150, 100,200, 200);
		im2.draw(300, 100, 200, 200);
		im3.draw(450, 100, 200, 200);
		im4.draw(150, 250,150, 150);
		im5.draw(300, 250, 150, 200);
		im6.draw(450, 200, 150, 200);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input=gc.getInput();
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		if(((xpos>461 && xpos<537) && (ypos>51 && ypos<72)) || (input.isKeyDown(input.KEY_BACK)))
		{
			if(input.isMouseButtonDown(0))
			{
				sbg.enterState(4);
				
			}
		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 6;
	}
	

}
