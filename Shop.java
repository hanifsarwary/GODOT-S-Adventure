package settings;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
public class Shop extends BasicGameState{
	Image menu;
	int mousex;int mousey;
	public Shop(int s) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		menu=new Image("//images/Menu Shop.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		menu.draw(0, 0, 800, 480);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input=gc.getInput();
		mousex=Mouse.getX();
		mousey=Mouse.getY();

		if((mousex>357 && mousex<443) && (mousey>134 &&mousey<158)) {//shop->back
			if(input.isMouseButtonDown(0)) 
			{
				sbg.enterState(5);
			}
		}
		else if((mousex>265 && mousex<532) && (mousey>274 && mousey<295)) {//shop-?buy char
			
		
			if(input.isMouseButtonDown(0)) 
			{
				sbg.enterState(7);
			}
		}

		else if((mousex>295 && mousex<515) && (mousey>206 && mousey<228)) {//shop-?buy Weapon
			
			
			if(input.isMouseButtonDown(0)) 
			{
				sbg.enterState(6);
			
			}
		}
		if(input.isMouseButtonDown(0))
		{
			System.out.println(mousex+ " + " + mousey);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}
 
//	public static void main(String arg[]) throws SlickException {
//		AppGameContainer game=new AppGameContainer(new Main("Game Menu"));
//		game.setDisplayMode(1350, 690
//				, false);
//		//game.setFullscreen(true);
//		game.start();
//	}
}