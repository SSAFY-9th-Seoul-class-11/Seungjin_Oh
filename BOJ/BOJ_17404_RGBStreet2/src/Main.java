import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] houses;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N+1][3];
        dp = new int[N+1][3][3];

        for (int i = 1; i <=N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) dp[2][j][i]=Integer.MAX_VALUE;
                else{
                    dp[2][j][i] = houses[1][i]+houses[2][j];
                }
            }
            for (int j = 3; j <= N; j++) {
                dp[j][0][i] = houses[j][0]+Math.min(dp[j-1][1][i],dp[j-1][2][i]);
                dp[j][1][i] = houses[j][1]+Math.min(dp[j-1][0][i],dp[j-1][2][i]);
                dp[j][2][i] = houses[j][2]+Math.min(dp[j-1][0][i],dp[j-1][1][i]);
            }
        }

        int answer=Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) continue;
                if (dp[N][i][j]<answer) answer=dp[N][i][j];
            }
        }
        System.out.println(answer);
//        System.out.println(dp[N][0][0]+" "+dp[N][0][1]+" "+dp[N][0][2]+" "+dp[N][1][0]+" "+dp[N][1][1]+" "+dp[N][1][2]+" "+dp[N][2][0]+" "+dp[N][2][1]+" "+dp[N][2][2]);
//        System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));

    }
}
