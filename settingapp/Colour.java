//Purpose: The colour class for the settings app. Allows the colour of the font being displayed on the console to change depending on what the user inputs.

//Import packages 
package settingapp;

//Start of colour class 
public class Colour{

  //Declare variables 
  private int colour;

  //Constructor 
  public Colour(int c){

    colour = c;
  }//end of constructor 

  //Setter
  public void setColour(int c){

    //if statement for when an invalid input is entered 
    if(c < 1 || c > 4){
      throw new IllegalArgumentException("Invalid Input");
    }//end of invalid input if statement 
    else{
      this.colour = c;
    }//end of else 
  }//end of colour setter 

  //Getter 
  public int getColour(){
    return this.colour;
  }//end of colour getter 

  //Method to set the colours of the fonts acording to user input 
  public String colourSetting(int c){

    //Declare/Initalize variables 
    String colourChange = "";

    //If statements to change font colour depending on user input 
    if(colour == 1){
      colourChange = "\u001B[0m";
    }//end of colour 1 if statement 
    
    if(colour == 2){
      colourChange = "\u001B[31m";
    }//end of colour 2 if statement 

    if(colour == 3){
      colourChange = "\u001B[34m";
    }//end of colur three if statement 

    if(colour == 4){
      colourChange = "\u001B[32m";
    }//end of colour4 if statement 

    return colourChange;
  }//end of colour class 

  
}
