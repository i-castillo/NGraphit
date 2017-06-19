import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
import java.lang.Character;


public class NGraphitUtils{

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

    if(getLetters(inputString) == null){
      System.out.println("two many letters error");
      return null;
    }

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

  private ArrayList<Character> getLetters(String input){



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


  }


}
