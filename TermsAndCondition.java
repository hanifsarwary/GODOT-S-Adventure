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

public class TermsAndCondition extends BasicGameState {

	Image ctrl;
	public TermsAndCondition(int state) 
	{
		
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		ctrl=new Image("//images/Terms and Conditions.png");
		
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

		//back to settings menu from TAC
		if((xpos>359 && xpos<455) && (ypos>54 && ypos<82))
		{    
			if(in.isMouseButtonDown(0))
			{
				sbg.enterState(0);
				
			}
		}
//
//		if(in.isMouseButtonDown(0))
//		{
//			System.out.println(xpos+ " + " +ypos);
//		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
	public void printTAC()
	{
		
	}
	public void printCredits()
	{
		
	}

}
