//Purpose: The class for the calculator app. Calculates the answer of two numbers using the inputted operation.

//Import packages/libraries
package simplecalculatorapp;
import java.text.DecimalFormat;

//Start of the math class 
public class Math{

  //Declare/Initalize variables 
  private double num1;
  private double num2;
  private String operation; 

  //Constructors 
  public Math(double n1, double n2, String op){

    num1 = n1;
    num2 = n2;
    operation = op;
  }//end of constructor 

  //Setters 
  public void setNum1(double n1){

    this.num1 = n1;
  }//end of number1 setter 

  public void setNum2(double n2){
    this.num2 = n2;
  }//end of number2 setter 

  public void setOperation(String op){
    this.operation = op;
  }//end of operations setter 

  //Getters 
  public double getNum1(){
    return this.num1;
  }//end of number1 getter 

  public double getNum2(){
    return this.num2;
  }//end of number2 getter 

  public String getOperation(){
    return this.operation;
  }//end of ooperations getter 

  //Method to calculate the answer based on the inputted operantion
  public String calculatorAnswer(){

    double answer = 0;

    //Create decimal format object 
    DecimalFormat df = new DecimalFormat("0.00");

    //If statements for calculations with the different operations 
    if(operation.equals("1")){
      answer = getNum1() + getNum2();
    }//end of if statement for the adding operation

    else if(operation.equals("2")){
      answer = getNum1() - getNum2();
    }//end of if statement for the subtracting operation

    else if(operation.equals("3")){
      answer = getNum1() * getNum2();
    }//end of if statement for the mmultiplying operation

    else if(operation.equals("4")){
      answer = getNum1() / getNum2();
    }//end of if statement for the dividing operation 

    return df.format(answer); 
  }//end of calculating the answer method 
  
}//end of calculator class 
