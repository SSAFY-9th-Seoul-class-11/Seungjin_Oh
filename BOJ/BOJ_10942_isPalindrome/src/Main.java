import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static boolean[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        String[] str = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(str[i-1]);
        }
        for(int i=1; i<=N; i++){
            dp[i][i] = true;
        }
        for (int i = N; i > 0 ; i--) {
            for (int j = i+1; j <= N ; j++) {
                if (arr[i]== arr[j] && (j - i == 1 || dp[i + 1][j - 1])) dp[i][j] = true;
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int S = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            sb.append(dp[S][E] ? 1 : 0);
            sb.append("\n");
//            System.out.println(dp[S][E] ? 1 : 0);
        }
        System.out.println(sb);

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(dp[i][j] ? 1 : 0);
//            }
//            System.out.println();
//        }
    }
}