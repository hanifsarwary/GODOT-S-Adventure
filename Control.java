package settings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Control extends BasicGameState {

	Image ctrl;
	public Control(int state) 
	{
		
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		ctrl=new Image("//images/controls.jpeg");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
			ctrl.draw(0,0,800,480);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input in=gc.getInput();
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();

		//back to settings menu from controls
		if(((xpos>346 && xpos<443) && (ypos>55 && ypos<83)) || in.isKeyDown(in.KEY_BACK))
		{    
			if(in.isMouseButtonDown(0))
			{
				sbg.enterState(0);
				
			}
		}

//		if(in.isMouseButtonDown(0))
//		{
//			System.out.println(xpos+ " + " +ypos);
//		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
	

}
