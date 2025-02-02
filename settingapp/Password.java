//Purpose: The password class for the settings app. Writes the entered password to a file and saves it.

//import packages/libraries  
package settingapp;
import java.io.*;

//Start of password class
public class Password{

  //Declare variables 
  private String password;

  //Constructor
  public Password(String p){

    password = p;
  }//end of constructor

  //Setter 
  public void setPassword(String p){

    this.password = p;
  }//end of password setter 

  //Getter
  public String getPassword(){

    return this.password;
  }//end of password getter 

  //Mathod to print the set password to a file 
  public void loginPasswordSetting(){

     //Writing to a file 
     try{
      FileWriter fw = new FileWriter("LoginPassword.txt");
  
      PrintWriter printer = new PrintWriter(fw);
       
      printer.println(password);
  
      printer.close();
    }//end of try
    catch(IOException err){
      System.out.println("Error writing to the file specified");
    }//end of catch 
  }//end of printing the password method 

  public void bankingPasswordSetting(){

     //Writing to a file 
     try{
      FileWriter fw = new FileWriter("BankingPassword.txt");
  
      PrintWriter printer = new PrintWriter(fw);
       
      printer.println(password);
  
      printer.close();
    }//end of try
    catch(IOException err){
      System.out.println("Error writing to the file specified");
    }//end of catch 
  }

  public void notesPasswordSetting(){

    try{
      FileWriter fw = new FileWriter("NotesPassword.txt");

      PrintWriter printer = new PrintWriter(fw);

      printer.println(password);

      printer.close();
    }
    catch(IOException err){
      System.out.println("Error writing to the file specified");
    }
  }
    
}//end of password class 