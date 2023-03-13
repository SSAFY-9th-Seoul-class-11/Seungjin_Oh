import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][3];
        int[][] dp_Max = new int[n+1][3];
        int[][] dp_Min = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            dp_Max[i][0] = map[i][0]+Math.max(dp_Max[i-1][0], dp_Max[i-1][1]);
            dp_Max[i][1] = map[i][1]+Math.max(Math.max(dp_Max[i-1][0], dp_Max[i-1][1]),dp_Max[i-1][2]);
            dp_Max[i][2] = map[i][2]+Math.max(dp_Max[i-1][1], dp_Max[i-1][2]);

            dp_Min[i][0] = map[i][0]+Math.min(dp_Min[i-1][0], dp_Min[i-1][1]);
            dp_Min[i][1] = map[i][1]+Math.min(Math.min(dp_Min[i-1][0], dp_Min[i-1][1]),dp_Min[i-1][2]);
            dp_Min[i][2] = map[i][2]+Math.min(dp_Min[i-1][1], dp_Min[i-1][2]);
        }

        System.out.println(Math.max(Math.max(dp_Max[n][0], dp_Max[n][1]),dp_Max[n][2])+" "
                +Math.min(Math.min(dp_Min[n][0], dp_Min[n][1]),dp_Min[n][2]));
    }
}