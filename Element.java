/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;

/**
 *
 * @author yesuserahailu
 */
public abstract class Element {
    
    public String getClassName(){
        return getClass().getSimpleName();
    }
    
    public abstract void readIn();
    
    public abstract void display();
    
    public abstract boolean equals(Element dobj);
    
    public abstract Element clone();
    
}
