import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_16926_배열돌리기2_오승진 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        int N=n;
        int M=m;

        int[][] map = new int[N][M];
        int[][] answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }

        int tmpX=0;
        int tmpY=0;

        while(N>0 && M>0){
            int newr = R%(2*(N+M)-4);
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i=0; i < M; tmpY++,i++) {
//                System.out.println(tmpX+","+tmpY);
                queue.offer(map[tmpX][tmpY]);
            }
            tmpY--;
            tmpX++;
            for (int i=0; i < N-1; tmpX++,i++) {
//                System.out.println(tmpX+","+tmpY);
                queue.offer(map[tmpX][tmpY]);
            }
            tmpX--;
            tmpY--;
            for (int i=0; i<M-1; tmpY--,i++) {
//                System.out.println(tmpX+","+tmpY);
                queue.offer(map[tmpX][tmpY]);
            }
            tmpY++;
            tmpX--;
            for (int i=0; i<N-2; tmpX--,i++) {
//                System.out.println(tmpX+","+tmpY);
                queue.offer(map[tmpX][tmpY]);
            }

            for (int i = 0; i < newr; i++) {
                queue.offer(queue.poll());
            }

            for (int i=0; i < M; tmpY++,i++) {
//                System.out.println(tmpX+","+tmpY);
                answer[tmpX][tmpY] = queue.poll();
            }
            tmpY--;
            tmpX++;
            for (int i=0; i < N-1; tmpX++,i++) {
//                System.out.println(tmpX+","+tmpY);
                answer[tmpX][tmpY] = queue.poll();
            }
            tmpX--;
            tmpY--;
            for (int i=0; i<M-1; tmpY--,i++) {
//                System.out.println(tmpX+","+tmpY);
                answer[tmpX][tmpY] = queue.poll();
            }
            tmpY++;
            tmpX--;
            for (int i=0; i<N-2; tmpX--,i++) {
//                System.out.println(tmpX+","+tmpY);
                answer[tmpX][tmpY] = queue.poll();
            }

            M-=2;
            N-=2;
            tmpX+=1;
            tmpY+=1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
