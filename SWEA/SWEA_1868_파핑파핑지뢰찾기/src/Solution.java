import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Pos{
    int x;
    int y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int N;
    static char[][] board;
    static boolean[][] isVisited;
    static int[] xdir = {-1,-1,-1,1,1,1,0,0};
    static int[] ydir = {0,-1,1,0,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <=T; tc++) {

            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            isVisited = new boolean[N][N];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = input.charAt(j);
                    if(board[i][j] == '*') isVisited[i][j]=true;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j]!='*'){
                        cntMine(i,j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j]=='0' && !isVisited[i][j]){
                        bfs(i,j);
                        answer++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]){
                        answer++;
                    }
                }
            }

            System.out.println("#"+tc+" "+answer);

        }
    }

    private static void bfs(int i, int j) {
        isVisited[i][j] = true;
        Queue<Pos> queue = new ArrayDeque<>();

        queue.offer(new Pos(i,j));
        while (!queue.isEmpty()){
            Pos temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for (int k = 0; k < 8; k++) {
                int dx = x+xdir[k];
                int dy = y+ydir[k];
                if(isValidPosition(dx,dy) && !isVisited[dx][dy]) {
                    isVisited[dx][dy] = true;
                    if (board[dx][dy] =='0') queue.offer(new Pos(dx,dy));
                }
            }
        }

    }

    private static void cntMine(int x, int y) {
        int cnt=0;
        for (int k = 0; k < 8; k++) {
            int dx = x+xdir[k];
            int dy = y+ydir[k];
            if(isValidPosition(dx,dy) && board[dx][dy]=='*') cnt++;
        }
        board[x][y]= (char) (cnt+'0');
    }

    private static boolean isValidPosition(int x, int y) {
        if(x<0 || x>=N || y<0 || y>=N) return false;
        return true;
    }
}
