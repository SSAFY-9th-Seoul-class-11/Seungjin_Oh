import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N+1][2];
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            String[] input = reader.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= N; i++) {
            if(dp[i]>dp[i+1]) dp[i+1]=dp[i];
            if(i+arr[i][0]>N+1) continue;
            dp[i+arr[i][0]] = Math.max(arr[i][1]+dp[i],dp[i+arr[i][0]]);
        }

        System.out.println(dp[N+1]);



    }
}