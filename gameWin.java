import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWin extends World
{
    private GreenfootImage backgroundImage;
    private int timer = 0;
    
    Highscore highscore = new Highscore();
    Counter counter = new Counter();
    PortalB portal = new PortalB();
    DialogueWin dialogue = new DialogueWin();
    
    public gameWin()
    {    
        super(600, 400, 1, false); 
        backgroundImage = new GreenfootImage("bege4.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    public void prepare(){
        counter.getScore();
        highscore.putScore(counter.score);
        
        addObject(new Blockwin(), 300, 350);
        addObject(portal, 1, 250);
    }
    
    public void act(){
        timer++;
        
        if (timer == 1) {
            portal.soundClose();
        }
        
        if (timer == 60) {
            addObject(new Cuteinwin(), 55, 250);
        }
        
        if (timer == 200) {
            addObject(dialogue, 300, 80);
            dialogue.soundDialogue();
        }
        
        if (timer == 400) {
            dialogue.next();
        }
        
        if (timer == 450) {
            addObject(highscore, 300, 100);
        }

        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new Lab());
            counter.putScore(0);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }

}