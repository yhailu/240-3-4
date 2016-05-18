/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;
import java.util.Scanner;
/**
 *
 * @author yesuserahailu
 */
public class Abstractclass {

    /**
     * @param args the command line arguments
     */
    //main class 
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner(System.in);
       int menuChoice = 0;
       boolean userDoesNotWantToQuit = true;
       ElementSet theElemSet = new ElementSet();
        
        //call the menu option from the getMenuChoice() method
        //menuChoice = getMenuChoice();
        
        /*
        While loop that loops for user response and implements the menu based on
        users input
        */
        
        while(userDoesNotWantToQuit){
            
            try {
                //switch on menuchoice based on user input
                switch (getMenuChoice()) {
                    case 1:
                        addCandidate(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 2:
                        addDonor(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 3:
                        displayAllCandidateNames(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 4:
                        displayAllDonorNames(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 5:
                        displayParticularCandidate(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 6:
                        displayParticularDonor(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 7:
                        removeCandidate(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 8:
                        removeDonor(theElemSet);
                        //menuChoice = getMenuChoice();
                        break;
                    case 9:
                        System.out.println("Are you sure you want to quit? (y/n)");
                        String answer = kb.nextLine();
                        if (answer.equals("y")) {
                            userDoesNotWantToQuit = false;
                        } else {
                            menuChoice = getMenuChoice();
                        }
                        break;
                }
            }// end try
            catch (DuplicateObjectException e)
            {
                System.out.println(e.getMessage());
            }
            catch (CannotRetrieveException e)
            {
                System.out.println(e.getMessage());

            }
            catch (CannotRemoveException e)
            {
                System.out.println(e.getMessage());
            }

        }
    }
    
    //method handling the user's choice
    public static int getMenuChoice(){
      int menuChoice = 0;
      
      Scanner kb = new Scanner(System.in);
      
      System.out.println("The West Chester Presidential Candidate Tracking "
                + "Society Data Menu");
      System.out.println("1 - Add a new Candidate \n"
                + "2 - Add a new Donor \n"
                + "3 - Display the names of all the Candidates \n"
                + "4 - Display the names of all the Donors \n"
                + "5 - Display all the data fot a particular Candidate \n"
                + "6 - Display all of the data for a particular Donor \n"
                + "7 - Remove a particular Candidate \n"
                + "8 - Remove a paraticular Donor \n"
                + "9 - Quit ");
      menuChoice = kb.nextInt();
      
      //input validation for user input
      //must be in the bounds of 1-9
      if (menuChoice < 1 || menuChoice > 9) {
        System.out.println("Invalid choice has been entered.");
        
        
      }
      
      
      return menuChoice;
    }
    
    //adds a canididate object to the ElementSet
    public static void addCandidate(ElementSet aSet) throws DuplicateObjectException{
        Element anElement;
        anElement= new candidate();
        anElement.readIn();

        boolean addResult;
        addResult = aSet.add(anElement);

        if (addResult == false){
            System.out.println("Could not add. Set is full.\n");
        }

        else{
            System.out.println("Successful add.\n");
        }
     
    }
    
    //adds a Donor object to the ElementSet class
    public static void addDonor (ElementSet aSet) throws DuplicateObjectException{
        Element anElement;
        
        anElement = new Donor();
        anElement.readIn();
        
        boolean addResult = aSet.add(anElement);

        if (addResult = false){
            System.out.println("Could not add. Set is full.\n");
        }

        else{
            System.out.println("Successful add.\n");
        }
    }
    //this method displays all the candidate names already in the ElementSet
    public static void displayAllCandidateNames(ElementSet theElemSet){
        
        System.out.println("Display all the Candidate names"
        + " in the ELementSet");

        if(theElemSet.size() == 0)
            System.out.println("There is nothing in here!!!");


        Element anElement;
        for (int i = 0; i < theElemSet.size(); i++) {
            anElement = theElemSet.getCurrent();
            if(anElement.getClassName().equals("candidate"))
            {
                System.out.println(((candidate)anElement).getName());
            }
        }
        
    }
    //This method displays all the donor names in the ElementSet
    public static void displayAllDonorNames(ElementSet theElemSet) {
        System.out.println("Display all the Donor names in the ElementSet");
        Element anElement;

        if(theElemSet.size() == 0)
            System.out.println("There is nothing in here!!!");
        
        for (int i = 0; i < theElemSet.size(); i++) {
            anElement = theElemSet.getCurrent();
            if(anElement.getClassName().equals("Donor"))
            {
                System.out.println(((Donor)anElement).getName());
            }
        

        }
    }
    //This method displays a particular candidate
    //user is asked to input the name of a candidate
    //then that is sent to the retrieveAnObject method in the ElementSet
    //Then all the information of that candidate is displayed to th user
    public static void displayParticularCandidate (ElementSet aSet) throws CannotRetrieveException{

        Scanner kb = new Scanner(System.in);
        System.out.println("What is the name of the Candidate?");
        String canName = kb.nextLine().toUpperCase();
        Element placeHolder;

        candidate c = new candidate();
        c.setName(canName);
        placeHolder = c;
        Element a = aSet.retrieveAnObject(placeHolder);
        a.display();

    }
    //This method displays a particular Donor
    //user is asked to input the name of a Donor
    //then that is sent to the retrieveAnObject method in the ElementSet
    //Then all the information of that Donor is displayed to th user
    public static void displayParticularDonor(ElementSet aSet) throws CannotRetrieveException{

        Scanner kb = new Scanner(System.in);
        System.out.println("What is the name of the Donor?");
        String donorName = kb.nextLine().toUpperCase();
        Element placeHolder;

        Donor d = new Donor();
        d.setName(donorName);
        placeHolder = d;
        Element a = aSet.retrieveAnObject(placeHolder);
        a.display();
    }
    //asks user for donor name and removes donor from elementSet class
    //Prompts user when donor is removed and if donor was found or not
    public static void removeCandidate(ElementSet aSet) throws CannotRemoveException{
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the name of the candidate you want to remove "
                + "");
        String candidateName = kb.nextLine().toUpperCase();
        candidate c = new candidate();
        c.setName(candidateName);
        boolean remove = aSet.removeAnObject(c);
        if (remove){
            System.out.println(candidateName +"has been removed");

        } else {
            System.out.println("Could not remove this candidate");
        }




    }
    //asks user for donor name and removes donor from elementSet class
    public static void removeDonor(ElementSet aSet) throws CannotRemoveException{
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the name of the Donor you want to remove "
                + "");
        String donorName = kb.nextLine().toUpperCase();
        Donor d = new Donor();
        d.setName(donorName);
        boolean remove = aSet.removeAnObject(d);
        if (remove){
            System.out.println(donorName +"has been removed");

        } else {
            System.out.println("Could not remove this Donor");
        }

    }
}

    
        
        
        
        
    
    
    
