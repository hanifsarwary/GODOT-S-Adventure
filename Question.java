package settings;
import java.util.*;
import java.io.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Question extends BasicGameState{
	private String qFileName;
	private String aFileName;
	private String query;
	private String[] option;
	private char ans;
	private int qNo;
	private int ansStatus;//0 = wrong, 1 = correct
	private boolean attempted;
	private Image exitScreen;
	private Image bg;
	public Question(int state)
	{
		
	}
//	public Question() {
//		// TODO Auto-generated constructor stub
//		ansStatus = 0;
//		attempted = false;
//		qFileName = "questions.txt";
//		aFileName = "answers.txt";
//		File qFile = new File(qFileName);
//		File aFile = new File(aFileName);
//		if(qFile.exists() && aFile.exists())
//		{
//			Scanner qF, aF;
//			try {
//				qF = new Scanner(qFile);
//				aF = new Scanner(aFile);
//				option = new String[4];
//				
//				//generate random number to pick question
//				Random ran = new Random();
//				qNo = ran.nextInt(6) + 1;
//				
//				//read question from file
//				for(int i = 0; i < qNo && qF.hasNext(); i++)
//				{
//					query = qF.nextLine();
//				}
//				//get corresponding answer
//				char buf;
//				for(int i = 0; i < qNo && aF.hasNext(); i++)
//				{
//					for(int j = 0; j < 4; j++)
//					{
//						option[j] = aF.nextLine();
//					}
//					buf = aF.nextLine().charAt(0);
//					ans = aF.nextLine().charAt(0);
//					buf = aF.nextLine().charAt(0);
//				}
//				
//				//close files after reading
//				qF.close();
//				aF.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				System.out.println("Error in reading file!");
//			}
//		}
//		else
//		{
//			System.out.println("Unable to load Question. Please try again!");
//		}
//	}


	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		exitScreen = new Image("//images/GameOver.png");
		bg=new Image("//images/black.png");
		ansStatus = 0;
		attempted = false;
		qFileName = "questions.txt";
		aFileName = "answers.txt";
		File qFile = new File(qFileName);
		File aFile = new File(aFileName);
		if(qFile.exists() && aFile.exists())
		{
			Scanner qF, aF;
			try {
				qF = new Scanner(qFile);
				aF = new Scanner(aFile);
				option = new String[4];
				
				//generate random number to pick question
				Random ran = new Random();
				qNo = ran.nextInt(6) + 1;
				
				//read question from file
				for(int i = 0; i < qNo && qF.hasNext(); i++)
				{
					query = qF.nextLine();
				}
				//get corresponding answer
				char buf;
				for(int i = 0; i < qNo && aF.hasNext(); i++)
				{
					for(int j = 0; j < 4; j++)
					{
						option[j] = aF.nextLine();
					}
					buf = aF.nextLine().charAt(0);
					ans = aF.nextLine().charAt(0);
					buf = aF.nextLine().charAt(0);
				}
				
				//close files after reading
				qF.close();
				aF.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Error in reading file!");
			}
		}
		else
		{
			System.out.println("Unable to load Question. Please try again!");
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		bg.draw();
		g.drawString(query, 0, 30);
		int p = 50;
		for(int i = 0; i < 4; i++)
		{
			g.drawString(option[i], 0, p);
			p += 15;
		}
		if(ansStatus == 1 && attempted == false) 
		{
			g.drawString("Correct Answer! At least you're good at something! You may proceed!", 200, 150);
			attempted = true;
		}
		if(ansStatus == 0 && attempted == false)
		{
			//g.drawString("Oh no!! You messed up! Better luck next time!", 200, 150);
			attempted = true;
			g.drawImage(exitScreen, 0, 0);
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_A))
		{
			if(ans == 'a')
				ansStatus = 1;
			else
				ansStatus = 0;
		}
		if(input.isKeyPressed(Input.KEY_B))
		{
			if(ans == 'b')
				ansStatus = 1;
			else
				ansStatus = 0;
		}
		if(input.isKeyPressed(Input.KEY_C))
		{
			if(ans == 'c')
				ansStatus = 1;
			else
				ansStatus = 0;
		}
		if(input.isKeyPressed(Input.KEY_D))
		{
			if(ans == 'd')
				ansStatus = 1;
			else
				ansStatus = 0;
		}
//		else if (!input.isKeyPressed(Input.KEY_A) && !input.isKeyPressed(Input.KEY_B) && !input.isKeyPressed(Input.KEY_C) && !input.isKeyPressed(Input.KEY_D))
//		{
//			ansStatus = 3;
//		}
		if(attempted == true)
		{
			if(ansStatus == 0)
				sbg.enterState(8);//state change to play game;
//			else
//				System.exit(0);//terminate game;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 9;
	}

}
