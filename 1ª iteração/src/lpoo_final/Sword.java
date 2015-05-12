/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo_final;

import java.util.Random;

/**
 *
 * @author Andre
 */
public class Sword{
    
    private int swordPos;
    
    public Sword(Map m){
        setIniPos(m);
    }
    
    public Sword() {    	
    	swordPos = 81;
    }    
    
    private void setIniPos(Map m){
       int size = m.getMapSize();
       int pos;
       
       Random r = new Random();
       
       while(true){
            pos = r.nextInt(size*size);
            if(m.getMapElem(pos) == ' '){
                swordPos = pos;
                m.setMapElem(pos, 'E');
                return;
            }
       }
    }
    
    public int getPos(){
    	return swordPos;
    }
}
