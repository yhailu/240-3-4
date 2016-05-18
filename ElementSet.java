/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;
import java.net.SocketPermission;
import java.util.Scanner;

/**
 *
 * @author yesuserahailu
 */
public class ElementSet {
    private Element[] theList;
    
    private int currentIndex;
    private int currentSize;
    private final int MAXSETSIZE = 100;
    
    public ElementSet(){
        theList = new Element [MAXSETSIZE];
        currentIndex = -1;
        currentSize = 0;
        
    }
    
    public boolean isMemberOf(Element anElement){
        String paramClass = anElement.getClassName();
        String currClass;
        
        
        for (int i =0; i < currentSize; i++)
        {
            //only compare anElement against those objects
            // that belong to anElemnt's class
            currClass = theList[i].getClassName();
            if (currClass.equals(paramClass))
            {
            
                if(theList[i].equals(anElement))
                {
                    return true;
                }
            }
                
        }
        
        return false;
        
    }
    
    public boolean isFull(){
        return currentSize == MAXSETSIZE;
        
    }
    
    public boolean isEmpty(){
        return currentSize == 0;
    }
    
    public int size(){
        return currentSize;
    }
    
    public Element getCurrent(){
        int saveIndex = currentIndex;
        
        if (currentIndex == currentSize -1){
            currentIndex = 0;
        }
        else{
            currentIndex++;
        }
        
        return theList[saveIndex].clone();
    }
    
    public boolean add(Element anElement) throws DuplicateObjectException{
        if(currentSize == MAXSETSIZE){
            return false;
        }
        else if (this.isMemberOf(anElement)){
            //return false;

            throw new DuplicateObjectException("This object is already in the set!!!!");
        }
        
        theList[currentSize] = anElement.clone();

        
        currentSize++;
        
        if(currentSize == 1) currentIndex = 0;
        
        return true;
    }
    
    public void clear(){
        if (currentSize == 0){
            System.out.println("There are no objects in the set. ");
        }
        else{
            System.out.println("Here are the objects in the set: \n");
            for(int i = 0; i < currentSize; i++){
                theList[i].display();
                System.out.println("\n");
            }
        }
    }
    
    public boolean removeAnObject(Element anObject) throws CannotRemoveException{

        String paramClass = anObject.getClassName();
        String currClass;

        for (int i = 0; i < currentSize; i++) {
            //only compare anElement against those objects
            // that belong to anElement's class
            currClass = theList[i].getClassName();
            if(currClass.equals(paramClass) && theList[i].equals(anObject)) {
                if (i == currentSize - 1) {
                    theList[i] = null;
                    currentSize--;
                } else {
                    for (int j = i; j < currentSize - 1; j++) {
                        theList[j] = theList[j + 1];
                    }
                    currentSize--;
                }

                return true;
            }
        }
        throw new CannotRemoveException("Cannot remove this object!!!!");
    }
    
    
    public Element retrieveAnObject(Element anObject) throws CannotRetrieveException {

       String paramClass = anObject.getClassName();
       String currClass;

        for (int i = 0; i < currentSize; i++) {
                //only compare anElement against those objects
                // that belong to anElement's class
            currClass = theList[i].getClassName();
            if(currClass.equals(paramClass) && theList[i].equals(anObject)) {
                return theList[i].clone();
            }
        }

        throw new CannotRetrieveException("I cant reach this object!!!");
    }
}
    
    

    

