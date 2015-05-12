/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo_final;

import java.util.Random;
import java.util.Scanner;


public class Hero{
    
    private int heroPos;
    private boolean heroArmed;
    private boolean heroAlive;
    private boolean heroProtected;
    private boolean exitReached;
    public int dartAmount;
    
    
    public Hero(Map m){
        dartAmount=0;
        exitReached = false;
        heroProtected = false;
        setIniPos(m);
    }
    
    public Hero() {
    	dartAmount=0;
        exitReached = false;
        heroProtected = false;
        heroPos=11;
        heroAlive = true;
        heroArmed = false;
        }

	private void setIniPos(Map m){
       int size = m.getMapSize();
       int pos;
       
       Random r = new Random();
       
       while(true){
            pos = r.nextInt(size*size);
            if(m.getMapElem(pos) == ' '){
                heroPos = pos;
                heroArmed = false;
                heroAlive = true;
                m.setMapElem(pos, 'H');
                return;
            }
       }
    }
    
    private char getInput() {
        Scanner s= new Scanner(System.in);
        String str = s.nextLine();
        
        if(str.isEmpty())
            return 'x';
        return str.charAt(0);
    } 
    
    public int getPos(){
    	return heroPos;
    }
            
    public boolean getHeroArmed() {
		return heroArmed;
	}

	public int getDartAmount() {
		return dartAmount;
	}

	public int newPosition(char command, Map m, Dragon d){
        int np=heroPos;
        
        switch (command) {
            case 'a':  np-=1;
             break;
            case 'w':  np-=m.getMapSize();
             break;
            case 's':  np+=m.getMapSize();
             break;
            case 'd':  np+=1;
             break;
            case 'i':  attack(m, -1*m.getMapSize(), d);
             break;
            case 'j':  attack(m, -1, d);
             break;    
            case 'k':  attack(m, m.getMapSize(), d);
             break;    
            case 'l':  attack(m, 1, d);
             break;    
        }
        return np;
}
    
    public void applyMove(int np, Map m, Dragon d){
        if(m.getMapElem(np) == ' '){
            m.setMapElem(np, m.getMapElem(heroPos));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
        }
        else if((m.getMapElem(np) == 'D' || m.getMapElem(np) == 'd') && heroArmed)
        {
            for(int i = 0 ; i < d.getNumDragons() ; i++)
                if(np == d.getDragonPos(i))
                    d.killDragon(i);
            
            m.setMapElem(np, m.getMapElem(heroPos));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
        }
        else if(m.getMapElem(np) == 'f' && heroArmed)
        {
            for(int i = 0 ; i < d.getNumDragons() ; i++)
                if(np == d.getDragonPos(i))
                    d.killDragon(i);
            
            m.setMapElem(np, m.getMapElem(heroPos));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
        }
        else if(m.getMapElem(np) == 'E'){
            m.setMapElem(np, 'A');
            m.setMapElem(heroPos, ' ');
            heroPos = np;
            heroArmed = true;
        }
        else if(m.getMapElem(np) == 'P'){
            m.setMapElem(np, m.getMapElem(heroPos));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
            heroProtected = true;
        }        
        else if(m.getMapElem(np) == '*'){
            m.setMapElem(np, m.getMapElem(heroPos));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
            dartAmount++;
        }
        else if(m.getMapElem(np) == 'D' && !heroArmed){
            m.setMapElem(np, m.getMapElem(np));
            m.setMapElem(heroPos, ' ');
            heroPos = np;
            heroAlive = false;  
        }
        if(m.getMapElem(np) == 'S' && heroArmed){
            for(int i = 0 ; i< d.getNumDragons() ; i++)
                if(d.getDragonAlive(i))
                    return;
            
            m.setMapElem(np, 'R');
            m.setMapElem(heroPos, ' ');
            
            heroPos = np;
            exitReached = true;
        }
    }
    
    public void moveHero(Map m, Dragon d){
        applyMove(newPosition(getInput(), m, d), m, d);
    }
  
    public void killHero(){
        heroAlive=false;
    }
    
    public boolean getHeroAlive(){
        return heroAlive;
    }

    public boolean getExitReached() {
        return exitReached;
    }

    public boolean getHeroProtected() {
        return heroProtected;
    }
    
    public void attack(Map m, int dir, Dragon d){
        int pos = heroPos;
        
        if(dartAmount > 0){
        for(int i = 0; m.getMapElem(heroPos+((i+1)*dir))!='X' && m.getMapElem(heroPos+((i+1)*dir))!='S' ; i++){
            if(d.dragonIndex(heroPos+((i+1)*dir)) != -1){
                if(d.getDragonAlive(d.dragonIndex(heroPos+((i+1)*dir))))
                {
                    d.killDragon(d.dragonIndex(heroPos+((i+1)*dir)));
                    
                    if(m.getMapElem(heroPos+((i+1)*dir))!='d' || m.getMapElem(heroPos+((i+1)*dir))!='D'){
                        m.setMapElem(heroPos+((i+1)*dir), ' ');
                        break;
                    }
                    else if(m.getMapElem(heroPos+((i+1)*dir))=='F'){
                        m.setMapElem(heroPos+((i+1)*dir), 'E');
                        break;
                    }
                    else if(m.getMapElem(heroPos+((i+1)*dir))=='f'){
                        m.setMapElem(heroPos+((i+1)*dir), '*');
                        break;
                    }
                    else if(m.getMapElem(heroPos+((i+1)*dir))=='+'){
                        m.setMapElem(heroPos+((i+1)*dir), 'P');
                        break;
                    }
                }
            }
            }
        dartAmount--;
        }
            
                
            
    }
}
