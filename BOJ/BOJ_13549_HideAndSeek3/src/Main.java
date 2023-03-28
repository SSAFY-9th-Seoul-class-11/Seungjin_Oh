import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class duo{
    int num;
    int cnt;
    duo(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new boolean[100001];

        Queue<duo> queue = new ArrayDeque<>();
        queue.offer(new duo(N,0));

        while(!queue.isEmpty()) {
            duo X = queue.poll();
            int num = X.num;
            int cnt = X.cnt;
            visited[num]=true;
            if(num==K) {
                System.out.println(cnt);
                break;
            }

            if(num<=50000 && !visited[num*2]) queue.offer(new duo(num*2,cnt));
            if(num-1>=0 && !visited[num-1]) queue.offer(new duo(num-1,cnt+1));
            if(num+1<=100000 && !visited[num+1]) queue.offer(new duo(num+1,cnt+1));
        }

    }
}