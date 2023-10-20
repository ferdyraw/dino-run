import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinfactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteinlab extends Cute
{
    /**
     * Act - do whatever the Cuteinfactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cuteinlab() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        
        if(Greenfoot.isKeyDown("space") && isOnGround()) {
            jump();
        }
    
        if(Greenfoot.isKeyDown("up") && isOnGround() && getY() == 327){
            kecepatan = -20;
        }else if(Greenfoot.isKeyDown("down") && isOnGround() && getY() == 153){
            falling = true;
            kecepatan = 20;
        }
        
        if(getOneIntersectingObject(Dot.class) != null){
            Greenfoot.setWorld(new gameOver());
        }
        
        if(getOneIntersectingObject(PortalD.class) != null){
            Greenfoot.setWorld(new Cave());
        
        }
        if(getX() == 110){
            World myWorld = getWorld();
            myWorld.addObject(new Coolinlab(),-25,324);
        }
        
        addScore();
        addDrink();
        if(isOnGround()) Running();
        else Jumping(); 
    }
    
    public void fall(){
        setLocation(getX(), getY() + kecepatan);
        if (isOnGround()) {
            kecepatan = 0;
            if (falling == true) falling = false;
        } else {
            if (falling == true) kecepatan -= gravitasi;
            else kecepatan += gravitasi;
        }
        
    }
    
    public void jump(){
        kecepatan = -13;
    }
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 327 || 
        getY() == 153) isOnGround = true;
        
        return isOnGround;            
    }
    
    
}
