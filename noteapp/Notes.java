//Purpose: A class for the notes app. Creates new notes and allows the user to view/delete said note.

//Import packages/libraries 
package noteapp;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;    

//Start of the notes class 
public class Notes{

  //Declares/Initalize variables 
  private String notes = "";
  private String title= "";
  //private String date = "";

  //Constructors 
  public Notes(String theNotes, String theTitle){
    notes = theNotes;
    title = theTitle;
  }//end of constructor 

  //Getters
  public String getNotes(){
    return notes;
  }//end of notes getter 

  public String getTitle(){
    return title; 
  }//end of password getter 

  //Setters
  public void setNotes(String note){
    notes = note;
  }//end of notes setter

  public void setTitle(String theTitle){
    title = theTitle; 
  }//end of password setter 

  //Method to create a new note 
  public String createNotes(String theNotesTitle){ 
    //Writing to a file 
    try{
     FileWriter fw = new FileWriter (theNotesTitle + ".txt", true);
        PrintWriter printer = new PrintWriter (fw);
        printer.println(notes);
        printer.close();
      }//end of try
       catch (IOException e){
         System.out.println("Error making the specified note");
       }//end of catch 
    return theNotesTitle; 
  }//end of creating new notes method 

  //Method that allows the user to delete a note
  public String deleteNote(String name){
        File fw = new File(name + ".txt");
        fw.delete();
        return name;
  }//end of deleting contact method 

  //method to print the date the note was saved at
  public String date(String notesTitle){
    
    String theDate = ""; 
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
   LocalDateTime now = LocalDateTime.now();  
   theDate = dtf.format(now);
    
    //Writing to a file 
    try{
     FileWriter fw = new FileWriter (notesTitle + ".txt", true);
        PrintWriter printer = new PrintWriter (fw);
        printer.print("at " + theDate);
        printer.close();
      }//end of try
       catch (IOException e){
         System.out.println("Error making the specified note");
      }//end of catch 
    return notesTitle; 
  }//end of date method 

  public void viewNotes(){
    //Declare/Initalize variables
    String line = "";

    //Reading from a file  
     try{
      FileReader fr= new FileReader (title+ ".txt");
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
      System.out.println("The note does not exist");
    }//end of catch
  }
}//end of notes class 