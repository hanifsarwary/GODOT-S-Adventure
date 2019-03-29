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

public class Setting extends BasicGameState {

	
	Image main;
	Image ctrl;
	Image credits;
	Control s;
	Sound sou;
	boolean sounds;
	public Setting(int state) 
	{
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		main=new Image("//images/MenuSettings.png");
		ctrl=new Image("//images/controls.jpeg");
		sou=new Sound("//images/Theme1_Garden.wav");
		sounds=true;
		credits=new Image("//images/credits.png");
		
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		main.draw(0, 0,800,480);
		//sou.play();
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		Input in=gc.getInput();
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		
		if((xpos>227 && xpos<578) && (ypos>106 && ypos<124))
		{    // terms and conditions
			if(in.isMouseButtonDown(0))
			{				
				sbg.enterState(3);
			}
		}
		//hall of fame
		else if((xpos>301 && xpos<508) && (ypos>163 && ypos<184))
		{    
			if(in.isMouseButtonDown(0))
			{
				
				sbg.enterState(1);
				
			}
		}
		//Controls
		else if((xpos>328 && xpos<462) && (ypos>218 && ypos<239))
		{    
			if(in.isMouseButtonDown(0))
			{
				
				sbg.enterState(2);
			}
		}
		//back to main menu from settings
		else if(((xpos>370 && xpos<445) && (ypos>52 && ypos<73)) || in.isKeyDown(in.KEY_BACK))
		{    
			if(in.isMouseButtonDown(0))
			{
				
				sbg.enterState(5);
			}
		}
		//music
		else if((xpos>512 && xpos<592) && (ypos>272 && ypos<304))
		{    
			if(in.isMouseButtonDown(0))
			{
				if(sounds==true)
				{
					sou.stop();
					sounds=false;
				}
				else if(sounds==false)
				{
					sou.play();
					sounds=true;
				}
			}
		}
////		else {
//		if(in.isMouseButtonDown(0))
//		{
//			System.out.println(xpos+ " + " +ypos);
//		}
//		}
	}

	public void displayTAC()
	{
		credits.draw(0,0,1280,790);
	}
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
