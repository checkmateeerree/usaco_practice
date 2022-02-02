import java.io.*;
import java.util.*;

public class Herdle {
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      String answerString = "";
      String guessString = "";
      
      for (int i = 0; i < 3; i++){
          String inp = input.next();
          answerString += inp;
      }
      for (int i = 0; i < 3; i++){
          String inp = input.next();
          guessString += inp;
      }
      
      HashMap<String, Integer> ansMap = new HashMap<String, Integer>();
      HashMap<String, Integer> guessMap = new HashMap<String, Integer>();
      
      for (int i = 0; i < 9; i++){
          String character = answerString.substring(i, i + 1);
          ansMap.put(character, ansMap.getOrDefault(character, 0) + 1);
      }
      for (int i = 0; i < 9; i++){
          String character = guessString.substring(i, i + 1);
          guessMap.put(character, guessMap.getOrDefault(character, 0) + 1);
      }
      
      int greenCount = 0;
      for (int i = 0; i < 9; i++){
          String ansSubString = answerString.substring(i, i + 1);
          String guessSubString = guessString.substring(i, i + 1);
          if (ansSubString.equals(guessSubString)){
              greenCount++;
              ansMap.put(ansSubString, ansMap.get(ansSubString) - 1);
              guessMap.put(guessSubString, guessMap.get(guessSubString) - 1);
          }
      }
      
      int yellowCount = 0;
      
      for (String i : ansMap.keySet()){
          if (ansMap.get(i) != null && guessMap.get(i) != null){
              yellowCount += Math.min(ansMap.get(i), guessMap.get(i));
          }
      }
      
      System.out.println(greenCount);
      System.out.println(yellowCount);
      
    }
}