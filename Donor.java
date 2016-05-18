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
public class Donor extends Element{
    private String name;
    private String location;
    private double amount;
    
    //Default constructor to set everything to default values
    
    public Donor(){
        name = "";
        location = "";
        amount = 0.0;
    }
    
    //Creates Donor object and values passed in to name, location, and amount
    public Donor (String n, String loc, double a){
        name = n;
        location = loc;
        amount = a;
    }
    
    //Sets amount to am param
    public void setAmount(double am){
        this.amount = am;
    }
    //Sets location to location1 param
    public void setLocation(String location1){
        this.location = location1;
    }
    //Sets name to n parameter
    public void setName(String n){
        this.name = n; 
    }
    //Reads in information from user to create a donor object
    public void readIn(){
        Scanner kb = new Scanner(System.in);
        int issueCount = 0;
	System.out.print("Donor's name: ");
	this.name = kb.nextLine().toUpperCase().trim();
	System.out.print("Donor's location: ");
	this.location = kb.nextLine();
	System.out.print("Donation amount: ");
	this.amount= kb.nextDouble();
        
    }
    //Displays users input set in the Donor onject fields
    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.location);
	System.out.println("Amount: " + this.amount);
    }
    //returns name field
    public String getName(){
        return name;
    }
    //returns location field
    public String getLocation(){
        return location;
    }
    //returns amount field
    public double getAmount(){
        return amount;
    }
    //compares donor objects by name
    public boolean equals(Element otherDonor){
            return name.equals(((Donor) otherDonor).name); //get reall equals method
        }
    //clones Donor object    
    public Element clone(){
    Donor theDonor = new Donor();
    theDonor.setName(this.getName());
    theDonor.setLocation(this.getLocation());
    return theDonor;
    }
            
    
    
}
