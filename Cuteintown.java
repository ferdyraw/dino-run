import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinfactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteintown extends Cute
{
    private boolean inPortal = false;
    
    /**
     * Act - do whatever the Cuteinfactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cuteintown() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        
        if(getOneIntersectingObject(ObstacleTruck.class) != null){
            Greenfoot.setWorld(new gameOver());
        }
        
        if (getOneIntersectingObject(PortalD.class) != null) {
            setLocation(-50, getY());
            num = 0;
            inPortal = true;
        }
        
        if (!inPortal) addScore();
        addDrink();
        if(isOnGround()) {
            Running();
            countJump = 0;
            countJump1 = 0;
        }
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
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 327 || 
        getY() == 153) isOnGround = true;
        
        return isOnGround;            
    }
    
    public void addDrink(){
        Actor drink = getOneIntersectingObject(Drink.class);
        World myWorld = getWorld();
        
        if (drink != null){    
            myWorld.removeObject(drink);
            
            backSoundCoin = new GreenfootSound("getPower1.mp3"); 
            backSoundCoin.setVolume(40);
            backSoundCoin.play();
            
            Main bg = (Main)myWorld;
            Energy energy = bg.getEnergy();
            energy.addEnergy();
            
            if (energy.energy == 15) {
                myWorld.addObject(new PortalD(),600,279); 
                num = 1;
                
            }
        }
    }
}
