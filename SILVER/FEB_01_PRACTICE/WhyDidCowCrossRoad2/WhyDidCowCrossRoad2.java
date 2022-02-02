import java.io.*;
import java.util.*;

public class WhyDidCowCrossRoad2 {
    public static void main(String[] args) throws IOException{
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("maxcross.in"));
        int N = input.nextInt();
        int K = input.nextInt();
        int B = input.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < B; i++){
            int id = input.nextInt();
            arr[id - 1] = 1;
        }

        int[] prefixArr = new int[N];

        for (int i = 0; i < N; i++){
            prefixArr[i] = arr[i];
            if (i > 0){
                prefixArr[i] += prefixArr[i-1];
            }
        }

        int minSignals = Integer.MAX_VALUE;

        for (int i = 0; i <= N - K; i++){
            if (i == 0){
                minSignals = Math.min(minSignals, prefixArr[i + K - 1]);
            } else {
                minSignals = Math.min(minSignals, prefixArr[i + K - 1] - prefixArr[i - 1]);
            }
        }

        PrintWriter output = new PrintWriter(new File("maxcross.out"));
        output.println(minSignals);
        output.close();
    }
}
