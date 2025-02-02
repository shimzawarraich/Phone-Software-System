//Purpose: This program represents a basic phone with general apps that can be found on a phone. The user is to enter a password and can then use these apps. These apps function differently depending on what they are used for

//Import java classes/libraries  
import java.util.*;
import java.io.*;
import simplecalculatorapp.Math;
import settingapp.Colour;
import settingapp.Password;
import contactsapp.Contacts; 
import bankapp.Account;
import noteapp.Notes;
import contactsapp.Contact; 

//Start of main class 
class Phone {
  public static void main(String[] args) {
    System.out.println();

    //Create scanner object 
    Scanner input = new Scanner(System.in);

    //Create/Initalize Variables 
    int exit, appOption = 0;
    boolean correctPassword, character;

    //Check if password is correct 
    do{
      correctPassword = false;

      //get correct password
      correctPassword = loginPassword();
      
    }while(correctPassword == false);
    clearScreen();

    //Main menu of the program
    //Displays list of apps 
    //Do while loop to continue using the code until the user 
    //wants to exit
    do{
      exit = 0;
      //get app option
      do{
        character = false;
        try{
          System.out.print("\nLIST OF APPS");
          System.out.print("\n---------------------------------------");
          System.out.print("\n1. Simple Calculator \n2. Notes \n3. Contacts \n4. Banking \n5. Settings");
    
          //Allow user to enter the number associated to each app 
          System.out.print("\nEnter the number corralated to the app you want: ");
          appOption = input.nextInt();
        }
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        }
        if((appOption < 1 || appOption > 5) && character == false){
          System.out.print("\nInvalid Input");
        }
      }while(character == true || appOption < 1 || appOption > 5);
      clearScreen();
      
      //If statements to access the different apps based on
      //number
      if(appOption == 1){
        simpleCalculatorOption();
        exit = exitOption();
      }//end of if statement for option 1

      else if(appOption == 2){
        notesOption();
        exit = exitOption();
      }//end of if statement for option 2

      else if(appOption == 3){
        contactsOption();
        exit = exitOption();
      }//end of if statement for option 3

      else if(appOption == 4){
        bankingOption();
        exit = exitOption();
      }//end of if statement for option 4

      else{
        settingsOption();
        exit = exitOption();
      }//end of if statement for option 5    
    }while(exit == 1);//end of do while loop
    
  }//end of main class

  //Method for the login password 
  static boolean loginPassword(){

    //Declare/Initalize variables 
    String line = "";
    String enteredPassword = "";
    boolean emptyfile = false, correctPassword = false;

    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Create a file reader to read the login password file
    try{
      
      FileReader fr = new FileReader("LoginPassword.txt");
      BufferedReader reader = new BufferedReader(fr);
        
      line = reader.readLine();

      //check if there is a saved password
      if(line == null){
        System.out.print("\nNo password [go to setting to make your password]\n");
        emptyfile = true;
        correctPassword = true;
      }

      //see if entered password is correct
      if(emptyfile == false){

        System.out.print("\nEnter your password: ");
        enteredPassword = input.nextLine();
  
        if(enteredPassword.equals(line)){
          correctPassword = true;
        } 
      }
      reader.close();
    }//End of try
      
    catch(IOException err){
      System.out.println("Error reader from a file");
      input.next();
    }//end of catch 
  
    return correctPassword;
  }//end of password  method

  //Method for simple calculator app 
  public static void simpleCalculatorOption(){

    //Create/Initalize variables 
    double num1 = 0, num2 = 0;
    int choice = 0;
    String operation = "";
    boolean character;

    //Create scanner object 
    Scanner input = new Scanner(System.in);
    Math myMath;

    //do while loop for when the user wants to run the app 
    //again
    do{
      clearScreen();
      //Allow the user to enter the first number
      do{
        character = false;
        try{
          System.out.print("\nEnter num1: ");
          num1 = input.nextDouble();
        }
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        }
      }while(character == true);
      clearScreen();
        
      //Display the operations list and allow user to enter 
      //the preferred operation 
      do{
        character = false;
        try{
          System.out.print("\n1. + \n2. - \n3. x \n4. ÷");
          System.out.print("\nEnter the number corralated to the operation you want: ");
          operation = input.next();
          choice = Integer.parseInt(operation);
        }
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        }
        catch(NumberFormatException err){
          character = true;
        }
        if(choice < 1 || choice > 4){
          System.out.print("\nInvalid Input");
        } 
      }while(character == true || choice < 1 || choice > 4);
      clearScreen();

      //Allow user to enter the second number 
      do{
        character = false;
        try{
          System.out.print("\nEnter num2: ");
          num2 = input.nextDouble(); 
        }
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        }
      }while(character == true);
      clearScreen();

      myMath = new Math(num1, num2, operation);
      
      //if statements to display and calculate the answers based on the 
      //operations entered 
      if(operation.equals("1")){
        System.out.print(num1 + " + " + num2 + " = " + myMath.calculatorAnswer());
      }
  
      else if(operation.equals("2")){
        System.out.print(num1 + " - " + num2 + " = " + myMath.calculatorAnswer());
      }
  
      else if(operation.equals("3")){
        System.out.print(num1 + " x " + num2 + " = " + myMath.calculatorAnswer());
      }
  
      else if(operation.equals("4")){
        System.out.print(num1 + " ÷ " + num2 + " = " + myMath.calculatorAnswer());
      }
      else{
        System.out.print("INVALID INPUT");
      }

      System.out.print("\n");
    
    }while(playAgain() == 1);//end of do while loop
  }//end of calculator app method 

  //Metod for the notes app
  public static void notesOption(){

    //Declare/Initalize variables 
    int choice = 0;
    String notes = "";
    String title = "";
    boolean correctPassword;
    boolean theInput;

    //Create scanner object 
    Scanner input = new Scanner(System.in);
    Notes myNotes = new Notes(notes, title);

    //do while loop for when the user wants to run the app again
    do{
      clearScreen();
      //do while loop for checking to see if the password is correct
      do{
        correctPassword = false;
  
        correctPassword = notesPassword();
        
      }while(correctPassword == false);//end of correct password do while loop
      clearScreen();

      //do while loop for valid input 
      do{
        theInput = false; 
      try{
      //Display promp asking the user to enter the corresponding 
      //numbers for the specific task they want to do
        System.out.println("\nEnter: \n1. if you would like to create a new note. \n2. If you would like to view an existing note. \n3. If you would like to delete a note.");
        choice = input.nextInt(); 
        }
        catch(InputMismatchException eeee){
          System.out.print("\nInvalid Input");
          input.next();
          theInput = true; 
        }
        catch(NumberFormatException errrr){
          theInput = true;
        }
      //if statement to check for valid input 
        if((choice < 1 || choice > 3) && theInput == false){
          System.out.print("\nInvalid Input");
        }
      }while(theInput == true || choice < 1 || choice > 3);
      //end of valid input do while loop
      clearScreen();
      
      //If statements for the tasks involving the notes app
      if (choice == 1){
        
        //Display prompt to create a new note and allow the user 
        //to create one
        System.out.println("\nAdd a title for your new note.");
        title = input.next();
        System.out.println("\nCreate a new note below and then enter \"saved\" to save your note.\n");

        //do while loop to ceate and save a note
      do{
        notes = input.nextLine();
        myNotes.setNotes(notes);
        myNotes.createNotes(title);
      }while(!(notes.equalsIgnoreCase("Saved")));
        //end of creating note do while loop
        myNotes.date(title);
    }//end of creating a new note if statement

    clearScreen();
      
    //if statement to view a note
    if (choice == 2){
      System.out.println("\nEnter the title of the note you would like to view.");
      title = input.next();
      myNotes.setTitle(title); 

      myNotes.viewNotes(); 
    }//end of viewing notes if statement 
 
      //If statement for deleting a note 
    if (choice == 3){
      System.out.println("Enter the title of the note you would like to delete.");
      title = input.next();
      myNotes.deleteNote(title);
    }//end of delete note if statement
      
    }while(playAgain() == 1);//end of do while loop 
  }//end of notes app method 

  //Methid for the notes password
  static boolean notesPassword(){

    //Declare/Initalize variables 
    String line = "";
    String enteredPassword = "";
    boolean emptyfile = false, correctPassword = false;

    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Create a file reader to read the login password 
    try{
      
      FileReader fr = new FileReader("NotesPassword.txt");
      BufferedReader reader = new BufferedReader(fr);
        
      line = reader.readLine();

    
      if(line == null){
        System.out.print("\nNo password [go to setting to make your  notes password]\n");
        emptyfile = true;
        correctPassword = true;
      }

      if(emptyfile == false){

        System.out.print("\nEnter your password: ");
        enteredPassword = input.nextLine();
  
        if(enteredPassword.equals(line)){
          correctPassword = true;
        } 
      }
      reader.close();
    }//End of try
      
    catch(IOException err){
      System.out.println("Error reader from a file");
      input.next();
    }//end of catch 
   
    return correctPassword;
  }//end of notes password method

  //Method for the contacts app 
  public static void contactsOption(){
    
    //Declare/Initialize Variables 
    String contactName = "";
    String thePhoneNumber = "";
    int option = 0;
    boolean theInput;
     
    //Create scanner object 
    Scanner input = new Scanner(System.in);
    
    //ArrayList for multiple phone numbers 
        ArrayList<String> multiplePhoneNumbers = new ArrayList<String>();
    
    Contact contactsList = new Contact(multiplePhoneNumbers, contactName);
    Contacts officalContactList = new Contacts(multiplePhoneNumbers, contactName);
    
    //Do while loop for when the user wants to run the app 
    //again
    do{
      clearScreen();
    //do while loop to check for valid input   
    do{
      theInput = false;
      try{
    //Display prompt to allow user to enter the numbers 
    //corresponding to the task they want to do
        System.out.println("\nEnter: \n1. if you would like to create a new contact\n2. if you would like to veiw a contact. \n3. if you would like to delete a contact");

        option = input.nextInt(); 
      }
      catch(InputMismatchException e){
        System.out.print("\nInvalid Input");
        input.next();
        theInput = true; 
      }
      catch(NumberFormatException err){
        theInput = true;
      }
      if((option < 1 || option > 3) && theInput == false){
        System.out.print("\nInvalid Input");
      }
    }while(theInput == true || option < 1 || option > 3); 
    //end of checking for valid input do while loop
    clearScreen();
      
    clearScreen();
    //if statement to access the different tasks for the 
    //contacts app  
      if(option == 1){
        
    //Allow user to enter a contcat name for the new 
    //contact
         System.out.print("\nEnter the name of your new contact: ");

         contactName = input.next();
         contactsList.setName(contactName);
        
    //Allow user to enter the phone number(s) for the new contact
        
         System.out.println("\nEnter the phone number(s) of your new contact using ONLY integers, or 0 to save.");
        
    //do while loop to allow user to add phone numbers until 0 is entered
    do{
      //prompt the user to enter the phone number(s)
      System.out.print("\nEnter the phone number for the created contact: ");
      thePhoneNumber = input.next();

      //if statement to check for valid user input 
      if (!(thePhoneNumber.matches("[0-9]+"))){
        System.out.println("Invalid Input");
      }//end of valid user input if statement 
      else{
        multiplePhoneNumbers.add(thePhoneNumber);
      }
      
      }while(!(thePhoneNumber.equals("0")));
      //end of multiple phone numbers do while loop
          
        multiplePhoneNumbers.remove("0");
        
        contactsList.setNumbers(multiplePhoneNumbers);
        
      //Print the new contact to a text file
         contactsList.createContact(multiplePhoneNumbers);
        officalContactList.createContactList(contactName, multiplePhoneNumbers);

      //clears the array list
        multiplePhoneNumbers.clear();
      
       
      }//end of option 1 if statement 

      if(option == 2){

        //Diaplay prompt and allow user to enter the contact 
        //name of the contact they would like to veiw 
        System.out.print("\nEnter the contact name of the contact you would like to veiw: ");
        
        contactName = input.next();
        contactsList.setName(contactName);

        //print contact to the main class 
        System.out.println("\n");
        contactsList.veiwContact();
      }//end of option 3 if statement 

      if(option == 3){

        //Display prompt and allow user to enter the contact 
        //name of the contact they would like to delete  
        System.out.print("\nEnter the contact name of the contact you would like to delete: ");

        contactName = input.next();

        //Delete the file corresponding to the contact
        contactsList.deleteContact(contactName);
      }//end of option 4 if statement
      
      
    }while(playAgain() == 1);//end of do while loop
  }//end of contacts app method 

  //Method for the banking app
  public static void bankingOption(){

    //Declare/Initalize variables 
    int choice = 0, integerPlaces = 0, decimalPlaces = 0;
    boolean withdraw, correctPassword, character;
    double money = 0;
    String line, moneyString = "";

    //Create scanner object 
    Scanner input = new Scanner(System.in);
    Account myAccount = new Account(money);

    do{
      correctPassword = false;

      correctPassword = bankingPassword();
    }while(correctPassword == false);

    //Do while loop for when the user wants to run the app 
    //again
    do{
      clearScreen();

      //Display and allow user to enter the number for the 
      //corresponding task 
      do{
        character = false;

        try{
          System.out.print("\nEnter 1 to add, 2 to withdraw or 3 to go to your savings account: ");
          choice = input.nextInt();
        }   
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        }
        if((choice < 1 || choice > 3) && character == false){
          System.out.print("\nInvalid Input");
        } 
      }while(character == true || choice < 1 || choice > 3);
      clearScreen();

      //if statements for the different tasks for the banking 
      //app
      if(choice == 1){

        withdraw = false;

        //Print chequings 
        System.out.print("\nCHEQUINGS");
        System.out.print("\n---------------------------------------");
        //Print the current balance and allow the user to enter 
        //the amount of money they would like to add. 
        System.out.print("\nCurrent balance: $" + currentChequings());

        do{
          character = false;
          try{
            System.out.print("\nEnter the amount of money you would like to add: $");
            money = input.nextDouble();

            moneyString = Double.toString(money);
            integerPlaces = moneyString.indexOf('.');
            decimalPlaces = moneyString.length() - integerPlaces - 1;
          }
          catch(InputMismatchException err){
            System.out.print("\nInvalid Input");
            input.next();
            character = true; 
          }
          if(money < 0 && character == false){
            System.out.print("\nInvalid Input");
          } 
          else if(decimalPlaces > 2 && character == false){
            System.out.print("\nInvalid Input");
          }
        }while(character == true || money < 0 || decimalPlaces > 2);
        
        //Add the amount of money to the bank balance 
        myAccount.setMoney(money);

        //Display the new balance 
        System.out.print("\nNew balance: $" + myAccount.newChequingBalance(withdraw, currentChequings()));
        
      }//end of the adding if statement 

      else if(choice == 2){

        withdraw = true;

        //Print chequings 
        System.out.print("\nCHEQUINGS");
        System.out.print("\n---------------------------------------");
        //Print the current balance and allow the user to enter 
        //the amount of money they would like to add. 
        System.out.print("\nCurrent balance: $" + currentChequings());

        do{
          character = false;
          try{
            System.out.print("\nEnter the amount of money you would like to withdraw: $");
            money = input.nextDouble();

            moneyString = Double.toString(money);
            integerPlaces = moneyString.indexOf('.');
            decimalPlaces = moneyString.length() - integerPlaces - 1;
          }
          catch(InputMismatchException err){
            System.out.print("\nInvalid Input");
            input.next();
            character = true; 
          }
          if(money < 0 && character == false){
            System.out.print("\nInvalid Input");
          } 
          else if(decimalPlaces > 2 && character == false){
            System.out.print("\nInvalid Input");
          }
        }while(character == true || money < 0 || decimalPlaces > 2);

        //Add the amount of money to the bank balance 
        myAccount.setMoney(money);

        //Display the new balance 
        System.out.print("\nNew balance: $" + myAccount.newChequingBalance(withdraw, currentChequings()));
      }

      else if(choice == 3){

        do{
          character = false;
          try{
            System.out.print("\nEnter 1 to add or 2 to withdraw from your savings account: ");
            choice = input.nextInt();
          }
          catch(InputMismatchException err){
            System.out.print("\nInvalid Input");
            input.next();
            character = true; 
          }
          if((choice < 1 || choice > 2) && character == false){
            System.out.print("\nInvalid Input");
          } 
        }while(character == true || choice < 1 || choice > 2);
        clearScreen();
      
        if(choice == 1){

          withdraw = false;
  
          //Print chequings 
          System.out.print("\nSAVINGS");
          System.out.print("\n---------------------------------------");
          //Print the current balance and allow the user to enter 
          //the amount of money they would like to add. 
          System.out.print("\nCurrent balance: $" + currentSavings());

          do{
            character = false;
            try{
              System.out.print("\nEnter the amount of money you would like to add: $");
              money = input.nextDouble();
  
              moneyString = Double.toString(money);
              integerPlaces = moneyString.indexOf('.');
              decimalPlaces = moneyString.length() - integerPlaces - 1;
            }
            catch(InputMismatchException err){
              System.out.print("\nInvalid Input");
              input.next();
              character = true; 
            }
            if(money < 0 && character == false){
              System.out.print("\nInvalid Input");
            } 
            else if(decimalPlaces > 2 && character == false){
              System.out.print("\nInvalid Input");
            }
          }while(character == true || money < 0 || decimalPlaces > 2);
          //Add the amount of money to the bank balance 
          myAccount.setMoney(money);
  
          //Display the new balance 
          System.out.print("\nNew balance: $" + myAccount.newSavingsBalance(withdraw, currentSavings()));
        
        }//end of the adding if statement 

        else if(choice == 2){

          withdraw = true;
  
          //Print chequings 
          System.out.print("\nSAVINGS");
          System.out.print("\n---------------------------------------");
          //Print the current balance and allow the user to enter 
          //the amount of money they would like to add. 
          System.out.print("\nCurrent balance: $" + currentSavings());
          
          do{
            character = false;
            try{
              System.out.print("\nEnter the amount of money you would like to withdraw: $");
              money = input.nextDouble();
  
              moneyString = Double.toString(money);
              integerPlaces = moneyString.indexOf('.');
              decimalPlaces = moneyString.length() - integerPlaces - 1;
            }
            catch(InputMismatchException err){
              System.out.print("\nInvalid Input");
              input.next();
              character = true; 
            }
            if(money < 0 && character == false){
              System.out.print("\nInvalid Input");
            } 
            else if(decimalPlaces > 2 && character == false){
              System.out.print("\nInvalid Input");
            }
          }while(character == true || money < 0 || decimalPlaces > 2);
  
          //Add the amount of money to the bank balance 
          myAccount.setMoney(money);
  
          //Display the new balance 
          System.out.print("\nNew balance: $" + myAccount.newSavingsBalance(withdraw, currentSavings()));
        }
         
      }
  
    }while(playAgain() == 1);//end of do while loop 
  }//end of banking app method

  //Method for the current chequing balance
  static double currentChequings(){

    //Declare/Initalize variables 
    String line = "";
    double currentBalance = 0;

    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Create a file reader to read the login password 
    try{
      
      FileReader fr = new FileReader("Chequings.txt");
      BufferedReader reader = new BufferedReader(fr);
        
      line = reader.readLine();

      currentBalance = Double.parseDouble(line);

      reader.close();
    }//End of try
      
    catch(IOException err){
      System.out.println("Error reader from a file");
      input.next();
    }//end of catch 
   
    
    return currentBalance;

  }//end of current chequings method

    //Method for the current saving balance
  static double currentSavings(){

    //Declare/Initalize variables 
    String line = "";
    double currentBalance = 0;

    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Create a file reader to read the login password 
    try{
      
      FileReader fr = new FileReader("Savings.txt");
      BufferedReader reader = new BufferedReader(fr);
        
      line = reader.readLine();

      currentBalance = Double.parseDouble(line);

      reader.close();
    }//End of try
      
    catch(IOException err){
      System.out.println("Error reader from a file");
      input.next();
    }//end of catch 
   
    
    return currentBalance;

  }//end of current savings method

  static boolean bankingPassword(){

    //Declare/Initalize variables 
    String line = "";
    String enteredPassword = "";
    boolean emptyfile = false, correctPassword = false;

    //Create scanner object
    Scanner input = new Scanner(System.in);

    //Create a file reader to read the login password 
    try{
      
      FileReader fr = new FileReader("BankingPassword.txt");
      BufferedReader reader = new BufferedReader(fr);
        
      line = reader.readLine();

    
      if(line == null){
        System.out.print("\nNo password [go to setting to make your password]\n");
        emptyfile = true;
        correctPassword = true;
      }

      if(emptyfile == false){

        System.out.print("\nEnter your password: ");
        enteredPassword = input.nextLine();
  
        if(enteredPassword.equals(line)){
          correctPassword = true;
        } 
      }
      reader.close();
    }//End of try
      
    catch(IOException err){
      System.out.println("Error reader from a file");
      input.next();
    }//end of catch 
   
    
    return correctPassword;

  }//end of banking password method

  //Method for settings app
  public static void settingsOption(){

    //Declare/Initalize variables 
    int colour = 0, choice = 0;
    String password = "";
    boolean character;

    //Create scanner object 
    Scanner input = new Scanner(System.in);

    //Do while loop for when the user wants to run the app 
    //again
    do{
      clearScreen();

      //Allow user to enter the numbers corresponding to the settings they want to access 
      do{
        character = false;
        try{
          System.out.print("\nEnter 1 for colour settings or 2 to change your passwords: ");
          choice = input.nextInt();
        }
        catch(InputMismatchException err){
          System.out.print("\nInvalid Input");
          input.next();
          character = true; 
        } 
        if((choice < 1 || choice > 2) && character == false){
          System.out.print("\nInvalid Input");
        }
      }while(character == true || choice < 1 || choice > 2);
      clearScreen();
      
      //If statements to access the different settings 
      if(choice == 1){
        //Display the list of font colours for the user to 
        //choice from using the numbers 
        do{
          character = false;
          try{
            System.out.print("\n1. Default \n2. Red \n3. Blue \n4. Green");
            System.out.print("\nEnter the number corralated to the colour you want: ");
            colour = input.nextInt();
          }
          catch(InputMismatchException err){
            System.out.print("\nInvalid Input");
            input.next();
            character = true; 
          }
          if((colour < 1 || colour > 4) && character == false){
            System.out.print("\nInvalid Input");
          }
        }while(character == true || colour < 1 || colour > 4);
        clearScreen();
        
        Colour myColour = new Colour(colour);

        //Display the text based on the colour entered 
        System.out.print(myColour.colourSetting(colour));   
      }//end of colour if statement 

      else{
        do{
          character = false;
          choice = 0;
          try{
            System.out.print("\n1. Login \n2. Banking \n3. Notes");
            System.out.print("\nEnter the number corralated to the password you want change: ");
            choice = input.nextInt();
          }
          catch(InputMismatchException err){
            System.out.print("\nInvalid Input");
            input.next();
            character = true; 
          }
          if((choice < 1 || choice > 3) && character == false){
            System.out.print("\nInvalid Input");
          }
        }while(character == true || choice < 1 || choice > 3);
        clearScreen();

        if(choice == 1){
          //Allow user to enter a new login password 
          System.out.print("\nEnter your new login password: ");
          password = input.next();
          
          Password myPassword = new Password(password);
  
          //Change the login password           
          myPassword.loginPasswordSetting();
        }
        else if(choice == 2){
          System.out.print("\nEnter your new banking password: ");
          password = input.next();
          
          Password myPassword = new Password(password);
  
          //Change the banking password 
          myPassword.bankingPasswordSetting();
        }
        else{
          System.out.print("\nEnter your new notes password: ");
          password = input.next();

          Password myPassword = new Password(password);

          //Change the notes password
          myPassword.notesPasswordSetting();
        }  
      }
        
    }while(playAgain() == 1);//end of do while loop 
  }//end of setting app method 

  //Method for allowing the user to exit apps and choose between 
  //other apps
  public static int exitOption(){

    //Create scanner object 
    Scanner input = new Scanner(System.in);

    boolean character;
    int choice = 0;

    //Display prompt and allow user to 1 in order to access 
    //another app
    do{
      character = false;
      try{
        System.out.print("\nEnter 1 to select another app or 2 to exit: ");
        choice = input.nextInt();
      }
      catch(InputMismatchException err){
        System.out.print("\nInvalid Input");
        input.next();
        character = true; 
      }  
      if((choice < 1 || choice > 2) && character == false){
        System.out.print("\nInvalid Input");
      }
    }while(character == true || choice < 1 || choice > 2);
      
    clearScreen();
    return choice;
  }//end of eixt method 

  //Method to allow the user to run an app again 
  public static int playAgain(){

    //Create scanner object 
    Scanner input = new Scanner(System.in);

    boolean character;
    int choice = 0;
    //Display prompt and allow the user to enter 1 in order to run 
    //a specific app again
    do{
      character = false;
      try{
        System.out.print("\nEnter 1 to run this app again or 2 to exit: ");
        choice = input.nextInt();
      }
      catch(InputMismatchException err){
        System.out.print("\nInvalid Input");
        input.next();
        character = true; 
      }  
      if((choice < 1 || choice > 2) && character == false){
        System.out.print("\nInvalid Input");
      }
      
    }while(character == true || choice < 1 || choice > 2);

    clearScreen();
    return choice;  
  }//end of running the app again method 

  //Method to clear the console 
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }//end of the clear console method  

}//end of main
