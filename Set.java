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
import java.util.Scanner;
import java.util.ArrayList;

/**
 This revised version of the Set<T> generic class uses
 the revised version of the Element class, the version
 that uses the Object parameter for the abstract method,
 equals..

 This allows us to reintroduce the isMemberOf method to
 the Set data structure.
 */

public class Set <T>
{
    // Fields ...
    ArrayList<T> theList;
    // Will reference an ArrayList of objects
    // from the class T.
    int currentIndex;
    // Index of current element in the set
    final int START_CAP = 100;
    // Initial capacity of the ArrayList.
    // This over-rides the default initial
    // capacity of 10.

    // Constructor ...

    /**
     The Set constructor sets up an ArrayList of T references
     with STARTSIZE-many cells. It also initializes currentIndex
     to -1.
     */

    public Set()
    {
        theList = new ArrayList<T>(START_CAP);
        currentIndex = -1;
    }

    // Test methods

    /**
     The isEmpty method returns true if the calling object
     is empty and false otherwise.
     @return true if the calling object is empty and false
     otherwise.
     */

    public boolean isEmpty()
    {
        return theList.isEmpty();
    }

    /**
     The isMemberOf method tests to see if the parameter, aT,
     is already a member of the Set.  This assumes the type
     T has an appropriate equals method, redefining the Object
     class equals method, so that we are not just comparing
     references.
     @param anElement the object being checked for membership in
     the set
     @return true if anElement is already in the set and false
     */

    public boolean removeAnObject(T aT)
    {
       String paramClass = aT.getClass().getSimpleName();
        String currclass;
        int check = 0;
        //initialize check variable type int that increments when found
        //base case and middle case resolved
        //searches through set if not empty to remove a particular candidate or donor in the set

        if(!this.isEmpty()){
            int a = 0;
            for(int i = 0; i < theList.size(); i++) {
                currclass = theList.get(i).getClass().getSimpleName();
                if (currclass.equals(paramClass)){

                    if (theList.get(i).equals(aT)) {
                        if (i == theList.size() - 1) {
                            theList.remove(i);
                            check++;

                            return true;
                        } else {
                            a = i;
                            while (a < theList.size() - 1) {
                                theList.set(a, theList.get(a + 1));
                                theList.remove(a);
                                a++;
                            }

                            return true;
                        }
                    }
            }

            }

        }
        else{
            System.out.println("This set is empty");

        }
        if (check == 0)
        {
            System.out.println(paramClass + " is not in the set");

        }

        return false;
    }


    public T retrieveAnObject(T aT)
    {
       String paramClass = aT.getClass().getSimpleName(); String currClass;

        T anotherT;
        for (int i =0 ; i < theList.size(); i++)
        {
            anotherT = theList.get(i);

            currClass = anotherT.getClass().getSimpleName();

            if(anotherT.equals(aT))
            {
                //((Element)aT).display();
                return anotherT;
            }
        }
        System.out.println("The " + paramClass + "is not in the Set");
        return null;
    }

    public boolean isMemberOf(T aT)
    {
        // Local data ...
        T anotherT;
        String paramClass = aT.getClass().getName();
        // Why can't we call getClassName()?
        String currClass;

        // Logic ...
        for (T currT: theList)
        {
            currClass = currT.getClass().getName();

            // Only compare aT against those objects
            // that belong to aT's class
            if (currClass.equals(paramClass))
            {
                if (currT.equals(aT))
                {
                    return true;
                }
            }
        }

        // No matching object found
        return false;
    }

    // Access methods

    /**
     The size method returns the number of objects
     currently in the set.
     @return the value of currentSize
     */

    public int size()
    {
        return theList.size();
    }

    /**
     The getCurrent() method returns a reference to the
     current object in the set.  Note the pre-condition.
     This method should only be called if the set is
     not empty.  The method advances currentIndex to
     the next object to set up for the next call to
     getCurrent.  If getCurrent returns a copy of
     the last object, currentIndex is reset to 0. Note
     that this method assumes the type T has a
     copy constructor.
     Pre: currentIndex is not -1 (which can only
     occur if currentSize is not 0).
     @return reference to the current object in the set
     */

    public T getCurrent()
    {
        // Local data ...
        int saveIndex = currentIndex;

        // Logic ...
        if (currentIndex == theList.size() - 1)
        {
            // Recycle to beginning of list
            currentIndex = 0;
        }
        else
        {
            // Advance currentIndex to next object
            currentIndex++;
        }

        // Return a reference to the current object
        return theList.get(saveIndex);
        // NOTE:  WE ARE RETURNING A REFERENCE
        // TO AN OBJECT IN THE SET, NOT A COPY
        // OF THE OBJECT. WHY?  BECAUSE IF WE
        // TRIED TO USE THE clone() METHOD HERE
        // THE COMPILER GETS GRUMPY!  ALL METHODS
        // WE APPLY TO OBJECTS IN THE SET MUST BE
        // IN THE Object CLASS.
    }

    // Mutator methods ...

    /**
     The add method attenots to add the aT parameter to the set.
     It will fail if aT is already in the calling object set.
     @param aT the T-thing we attempt to add
     @return false if the object is a duplicate and
     it couldn't be added and true otherwise
     */

    public boolean add(T aT)
    {
        // Return false if aT is already in the calling object
        if (this.isMemberOf(aT))
        {
            // it's a duplicate - we can't add it
            return false;
        }

        // It's not a duplicate.  Add aT
        theList.add(aT);
        // NOTE: WE ARE ADDING THE REFERENCE TO aT,
        // WE ARE NOT CLONING IT.

        // Set currentIndex to object we just added if it was the
        // first object in the set.
        if (theList.size() == 1) currentIndex = 0;

        // Successful add
        return true;
    }

    /**
     The clear method resets the set to the empty set.
     */

    public void clear()
    {
        currentIndex = -1;
        theList = new ArrayList<T>();
    }

    // The display method

    /**
     The display method displays all of the objects in the
     set.  This method assumes that the class T implements
     the toString method in an appropriate manner, so that
     the contents of the relevant object can be displayed.
     */

    public void display()
    {
        // Local variables
        // we will display
        if (theList.size() == 0)
        {
            System.out.println("There are no objects in the set. ");
        }
        else
        {
            System.out.println("Here are the objects in the set: \n");
            for (int i = 0; i < theList.size(); i++)
            {
                System.out.println(theList.get(i).toString());
                System.out.println("\n");
            }
        }

    }
}



    

