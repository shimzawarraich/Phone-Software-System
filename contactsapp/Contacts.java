//Purpose: A class in the contacts app that prints a list of contacts to a seperate file and allows the user to view this list.

//Import packages/libraries 
package contactsapp; 
import java.io.*;
import java.util.*;

//Start of the contacts class 
public class Contacts{

  //Declarings variables 
  private ArrayList<String> numbers;
  private String name;

  //Constructors 
  public Contacts(ArrayList<String> phoneNumbers, String assignedName){
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
  public String createContactList(String theName, ArrayList<String> phoneNumbers){
    int counter = 0; 

    //Wriring to a file 
    try{
     FileWriter fw = new FileWriter ("ContactsList.txt", true);
        PrintWriter printer = new PrintWriter (fw);
        printer.println("\nContact name: " + theName); 
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
         System.out.println("Error making the specified contact list");
      }//end of catch 
    return theName; 
  }//end of creating a contact method 
  
  //Method to allow the user to veiw a contact 
  public void veiwContactList(){
    
    //Declare/Initalize variables
    String line = "";

    //Reading from a file  
     try{
      FileReader fr= new FileReader ("ContactsList.txt");
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
      System.out.println("Could not read the contacts list.");
    }//end of catch 
  }//end of viewing contact method 
}//end of contacts class 