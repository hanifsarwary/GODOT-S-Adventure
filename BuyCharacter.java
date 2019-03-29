package settings;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BuyCharacter extends BasicGameState {


	Image im1;
	Image im2;
	Image im3;
	Image im4;
	final int width=800;
	final int height=480;
	public BuyCharacter(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		im3=new Image("//images/Skins Shop.png");
		im1=new Image("//images/chard.png");
		im2=new Image("//images/charp.png");	
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException 
	{
		// TODO Auto-generated method stub
		im3.draw(0, 0, width, height);
		im1.draw(150,100,300, 300);
		im2.draw(350,100, 300, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException 
	{
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
		
//		if(input.isMouseButtonDown(0))
//		{
//			System.out.println(xpos+ " + " +ypos);
//		}
		
		if(input.isKeyPressed(input.KEY_BACK)){
			sbg.enterState(4);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 7;
	}

}
