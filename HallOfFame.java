package settings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HallOfFame extends BasicGameState {

	Image credit;
	FileReader r;
	BufferedReader br;
	int i,x,y;
	public HallOfFame(int state) 
	{
		// TODO Auto-generated constructor stub
		

	}

	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		credit=new Image("//images/hof.jpeg");
		i=1;
		x=0;
		y=0;
//		try {
//			
//			r=new FileReader("save.txt");
//			br=new BufferedReader(r);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		g.drawString("Hall of Fame", 100, 100);
		credit.draw(0, 0, 800, 480);
		g.drawString("Zarnish",237,225);
		g.drawString("100", 944, 222);
		String str=new String(" ");
//		if(i==1)
//		{
//			try {
//				str=br.readLine();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//g.drawString(str,237+x,225+y);
		
		//g.drawString("100", 944, 222);
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input in=gc.getInput();
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		
		x+=10;
		y+=10;
		if((xpos>350 && xpos<455) && (ypos>57 && ypos<84))
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

	
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	

}
