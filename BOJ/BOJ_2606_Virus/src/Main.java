import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> computer;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        answer = 0;

        visited = new boolean[N+1];
        computer = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N+1; i++) {
            computer.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            boolean isFind=false;

            for (int j = 0; j < computer.get(node1).size(); j++) {
                if (computer.get(node1).get(j)==node2){
                    isFind=true;
                    break;
                }
            }
            if (!isFind) computer.get(node1).add(node2);
            isFind=false;
            for (int j = 0; j < computer.get(node2).size(); j++) {
                if (computer.get(node2).get(j)==node1) {
                    isFind=true;
                    break;
                }
            }
            if (!isFind) computer.get(node2).add(node1);
        }
        dfs(1);
        System.out.println(answer-1);
    }

    private static void dfs(int x) {
        visited[x] = true;
        answer++;
        for (int i = 0; i < computer.get(x).size(); i++) {
            int y = computer.get(x).get(i);
            if(!visited[y]) dfs(y);
        }
    }
}
