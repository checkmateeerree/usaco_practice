import java.io.*;
import java.util.*;

public class HoofPaperScissors1 {
    public static void main(String args[]) throws IOException{
      
      Scanner input = new Scanner(new File("hps.in"));
      //Scanner input = new Scanner(System.in);
      
      int N = input.nextInt();
      char[] charArr = new char[N];
      
      for (int i = 0; i < N; i++){
          charArr[i] = input.next().charAt(0);
      }
      
      int[][] notSwitched = new int[3][N];
      int[][] switched = new int[3][N];
      int[][] switchAt = new int[3][N];
      
      //switchAt
      for (int i = 0; i < N - 1; i++){
          char curr = charArr[i];
          
          switchAt[0][i+1] = switchAt[0][i];
          switchAt[1][i+1] = switchAt[1][i];
          switchAt[2][i+1] = switchAt[2][i];
          
          
          if (curr == 'P'){
            switchAt[0][i + 1] += 1;
          //0
          } else if (curr == 'H'){
            switchAt[1][i + 1] += 1;
              //1
          } else if (curr == 'S'){
              //2
            switchAt[2][i + 1] += 1;
          }
          
      }
      
      //nonSwitched
      for (int i = 0; i < N; i++){
          char curr = charArr[i];
          
          if (i > 0){
              notSwitched[0][i] = notSwitched[0][i-1];
              notSwitched[1][i] = notSwitched[1][i-1];
              notSwitched[2][i] = notSwitched[2][i-1];
              
              if (curr == 'P'){
                notSwitched[0][i] += 1;
              //0
              } else if (curr == 'H'){
                notSwitched[1][i] += 1;
                  //1
              } else if (curr == 'S'){
                  //2
                notSwitched[2][i] += 1;
              }
          } else {
              if (curr == 'P'){
                notSwitched[0][i] = 1;
                  //0
              } else if (curr == 'H'){
                  notSwitched[1][i] = 1;
                  //1
              } else if (curr == 'S'){
                  notSwitched[2][i] = 1;
                  //2
              }
          }
      }
          
        //switched
        for (int i = N - 1; i >= 0; i--){
              char curr = charArr[i];
              
              if (i < N - 1){
                  switched[0][i] = switched[0][i+1];
                  switched[1][i] = switched[1][i+1];
                  switched[2][i] = switched[2][i+1];
                  
                  if (curr == 'P'){
                    switched[0][i] += 1;
                  //0
                  } else if (curr == 'H'){
                    switched[1][i] += 1;
                      //1
                  } else if (curr == 'S'){
                      //2
                    switched[2][i] += 1;
                  }
              } else {
                  if (curr == 'P'){
                    switched[0][i] = 1;
                      //0
                  } else if (curr == 'H'){
                      switched[1][i] = 1;
                      //1
                  } else if (curr == 'S'){
                      switched[2][i] = 1;
                      //2
                  }
              }
          
        }
        
      int maxWins = 0;
      
      //loop through never siwtch array
      for (int i = 0; i < 3; i++){
          maxWins = Math.max(maxWins, notSwitched[i][N-1]);
      }
      
      for (int i = 0; i < N; i++){
          for (int a = 0; a < 3; a++){
              for (int b = 0; b < 3; b++){
                  if (b != a){
                      maxWins = Math.max(maxWins, switchAt[a][i] + switched[b][i]);
                      //System.out.println(switchAt[a][i] + switched[b][i]);
                  }
              }
          }
      }
      
      PrintWriter output = new PrintWriter(new File("hps.out"));
      
      //System.out.println(maxWins);
      
      output.println(maxWins);
 
      output.close();
      
    }
}