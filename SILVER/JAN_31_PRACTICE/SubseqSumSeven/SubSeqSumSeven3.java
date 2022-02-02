import java.io.*;
import java.util.*;

public class SubSeqSumSeven3 {
    public static void main(String args[]) throws IOException {
      //Scanner input = new Scanner(System.in);
      Scanner input = new Scanner(new File("div7.in"));
      
      int N = input.nextInt();
      
      long[] arr = new long[N];
      HashMap <Long, Integer> map = new HashMap<>();
      
      for (int i = 0; i < N; i++){
          arr[i] = input.nextInt() % 7;
      }
      
      //find longest subsequence that sums to a multiple of seven.
      
      int longestSeq = 0;
      
      //solution
      
      //[3, 5, 1, 6, 2, 14, 10]
      
      long[] prefixSums = new long[N];
      
      for (int i = 0; i < N; i++){
          if (i == 0){
              prefixSums[i] = (arr[i] % 7);
          } else {
              
              prefixSums[i] = ((prefixSums[i - 1] + arr[i]) % 7);
          }
          if (map.get(prefixSums[i]) == null){
              map.put(prefixSums[i], i);
          }
      }
      
      for (int i = 0; i < N; i++){
          if (map.get(prefixSums[i]) != null){
              longestSeq = Math.max(longestSeq, i - map.get(prefixSums[i]));
              if (i - map.get(prefixSums[i]) == 0){
                  longestSeq = Math.max(longestSeq, 1);
              }
          }
      }
      
      PrintWriter output = new PrintWriter(new File("div7.out"));
      
      output.println(longestSeq);

      //System.out.println(longestSeq);
      
      output.close();
      
}
}