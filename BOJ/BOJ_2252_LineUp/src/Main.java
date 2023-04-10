import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N,M;
    static List<ArrayList<Integer>> out;
    static int[] in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        out = new ArrayList<>();
        in = new int[N+1];
        for (int i = 0; i <= N; i++) {
            out.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            out.get(a).add(b);
            in[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(in[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
            for (int i = 0; i < out.get(cur).size(); i++) {
                int next = out.get(cur).get(i);
                in[next]--;
                if(in[next]==0) queue.add(next);
            }
        }

    }
}