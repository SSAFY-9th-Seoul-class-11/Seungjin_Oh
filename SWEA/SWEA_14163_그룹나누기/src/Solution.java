import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <=T; tc++) {

            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            parent = new int[N+1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            input = br.readLine().split(" ");
            for (int i = 0; i < M*2; i+=2) {
                merge(Integer.parseInt(input[i]), Integer.parseInt(input[i+1]));
            }

            Set<Integer> team = new HashSet<Integer>();
            for (int i = 1; i <= N; i++) {
                team.add(find(i));
            }

            sb.append("#"+tc+" "+team.size()+"\n");

        }
        System.out.println(sb.toString());
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) return;
        parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}
