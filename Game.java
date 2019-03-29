package settings;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static int envType;
	public static final String title="Godot's Escape Adventure";
	public static final int menu=0;
	public static final int play=1;
	public static final int playSound=2;
	public static final int tac=3;
	public static final int main=5;
	public static final int shop=4;
	public static final int weapon=6;
	public static final int bcharacter=7;
	public static final int playGame=8;
	public static final int question=9;
	public static final int selectEnvironment = 10;
	public static final int playGame2 = 11;
	public static final int playGame3 = 12;
	
	
	public static void setEnv(int i) { envType = i; }
	public static int getEnv() { return envType; }
	
	public Game(String gname) 
	{
		super(gname);
		this.addState(new Setting(menu));//1 class against each state
		this.addState(new HallOfFame(play));
		this.addState(new Control(playSound));
		this.addState(new TermsAndCondition(tac));
		this.addState(new MainMenu(main));
		this.addState(new Shop(shop));
		this.addState(new BuyWeapon(weapon));
		this.addState(new BuyCharacter(bcharacter));
		this.addState(new Main(playGame));
		this.addState(new Question(question));
		this.addState(new SelectEnvironment(selectEnvironment));
		this.addState(new Main2(playGame2));
		this.addState(new Main3(playGame3));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppGameContainer game;
		try
		{
			game=new AppGameContainer(new Game(title));
			game.setDisplayMode(800 , 480 , false);
		
			game.start();
		}
		catch(SlickException s)
		{
			//System.out.println("SLick Exception");
			s.printStackTrace();
		}
	}

	
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		// TODO Auto-generated method stub
		this.getState(menu).init(gc, this);//game has two states one is menu one is play game
		this.getState(play).init(gc, this);
		this.getState(playSound).init(gc, this);
		this.getState(tac).init(gc, this);
		this.getState(main).init(gc, this);
		this.getState(shop).init(gc, this);
		this.getState(weapon).init(gc,this);
		this.getState(bcharacter).init(gc,this);
		this.getState(playGame).init(gc,this);
		this.getState(question).init(gc, this);
		this.getState(selectEnvironment).init(gc, this);
		this.enterState(main);//the first screen we want
		
	}

}
