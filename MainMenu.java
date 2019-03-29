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

	public class MainMenu extends BasicGameState {

		
		Image main;
		Image ctrl;
		Image credits;
		Control s;
		Sound sou;
		boolean sounds;
		public MainMenu(int state) 
		{
			// TODO Auto-generated constructor stub
			
		}
		
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			// TODO Auto-generated method stub
			main=new Image("//images/Menu Basic.png");
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
			if((xpos>317 && xpos<482) && (ypos>293 && ypos<317))
			{    // play game
				if(in.isMouseButtonDown(0))
				{				
					sbg.enterState(10);
					
				}
			}
			//settings
			else if((xpos>334 && xpos<464) && (ypos>230 && ypos<255))
			{    
				if(in.isMouseButtonDown(0))
				{
					
					sbg.enterState(0);
					
				}
			}
			//exit
			else if((xpos>324 && xpos<476) && (ypos>105 && ypos<125))
			{    
				if(in.isMouseButtonDown(0))
				{
					
					//System.exit(0);
				}
			}
			//Shop
			else if((xpos>364 && xpos<435) && (ypos>168 && ypos<189))
			{    
				if(in.isMouseButtonDown(0))
				{
					sbg.enterState(4);
				}
			}
////			else {
//			if(in.isMouseButtonDown(0))
//			{
//				System.out.println(xpos+ " + " +ypos);
//			}
//			}
		}


		@Override
		public int getID() {
			// TODO Auto-generated method stub
			return 5;
		}
}
