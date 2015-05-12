/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpoo_final;

import java.util.Random;


public class Dart extends Weapon{
    
    private int[] dartPos;
    private int numDarts;
    
    public Dart(int i, Map m){
        dartPos = new int[i];
        numDarts = i;
        setIniPos(m);
    }
    
    public Dart(){
        dartPos = new int[1];
        numDarts = 1;
        dartPos[0]=12;
    }
    
       private void setIniPos(Map m){
       int size = m.getMapSize();
       int pos;
       
       Random r = new Random();
       
       for(int i= 0 ; i < numDarts ; i++){
            pos = r.nextInt(size*size);
            if(m.getMapElem(pos) == ' '){
                dartPos[i] = pos;
                m.setMapElem(pos, '*'); 
            }
            else i--;
       }
    }

       public int getDartPos() {
           return dartPos[0];
       }
       
       public int getDartAmount() {
           return numDarts;
       }

    
}
