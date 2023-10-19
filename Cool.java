import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cool extends Actor
{
    public GreenfootImage[] imagesRun= new GreenfootImage[8];
    public GreenfootImage[] imagesJump= new GreenfootImage[11];
    public int countRun= 0;
    public int countRun1 = 0;
    public int countJump = 0;
    public final int gravitasi = 1;
    public int kecepatan;
    public boolean falling = false;
    public GreenfootSound backSoundCoin;
    public int score = 0;
    public int num = 1;
    /*
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Cool(){
        animJump();
        animRun();
        kecepatan = 0;
        
        
    }
    public void act()
    {
        
    }
    public void Running(){
        if(countRun1 % 4 == 0 ){
        setImage(imagesRun[countRun++ %8]);
        
        }
        if(countRun1 > 32){
            countRun1 = 0;
        }
        countRun1 ++;
    }
    public void animRun(){
       for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "Run_"+ a + ".png";
            imagesRun[i] = new GreenfootImage(filename);   
        } 
    }
    public void animJump(){
        for(int i = 0; i < 11; i++){
            int a = i+1;
            String filename = "Jump_"+ a + ".png";
            imagesJump[i] = new GreenfootImage(filename);   
        } 
        
    }
    
    public void Jumping(){
        setImage(imagesJump[countJump++ %8]);
        
    }
    
    
    public void addScore(){
        World myWorld = getWorld();
        
        score++;
        if (score % 5 == 0){
            Main bg = (Main)myWorld;
            Counter counter = bg.getCounter();
            counter.addScore();
        }
    }
    
    public void addDrink(){
        Actor drink = getOneIntersectingObject(Drink.class);
        World myWorld = getWorld();
        
        if (drink != null){    
            myWorld.removeObject(drink);
            
            backSoundCoin = new GreenfootSound("koin.mp3"); //
            backSoundCoin.play();
            
            Main bg = (Main)myWorld;
            Energy energy = bg.getEnergy();
            energy.addEnergy();
            
            if (energy.energy == 5) {
                myWorld.addObject(new PortalD(),600,279); 
            }
            
             
        }
    }
}