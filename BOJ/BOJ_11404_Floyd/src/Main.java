import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                if(i==j) continue;
                if(map[i][j]==0) map[i][j]=INF;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            map[a][b] = Math.min(map[a][b], c);
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= N ; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                System.out.print(map[i][j]==INF?0+" ":map[i][j]+" ");
            }
            System.out.println();
        }
    }
}