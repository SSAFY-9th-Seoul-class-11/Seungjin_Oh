import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = in.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]%10);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j) {
        int[] pos = {i,j};
        visited[i][j] = true;

        int area=0;
        Queue<int[]> queue = new ArrayDeque<>();
        Set<int[]> list = new HashSet<>();
        queue.offer(pos);

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            area++;

            for (int k = 0; k < 4; k++) {
                int dx = x+xdir[k];
                int dy = y+ydir[k];

                if(isValid(dx, dy) && !visited[dx][dy]) {
                    temp = new int[] {dx,dy};
                    visited[dx][dy]=true;
                    if(map[dx][dy]==0){
                        queue.offer(temp);
                    }
                    else {
                        list.add(temp);
                    }
                }
            }
        }
        for (int[] arr : list) {
            int x = arr[0];
            int y = arr[1];
            map[x][y]+=area;
            visited[x][y]=false;
        }
    }

    private static boolean isValid(int x, int y) {
        if(x<0 || y<0 || x>=N || y>=M) return false;
        return true;
    }
}