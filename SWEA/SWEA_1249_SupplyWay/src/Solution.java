import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
    int x;
    int y;

    Pos(int x, int y){
        this.x=x;
        this.y=y;
    }
}


public class Solution {
    static boolean[][] visited;
    static int[][] ans;
    static int[][] map;
    static int N;
    static int min;
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};


    private static void bfs(int x,int y) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pos p = q.poll();
            int a = p.x;
            int b = p.y;

            if(a==N-1 && b==N-1){
                min=ans[N-1][N-1];
            }

            for (int i = 0; i < 4; i++) {
                int dx = a+xdir[i];
                int dy = b+ydir[i];

                if (isValidPosition(dx,dy)){
                    if (!visited[dx][dy] || ans[dx][dy] > ans[a][b] + map[dx][dy]){
                        visited[dx][dy]=true;
                        ans[dx][dy] = ans[a][b]+map[dx][dy];
                        q.offer(new Pos(dx,dy));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <=tc; T++) {


            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j)-'0';
                }
            }

            min=Integer.MAX_VALUE;
            visited=new boolean[N][N];
            ans=new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans[i][j]=min;
                }
            }
            ans[0][0]=0;

            bfs(0,0);

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(ans[i][j]+" ");
//                }
//                System.out.println();
//            }

            System.out.println("#"+T+" "+min);
        }
    }

    private static boolean isValidPosition(int x, int y) {
        if(x<0||x>=N||y<0||y>=N) return false;
        return true;
    }
}
