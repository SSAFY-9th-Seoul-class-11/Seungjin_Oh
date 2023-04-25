import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Building{
    int num;
    int time;
    int in;
    ArrayList<Integer> out;

    public Building(int num, int time){
        this.num = num;
        this.time = time;
        this.in = 0;
        this.out = new ArrayList<>();
    }
}

public class Main {
    static int N;
    static int K;
    static int W;
    static boolean flag;
    static Building[] buildings;
    static Queue<Building> queue;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            buildings = new Building[N+1];
            dp = new int[N+1];
            flag = false;

            input = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                buildings[i] = new Building(i, Integer.parseInt(input[i-1]));
            }

            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                buildings[a].out.add(b);
                buildings[b].in++;
            }

            W = Integer.parseInt(br.readLine());


            queue = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                if (buildings[i].in == 0){
                    if (i==W) {
                        System.out.println(buildings[i].time);
                        flag=true;
                        break;
                    }
                    queue.add(buildings[i]);
                }
            }
            if (flag) continue;

            while(!queue.isEmpty()) {
                Building curBuilding = queue.poll();
                int cur = curBuilding.num;
                if (dp[cur]==0) dp[cur] = curBuilding.time;
                for (int next : buildings[cur].out) {
                    buildings[next].in--;
                    dp[next] = Math.max(dp[next], dp[cur] + buildings[next].time);
                    if (buildings[next].in == 0) {
                        queue.add(buildings[next]);
                    }
                }
            }
            System.out.println(dp[W]);
        }
    }
}

