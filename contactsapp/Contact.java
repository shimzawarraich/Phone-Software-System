//Purpose: A class which is part of the contacts app, representing a single contact. Allows the information to be printed/read to and from a file. Also allows the user to delete and edit contacts using methods.

//Import packages/libraries 
package contactsapp; 
import java.io.*;
import java.util.*;

//Start of the contacts class 
public class Contact{

  //Declarings variables 
  private ArrayList<String> numbers;
  private String name;

  //Constructors 
  public Contact(ArrayList<String> phoneNumbers, String assignedName){
    numbers = phoneNumbers;
    name = assignedName; 
  }//end of constructor  

  //Getters 
  public ArrayList<String> getNumbers(){
    return numbers; 
  }//end of phone number getter

  public String getName(){
    return name; 
  }//end of contact name getter 

  //Setters 
  public void setNumbers(ArrayList<String> phoneNumbers){
      numbers = phoneNumbers;
  }//end of phone number setter 
  
  public void setName(String contact){
    name = contact;  
  }//end of contact name setter 

  //Method to create a new contact 
  public void createContact(ArrayList<String> phoneNumbers){
    int counter = 0; 

    //Wriring to a file 
    try{
     FileWriter fw = new FileWriter (name + ".txt", true);
        PrintWriter printer = new PrintWriter (fw);
        printer.println("--------CONTACT INFORMATION--------");
        printer.println("\nContact name: " + name); 
        phoneNumbers = numbers;
        int length = numbers.size();
        for (int i = 0; i < length; i++) {
            counter++;
            String theNumbers = phoneNumbers.get(i).toString();
            printer.println("\nPhone Number " + counter + ": " + theNumbers);
        }
        printer.close();
      }//end of try 
       catch (IOException e){
         System.out.println("Error making the specified contact");
      }//end of catch 
  }//end of creating a contact method 
  
  //Method to allow the user to veiw a contact 
  public void veiwContact(){
    
    //Declare/Initalize variables
    String line = "";

    //Reading from a file  
     try{
      FileReader fr= new FileReader (name + ".txt");
      BufferedReader reader = new BufferedReader (fr);
      line = reader.readLine();
      while(line != null){
        System.out.println(line);
        line = reader.readLine();
      }//end of while
      line = reader.readLine();
      reader.close();
    }//end of try 
    catch(IOException ee){
      System.out.println("Contact does not exist");
    }//end of catch 
  }//end of viewing contact method 

  //Method that allows the user to delete a contact 
  public String deleteContact(String theName){
        File fw = new File(theName + ".txt");
        fw.delete();
        return theName; 
  }//end of deleting contact method 
}//end of contact class