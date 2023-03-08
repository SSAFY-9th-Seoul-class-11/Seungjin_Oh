import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable{
    int no;
    int weight;
    public Vertex(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
    @Override
    public int compareTo(Object o) {
        Vertex vertex = (Vertex) o;
        return this.weight - vertex.weight;
    }
}

public class Main {
    static int V;
    static int E;
    static List<ArrayList<Vertex>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph.get(u).add(new Vertex(v, w));
            graph.get(v).add(new Vertex(u, w));
        }

        int result = 0;
        int[] minEdge = new int[V+1];
        for (int i = 0; i <= V; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(1, 0));

        boolean[] isVisited = new boolean[V+1];
        isVisited[0] = true;
        int c=0;

        while(!pq.isEmpty()){
            Vertex vertex = pq.poll();
            if(isVisited[vertex.no]){
                continue;
            }

            result+=vertex.weight;
            isVisited[vertex.no] = true;
            if(++c==V+1) break;
            List<Vertex> minVertexList = graph.get(vertex.no);
            for (int i = 0; i < minVertexList.size(); i++) {
                Vertex temp = minVertexList.get(i);
                if(!isVisited[temp.no] && temp.weight!=0 && minEdge[temp.no] > temp.weight){
                    minEdge[temp.no] = temp.weight;
                    pq.offer(new Vertex(temp.no, minEdge[temp.no]));
                }
            }
        }

        System.out.println(result);
    }
}