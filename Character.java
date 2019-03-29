package settings;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public abstract class Character 
{
	public static final int NORMAL = 700;
	public static final int LEFT_1 = 701;
	public static final int LEFT_2 = 702;
	public static final int RIGHT_1 = 703;
	public static final int RIGHT_2 = 704;
	
    protected float x;
    protected float y;
    protected double health;
    private String name;
    private int stepCount;
    private Image normal, left1, left2, right1, right2, currImage;
    private boolean isJumping = false;
    private boolean isGoingUp = false;
    private boolean isGoingDown = false;
    
    public void setImages(Image normal, Image left1, Image left2, Image right1, Image right2){
    	this.normal = normal;
    	this.left1 = left1;
    	this.left2 = left2;
    	this.right1 = right1;
    	this.right2 = right2;
    	currImage = normal;
    }
    
    public void setCurrentImage(Image obj){
    	currImage = obj;
    }
    
    public void incrementSteps(){
    	stepCount++;
    }
    public void decrementSteps(){
    	stepCount++;
    }
    
    public void setGoingUp(boolean b){ isGoingUp = b; }
    public void setGoingDown(boolean b){ isGoingDown = b; }
    public void setIsJumping(boolean x){ isJumping = x; }
    public void setX(float x){ this.x = x; }
    public void setY(float y){ this.y = y; }
    public float getX(){ return x; }
    public float getY(){ return y; }
    public boolean getIsJumping(){ return this.isJumping; }
    public boolean getGoingUp(){ return isGoingUp; }
    public boolean getGoingDown(){ return isGoingDown; }
    public Image getCurrentImage(){ return currImage; }
    public Image getNormalImage(){ return normal; }
    public Image getLeft1Image(){ return left1; }
    public Image getLeft2Image(){ return left2; }
    public Image getRight1Image(){ return right1; }
    public Image getRight2Image(){ return right2; }
    public int getStepCount(){ return stepCount; }
    
    public Character(String name)
    {
    	this.name = name;
    	stepCount = 0;
    	this.x = 370;
    	this.y = 330;
    	
    	setBoundingBox();
    }
    
    protected Shape boundingBox;
    
    public Shape getBoundingBox(){
    	return boundingBox;
    };
    
    public void setBoundingBox(){
    	
    	if(boundingBox == null)
    		boundingBox = new Circle(x, y, 0.2f);
    	
    	boundingBox.setX(x);
    	boundingBox.setY(y);
    }
    
    public boolean intersects(Character entity) {
        if (this.getBoundingBox() == null) {
            return false;
        }
        return this.getBoundingBox().intersects(entity.getBoundingBox());
    }
    
    public abstract void display(GameContainer gc, int delta);
    public abstract void display();
    
    public boolean isDead()
    {
        return (health <= 0);
    }
    
    public void updateHealth(double d)
    {
    	if(d>=0)
        health = d;
    }
    
    public double getHealth()
    {
        return this.health;
    }   
}
