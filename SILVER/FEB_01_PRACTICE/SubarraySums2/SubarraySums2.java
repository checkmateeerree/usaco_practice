import java.io.*;
import java.util.*;

public class SubarraySums2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long targetSum = input.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++){
            arr[i] = input.nextLong();
        }
        
        long[] prefixSums = new long[n];

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            prefixSums[i] = arr[i];
            if (i != 0){
                prefixSums[i] += prefixSums[i-1];
            }
        }

        //regarr: [2, -1, 3, 5, -2]
        //prefix: [2, 1, 4, 9, 7]

        long total = 0;

        for (int i = 0; i < prefixSums.length; i++){
            // targ = prefixArr[i] - prefixArr[j - 1];
            if (targetSum - prefixSums[i] == 0){
                total++;
            } 
            total += map.getOrDefault(-1 * (targetSum - prefixSums[i]), 0);
            map.put(prefixSums[i], map.getOrDefault(prefixSums[i], 0) + 1);
        }

        System.out.println(total);

        input.close();

    }
}
