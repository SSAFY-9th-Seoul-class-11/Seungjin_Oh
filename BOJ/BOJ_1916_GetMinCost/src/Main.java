import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int index;
    int cost;
    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
}

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            graph.get(a).add(new Node(b, c));
        }
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2)->o1.cost-o2.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.index] < cur.cost) continue;
            for(Node next : graph.get(cur.index)){
                if(dist[next.index] > dist[cur.index] + next.cost){
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        System.out.println(dist[end]);
    }


}