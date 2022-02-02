import java.io.*;
import java.util.*;

public class NonTransitiveDice {
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String args[]) {
        
      // 10 * 10 * 10 * 10
      
      int t = input.nextInt();
      
      for (int i = 0; i < t; i++){
          solve();
      }
      
    }
    
    public static void solve(){
      
      int[] A = new int[4];
      int[] B = new int[4];
      for (int i = 0; i < 4; i++){
          A[i] = input.nextInt();
      }
      for (int i = 0; i < 4; i++){
          B[i] = input.nextInt();
      }
      
      //now see if A beats B
      // if A beats B, make B beat C and C beat A
      // if B beats A, make A beat C and C beat B
      // if A ties B, give up, say no
      
      int aTotal = 0;
      int bTotal = 0;
      int cTotal = 0;
      int cTotal2 = 0;
      
      for (int i = 0; i < 4; i++){
          for (int j = 0; j < 4; j++){
              if (A[i] > B[j]){
                  aTotal++;
              } else if (B[j] > A[i]){
                  bTotal++;
              }
          }
      }
      
      
      
      if (aTotal > bTotal){
          //make B beat C, C beat A;
          for (int num1 = 1; num1 <= 10; num1++){
              for (int num2 = 1; num2 <= 10; num2++){
                  for (int num3 = 1; num3 <= 10; num3++){
                      for (int num4 = 1; num4 <= 10; num4++){
                          
                          int[] C = {num1, num2, num3, num4};
                          bTotal = 0;
                          cTotal = 0;
                          
                          for (int i = 0; i < 4; i++){
                              for (int j = 0; j < 4; j++){
                                  if (B[i] > C[j]){
                                      bTotal++;
                                  } else if (C[j] > B[i]){
                                      cTotal++;
                                  }
                              }
                          }
                          
                          
                          aTotal = 0;
                          cTotal2 = 0;
                          
                          for (int i = 0; i < 4; i++){
                              for (int j = 0; j < 4; j++){
                                  if (A[i] > C[j]){
                                      aTotal++;
                                  } else if (C[j] > A[i]){
                                      cTotal2++;
                                  }
                              }
                          }
                          
                          if (bTotal > cTotal && cTotal2 > aTotal){
                              System.out.println("yes");
                             // System.out.println(Arrays.toString(C));
                              return;
                          }
                      }
                  }
              }
          }
      } else if (bTotal > aTotal){
          //make A beat C, C beat B;
          for (int num1 = 1; num1 <= 10; num1++){
              for (int num2 = 1; num2 <= 10; num2++){
                  for (int num3 = 1; num3 <= 10; num3++){
                      for (int num4 = 1; num4 <= 10; num4++){
                          int[] C = {num1, num2, num3, num4};
                          bTotal = 0;
                          cTotal = 0;
                          aTotal = 0;
                          cTotal2 = 0;
                          
                          for (int i = 0; i < 4; i++){
                              for (int j = 0; j < 4; j++){
                                  //System.out.println(B[i] + " " + C[j]);
                                  if (B[i] > C[j]){
                                      bTotal++;
                                  } else if (C[j] > B[i]){
                                      cTotal++;
                                  }
                              }
                          }
                          
                          
                          
                          
                          for (int i = 0; i < 4; i++){
                              for (int j = 0; j < 4; j++){
                                  if (A[i] > C[j]){
                                      aTotal++;
                                  } else if (C[j] > A[i]){
                                      cTotal2++;
                                  }
                              }
                          }
                          
                          if (aTotal > cTotal2 && cTotal > bTotal){
                              
                              System.out.println("yes");
                              
                              return;
                          }
                      }
                  }
              }
          }
      } else {
          System.out.println("no");
          return;
      }
      
      System.out.println("no");
      
      
    }
}