package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SelectEnvironment extends BasicGameState {

	public SelectEnvironment(int state) {
		
	}
	
	Image im1,im2,im3,im4;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
		im1=new Image("//images/men.png");
		im2=new Image("//images/bsd2.png");
		im3=new Image("//images/bsg2.png");
		im4=new Image("//images/bsl2.png");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		im1.draw(0, 0, 800, 480);
		im2.draw(80, 130, 280, 100);
		im3.draw(430, 130, 280, 100);
		im4.draw(260, 270, 280, 100);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
		Input i = arg0.getInput();
		if(i.isMouseButtonDown(0)) {
			
			if(i.isKeyDown(Input.KEY_BACK)||((i.getMouseX()>355&&i.getMouseX()<453)&&(i.getMouseY()>398&&i.getMouseY()<425))) 
			{
				arg1.enterState(5);
			}
		}
		if((i.getMouseX() >= 80 && i.getMouseX() <= 360) && (i.getMouseY() >= 130 && i.getMouseY() <= 230)) {
			if(i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				
				arg1.enterState(11);
			}
		}
		
		if((i.getMouseX() >= 430 && i.getMouseX() <= 610) && (i.getMouseY() >= 130 && i.getMouseY() <= 230)) {
			if(i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				
				arg1.enterState(12);
			}
		}
		
		if((i.getMouseX() >= 260 && i.getMouseX() <= 540) && (i.getMouseY() >= 270 && i.getMouseY() <= 370)) {
			if(i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				
				arg1.enterState(8);
			}
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 10;
	}

}
