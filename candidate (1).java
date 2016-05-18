/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractclass;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author yesuserahailu
 */

public class candidate extends Element {
	private String name;
	private int age;
	private String party;
	private String issueList="";
	private String tokenList[]={};

	public candidate() {
		this.name = "";
		this.age = 0;
		this.party = "";
		this.issueList = "";
	}

	/**
	 *
	 * Candidate constructor. Creates a Candidate object and sets its data
	 * according to what is entered in the parameters.
	 *
	 * @param name
	 *            The name of the candidate.
	 * @param age
	 *            The age of the candidate.
	 * @param party
	 *            The political party the candidate belongs to.
	 * @param issueList
	 *            A list of important issues the candidate deals with.
	 */
	public candidate(String name, int age, String party, String issueList) {
		this.name = name;
		this.age = age;
		this.party = party;
		this.issueList = issueList;
	}

	public void setName(String n){  //set values in class from another class
		name=n;
	}

	public void setAge(int a){
		age=a;
	}

	public void setParty(String p){
		party=p;

	}
	public void setIssueList(int i){    //set issues for can using loop
		String issueList2[]=new String[5];

		Scanner kb=new Scanner(System.in);

		for(int j=0; j<i;j++){
			System.out.println("#"+(j+1)+":");
			issueList2[j]=kb.nextLine().toUpperCase();
			this.issueList=this.issueList+issueList2[j]+";";
		}


	}

	public String getName(){    //getter methods to retrieve data from another class
		return name;
	}

	public int getAge(){
		return age;
	}

	public String getParty(){
		return party;

	}
	public String getIssueList(){
		return issueList;

	}

	public void showIssues(){   //tokenize list into separate strings
		this.tokenList=this.getIssueList().split("[;]");

		for(String token:this.tokenList){
			System.out.println(token);
		}

	}

	public void display(){
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Party: "+party);
		this.showIssues();
	}

	public Element clone(){
		candidate theClone= new candidate();
		theClone.name=new String(name);
		theClone.party=new String(party);
		theClone.age=this.age;
		theClone.issueList= new String(issueList);
		return theClone;
	}

	public boolean equals(Element otherCan){

		return name.equals(((candidate) otherCan).name);
	}


	public void readIn(){
		Scanner kb=new Scanner(System.in);  //input information for candidate

		System.out.println("Input a candidate's:");

		System.out.println("Name:");
		this.setName(kb.nextLine().toUpperCase());  //set value to uppercase


		System.out.println("Age:");
		this.setAge(kb.nextInt());


		System.out.println("Party: ");
		this.setParty(kb.next().toUpperCase());


		System.out.println("Number of issues for this candidate?:");
		this.setIssueList(kb.nextInt());
		System.out.println("");
	}

}