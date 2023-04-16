import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<ArrayList<Integer>> out;
    static int[] in;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        out = new ArrayList<>();
        in = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            out.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int pd = Integer.parseInt(input[0]);
            int[] temp = new int[pd];
            for (int j = 0; j < pd; j++) {
                temp[j] = Integer.parseInt(input[j + 1]);
            }
            for (int j = 0; j < pd - 1; j++) {
                out.get(temp[j]).add(temp[j + 1]);
                in[temp[j + 1]]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append("\n");
            for (int next : out.get(cur)) {
                in[next]--;
                if (in[next] == 0) queue.add(next);
            }
        }
        if (sb.length()<2*N) System.out.println(0);
        else System.out.println(sb);
    }
}