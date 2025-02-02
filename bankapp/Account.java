//Purpose: A class representing the banking app. Creates getters and setters for the diffreent variables used in the app. Allows the calculations for different task involving the app

//Import packages and libraries 
package bankapp;
import java.io.*;
import java.text.DecimalFormat;

//Start of the account class 
public class Account{

  //Declare variables 
  private double money;

  //Constructors 
  public Account(double m){

    money = m;
    
  }//end of constructor 

  //Setters
  public void setMoney(double m){
    
    this.money = m;
  }//end of money setter

  //Getters 
  public double getMoney(){

    return this.money;
  }//end of money getter 
  
  //Method to calculate the new chequing balance 
  public double newChequingBalance(boolean withdraw, double currentBalance){

    //Declare/Initalize variables 
    double newBalance = 0, money = getMoney();

    DecimalFormat df = new DecimalFormat("0.00");

    if(withdraw == false){

      newBalance = currentBalance + money;

      try{
        FileWriter fw = new FileWriter("Chequings.txt");
        PrintWriter printer = new PrintWriter(fw);

        printer.print(df.format(newBalance));

        printer.close();
      }
      catch(IOException err){
        System.out.println("Error");
      }//end of catch  
      
    }
    else if(withdraw == true){

      newBalance = currentBalance - money;

      try{
        FileWriter fw = new FileWriter("Chequings.txt");
        PrintWriter printer = new PrintWriter(fw);

        printer.print(newBalance);

        printer.close();
      }
      catch(IOException err){
        System.out.println("Error");
      }//end of catch  
    }

    return newBalance;
    
  }//end of chequing balance method

  //Method to calculate the new chequing balance 
  public double newSavingsBalance(boolean withdraw, double currentBalance){

    //Declare/Initalize variables 
    double newBalance = 0, money = getMoney();

    DecimalFormat df = new DecimalFormat("0.00");

    if(withdraw == false){

      newBalance = currentBalance + money;

      try{
        FileWriter fw = new FileWriter("Savings.txt");
        PrintWriter printer = new PrintWriter(fw);

        printer.print(df.format(newBalance));

        printer.close();
      }
      catch(IOException err){
        System.out.println("Error");
      }//end of catch  
      
    }
    else if(withdraw == true){

      newBalance = currentBalance - money;

      try{
        FileWriter fw = new FileWriter("Savings.txt");
        PrintWriter printer = new PrintWriter(fw);

        printer.print(newBalance);

        printer.close();
      }
      catch(IOException err){
        System.out.println("Error");
      }//end of catch  
    }

    return newBalance;
    
  }//end of chequing balance method

 
  
}//end of the accounts class 
