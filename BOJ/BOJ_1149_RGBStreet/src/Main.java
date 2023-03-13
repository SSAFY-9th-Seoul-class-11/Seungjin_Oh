import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] houses;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N+1][3];
        dp = new int[N+1][3];

        for (int i = 1; i <=N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = houses[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = houses[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = houses[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));

    }
}