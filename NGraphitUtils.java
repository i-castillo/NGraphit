import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
import java.lang.Character;


public class NGraphitUtils{

  private static final String[] operations = {"log", "cos", "sin", "tan" };
  public NGraphitFunction parseString(String inputString){

    inputString = inputString.replaceAll("\\s+","").toLowerCase();


    if(!checkParentheses(inputString)){
      System.out.println("parens error");
      return null;
    }

    if(inputString.matches("^.*[^a-zA-Z0-9 ].*$")){
      System.out.println("non alpha");
      return null;
    }

 /*   if(getLetters(inputString) == null){
      System.out.println("two many letters error");
      return null;
    } */

    if(!inputString.contains("=")){
      System.out.println("missing =");
      return null;
    }

    String[] functions = inputString.split("[=+-/*]");
    System.out.println(inputString);
    System.out.println(Arrays.toString(functions));

    return null;
    //return null;

  }


/**
  private int getCoeff(String string){
    int i;
    int coeff;
    if(Character.isNumeric(string.charAt(i))){
      return 0;
    }
    else{
      coeff = Integer.parseInt(string.charAt(i));
      int j = i+1;
      while(Character.isNumeric(string.charAt(j))){
        coeff = 10 * Integer.parseInt(string.charAt(j)) + coeff;

      }
      i = j;

    }
    return coeff;
  } */


  


  private boolean checkParentheses(String inputString){

    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < inputString.length(); i++){
      if(inputString.charAt(i) == '('){
        stack.push('(');
      }
      else if(inputString.charAt(i) == ')'){
        if(stack.isEmpty()){
          return false;
        }
        else{
          stack.pop();
        }

      }
    }

    if(stack.isEmpty()){
      return true;
    }
    else{
      return false;
    }

  }

 /* private ArrayList<Character> getLetters(String input){

  //  String temp = new String(input);
    for(String str: operations){
      temp.replace(str, 1);
    }
    ArrayList<Character> chars = new ArrayList<>();
    for(int i = 0; i < input.length(); i++){
      if(Character.isLetter(input.charAt(i))){
        if(!chars.contains(input.charAt(i))){


          chars.add(input.charAt(i));
        }
        if(chars.size() > 2){
          return null;

        }
      }

    }

    return chars;


  } */


}
