import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        for (int i = 2; i <=N ; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int j : graph.get(i)) {
            if (!visited[j]) {
                parent[j] = i;
                dfs(j);
            }
        }
    }


}