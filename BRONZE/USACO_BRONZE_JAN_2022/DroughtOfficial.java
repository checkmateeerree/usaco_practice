import java.io.*;
import java.util.*;

public class DroughtOfficial {
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]) {
      //O(N) TIME
      
      int t = input.nextInt();
      for (int i = 0; i < t; i++){
          solve();
      }
    }
    
    public static void solve(){
        int N = input.nextInt();
        
        long[] arr = new long[N];
        
        for (int i = 0; i < N; i++){
            arr[i] = input.nextLong();
        }
        
        if (N == 1){
            System.out.println(0);
            return;
        } else if (N == 2){
            if (arr[0] == arr[1]){
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }
        
        long totalBags = 0;
        boolean solved = false;
        

        long[] prevArr = new long[N];
        prevArr[0] = -1;
        while (!solved){
            
            if (Arrays.equals(prevArr, arr)){
                System.out.println(-1);
                return;
            }
            
            prevArr = arr.clone();
            
            for (int i = 0; i < N - 1; i++){
                if (arr[i] < 0){
                    System.out.println(-1);
                    return;
                }
            }
            
            solved = true;
            for (int i = 0; i < N - 1; i++){
                if (arr[i] != arr[i + 1]){
                    solved = false;
                    break;
                }
            }
            
            
            if (solved){
                System.out.println(totalBags);
                return;
            }
            
            for (int i = 0; i < N - 1; i++){
                if (arr[i] != arr[i + 1]){
                    long diff = Math.abs(arr[i] - arr[i + 1]);
                    
                    if (arr[i] > arr[i + 1]){
                        if (i - 1 < 0){
                            continue;
                        }
                        diff = Math.min(arr[i - 1], diff);
                        
                        arr[i - 1] -= diff;
                        arr[i] -= diff;
                        totalBags += (diff * 2);
                        continue;
                    }
                    if (arr[i] < arr[i + 1]){
                         if (i + 2 >= N){
                            continue;
                        }
                        diff = Math.min(arr[i + 2], diff);
                        arr[i + 1] -= diff;
                       
                        arr[i + 2] -= diff;
                        totalBags += (diff * 2);
                        continue;
                    }
                }
            }
        
        }
        
        for (int i = 0; i < N - 1; i++){
            if (arr[i] != arr[i + 1]){
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(totalBags);
        return;
        
    }
}