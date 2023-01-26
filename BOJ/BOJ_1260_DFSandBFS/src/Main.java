import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph;

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		visited[start] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for (int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y]=true;
				}
			}
		}
		
	}
	
	private static void dfs(int x) {
		visited[x] = true;
		System.out.print(x+" ");
		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		visited = new boolean[N+1];
		graph = new ArrayList<ArrayList<Integer>>();
		
		//그래프 초기화
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			boolean isFind = false;
			
			for (int j = 0; j < graph.get(node1).size(); j++) {
				if (graph.get(node1).get(j)==node2) {
					isFind=true;
					break;
				}
			}
			if(isFind==false)
				graph.get(node1).add(node2);
			isFind=false;
			for (int j = 0; j < graph.get(node2).size(); j++) {
				if (graph.get(node2).get(j)==node1) {
					isFind=true;
					break;
				}
			}
			if(isFind==false)
				graph.get(node2).add(node1);
		}
		
		for (int i = 1; i < N+1; i++) {
			graph.get(i).sort(Comparator.naturalOrder());
		}
		
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}


}
