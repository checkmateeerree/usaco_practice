import java.io.*;
import java.util.*;

public class BreedCounting {
    public static void main(String args[]) throws IOException {
      //Scanner input = new Scanner(System.in);
      Scanner input = new Scanner(new File("bcount.in"));
      
      int N = input.nextInt();
      int Q = input.nextInt();
      
      int[] arr = new int[N + 1];
      arr[0] = 0;
      
      //[2, 1, 1, 3, 2, 1]
      
      /* [
             0 : [0, 0, 0]
             1 : [0, 1, 0], 
             2 : [1, 1, 0], 
             3 : [2, 1, 0],
             4 : [2, 1, 1],
             5 : [2, 2, 1],
             6 : [3, 2, 1],
         ]
      */
      for (int i = 1; i < N + 1; i++){
          arr[i] = input.nextInt();
      }
      
      int[][] prefixCows = new int[N + 1][3];
      
      prefixCows[0] = new int[] {0, 0, 0};
      
      for (int i = 1; i < N + 1; i++){
          int[] prefArr = new int[3];
          int breed = arr[i] - 1;
          
          for (int j = 0; j < 3; j++){
              //System.out.println(prefixCows[i-1][j]);
              if (breed == j){
                  prefArr[j] = prefixCows[i-1][j] + 1;
                  
              } else {
                 // System.out.println(j);
                prefArr[j] = prefixCows[i-1][j];
              }
          }
          prefixCows[i] = prefArr;
      }
      
      PrintWriter output = new PrintWriter(new File("bcount.out"));
      
      for (int i = 0; i < Q; i++){
          int idx1 = input.nextInt();
          int idx2 = input.nextInt();
          
          int[] pref1 = prefixCows[idx1 - 1];
          int[] pref2 = prefixCows[idx2];
          
          for (int j = 0; j < 3; j++){
              
              output.print((pref2[j] - pref1[j]));
              if (j != 2){
               output.print(" ");   
              }
          }
          output.println();
      }
      
      output.close();
      
      //System.out.println(Arrays.toString(prefixCows));
      

    }
}