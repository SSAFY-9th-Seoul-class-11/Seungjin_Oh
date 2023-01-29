import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
    int x;
    int y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] estate;
    static int estateNum =0;

    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        estate = new int[N*N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    estateNum++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(estate);
        System.out.println(estateNum);

        for(int i = 0; i< estate.length; i++){
            if(estate[i]!=0) System.out.println(estate[i]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x,y));
        visited[x][y]=true;
        estate[estateNum]++;

        while (!q.isEmpty()){
            Pos p = q.poll();
            int a= p.x;
            int b= p.y;

            for (int i = 0; i < 4; i++) {
                int dx = a+xdir[i];
                int dy = b+ydir[i];

                if (isValidPosition(dx,dy)){
                    if (!visited[dx][dy] && map[dx][dy]==1){
                        visited[dx][dy]=true;
                        q.offer(new Pos(dx,dy));
                        estate[estateNum]++;
                    }
                }
            }

        }
    }

    private static boolean isValidPosition(int x, int y) {
        if(x<0||x>=N||y<0||y>=N) return false;
        return true;
    }
}
