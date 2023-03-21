import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Pos{
    int x;
    int y;
    int breakCount;
    int answer;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
        this.breakCount = 1;
        this.answer = 1;
    }
    Pos(int x, int y, int breakCount,int answer){
        this.x = x;
        this.y = y;
        this.breakCount = breakCount;
        this.answer = answer;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visitedWithBreak;
    static boolean[][] visitedWithoutBreak;
    static int[] xdir={0,1,0,-1};
    static int[] ydir={1,0,-1,0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visitedWithBreak = new boolean[N][M];
        visitedWithoutBreak = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j)-'0';
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(0, 0));
        visitedWithoutBreak[0][0]=true;

        while (!queue.isEmpty()) {
            Pos temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            int breakCount = temp.breakCount;
            int answer = temp.answer;

            if(x==N-1 && y==M-1) {
                if(answer<min) min=answer;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x+xdir[i];
                int dy = y+ydir[i];
                if(isValid(dx,dy)) {
                    if (breakCount > 0) {
                        if (!visitedWithoutBreak[dx][dy] && map[dx][dy] == 0) {
                            visitedWithoutBreak[dx][dy] = true;
                            queue.offer(new Pos(dx, dy, breakCount, answer + 1));
                        } else if (map[dx][dy] != 0 && !visitedWithBreak[dx][dy]) {
                            visitedWithBreak[dx][dy] = true;
                            queue.offer(new Pos(dx, dy, breakCount-1, answer + 1));
                        }
                    } else {
                        if (!visitedWithBreak[dx][dy] && map[dx][dy] == 0) {
                            visitedWithBreak[dx][dy] = true;
                            queue.offer(new Pos(dx, dy, breakCount, answer + 1));
                        }
                    }
                }
            }
        }
        int ans = min>=Integer.MAX_VALUE?-1:min;
        System.out.println(ans);
    }

    private static boolean isValid(int dx, int dy) {
        if(dx < 0 || dy < 0 || dx>=N || dy>=M) return false;
        return true;
    }
}
