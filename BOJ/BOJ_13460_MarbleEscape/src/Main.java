import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Pos {
    int x;
    int y;
    int count;

    public Pos(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[] xdir = {0, 0, 1, -1};
    static int[] ydir = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int rx=0;
        int ry=0;
        int bx=0;
        int by=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        answer = Math.min(answer,move(new Pos(rx,ry,0),new Pos(bx,by,0)));
        System.out.println(answer);
    }

    private static int move(Pos red, Pos blue) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(red);
        int x = red.x;
        int y = red.y;
        int bx = blue.x;
        int by = blue.y;
        int count = red.count;
        visited[x][y] = true;
        boolean flag = false;

        while (!q.isEmpty()) {
            printMap();
            Pos r = q.poll();
            for (int i = 0; i < 4; i++) {
                x = r.x;
                y = r.y;
                count = r.count;
                count++;
//                System.out.println("x: "+x+" y: "+y);
//                System.out.println("count: "+count);
                if (count>10) return -1;
                while (true) {
                    map[bx][by] = '.';
                    bx+= xdir[i];
                    by+= ydir[i];
                    if (bx<0||bx>=N||map[bx][by]=='#'||by<0||by>=M) {
                        bx-= xdir[i];
                        by-= ydir[i];
                        if(flag) return count;
                    }
                    map[bx][by]='B';


                    x += xdir[i];
                    y += ydir[i];

                    if (map[x][y] == 'O') {
                        flag = true;
                    }
                    if (map[bx][by] == 'O' && flag) {
                        return -1;
                    }
                    if (x < 0 || x >= N || y < 0 || y >= M || map[x][y]=='B' || map[x][y] == '#' || visited[x][y]) {
                        break;
                    }
                    visited[x][y] = true;
                    q.add(new Pos(x, y, count));
                }
            }
        }
        return count;
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}