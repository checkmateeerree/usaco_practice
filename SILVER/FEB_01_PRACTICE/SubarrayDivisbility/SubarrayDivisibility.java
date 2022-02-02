import java.io.*;
import java.util.*;

public class SubarrayDivisibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long[] arr = new long[(int) n];

        for (int i = 0; i < n; i++){
            arr[i] = input.nextLong();
        }

        long[] prefixArr = new long[(int) n];

        for (int i = 0; i < n; i++){
            prefixArr[i] = arr[i];
            if (i > 0){
                prefixArr[i] += prefixArr[i-1];
            }

            prefixArr[i] %= n;
        }

        HashMap<Long, Long> map = new HashMap<>();
        long total = 0;

        for (int i = 0; i < prefixArr.length; i++){
            if (prefixArr[i] == 0){
                total++;
            }
            long numToFind = (n - prefixArr[i]) % n;
          
            total += map.getOrDefault(numToFind, (long) 0);
            map.put(numToFind, map.getOrDefault(numToFind, (long) 0) + 1);
        }

        System.out.println(total);
        input.close();
    }
}
