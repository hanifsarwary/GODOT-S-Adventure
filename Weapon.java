package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Weapon 
{
	public static final int LEFT_1 = 701;
	public static final int LEFT_2 = 702;
	public static final int RIGHT_1 = 703;
	public static final int RIGHT_2 = 704;
	
    protected float x;
    protected float y;
    private Image left1, left2, right1, right2, currImage;
    private boolean isright1 = true;
    private boolean isleft1 = true;
    private boolean direction = true;
    
    public void setImages(Image left1, Image left2, Image right1, Image right2){
    	this.left1 = left1;
    	this.left2 = left2;
    	this.right1 = right1;
    	this.right2 = right2;
    	currImage = right1;
    }
    
    public void setX(float x){ this.x = x; }
    public void setY(float y){ this.y = y; }
    public float getX(){ return x; }
    public float getY(){ return y; }
    public Image getCurrentImage(){ return currImage; }
    public Image getLeft1Image(){ return left1; }
    public Image getLeft2Image(){ return left2; }
    public Image getRight1Image(){ return right1; }
    public Image getRight2Image(){ return right2; }
    private void setCurrImage(Image i){ currImage = i;}
    
    public void draw(boolean isHit, boolean right, float px, float py, Sound s){
    	
    	if(isHit){
    		s.play(1f, 1f);
        	s.play();
    		
    		hit(right, s);
    	}
    	else{
    		move(right);
    	}
    	
    	if(right){
    		getCurrentImage().draw(px, py, 0.2f);
    	}
    	else{
    		getCurrentImage().draw(px - 70, py, 0.2f);
    	}
    }
    
    public void hit(boolean right, Sound s){
    	if(right){
    		setCurrImage(right2);
    	}
    	else{
    		setCurrImage(left2);
    	}
    }
    
    public void move(boolean right){
    	
    	if(right){
    		setCurrImage(right1);
    	}
    	else{
    		setCurrImage(left1);
    	}
    }
}