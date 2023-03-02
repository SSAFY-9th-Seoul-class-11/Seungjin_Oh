import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Vertex implements Comparable<Vertex> {
	int no, weight;
	
	public Vertex(int no, int weight) {
		super();
		this.no = no;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}

class Pos{
	int x;
	int y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] xdir = {-1,1,0,0};
	static int[] ydir = {0,0,-1,1};
	static int numIsland;
	static List<ArrayList<Vertex>> graph;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		numIsland = 1;
		graph = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					bfs(i,j,numIsland);
					numIsland++;
				}
			}
		}
		
//		printmap();
	
		for (int i = 0; i < numIsland; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N; i++) {
			horizonSearch(i);
		}
		
		for (int i = 0; i < M; i++) {
			verticalSearch(i);
		}
		
		
//		for (int i = 0; i < graph.size(); i++) {
//			for (Vertex v : graph.get(i)) {
//				System.out.println(i+" : "+v.no+" "+v.weight);
//			}
//		}
		
		
		
		int result=0;
		int[] minEdge = new int[numIsland];
		for (int i = 0; i < numIsland; i++) {
			minEdge[i]=Integer.MAX_VALUE;
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1,0));
		
		boolean[] isVisited = new boolean[numIsland];
		isVisited[0]=true;
		int c=0;
		
		while(!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if(isVisited[minVertex.no]) continue;
			
			result+=minVertex.weight;
			isVisited[minVertex.no] = true;
			if(++c == numIsland) break;
			List<Vertex> minVertexList = graph.get(minVertex.no);
			for (int i = 0; i < minVertexList.size(); i++) {
				Vertex temp = minVertexList.get(i);
				if(!isVisited[temp.no] && temp.weight!=0 && minEdge[temp.no]>temp.weight) {
					minEdge[temp.no] = temp.weight;
					pq.offer(new Vertex(temp.no, minEdge[temp.no]));
				}
			}
		}
		
		for (int i = 0; i < numIsland; i++) {
			if(!isVisited[i]) result=-1;
		}
		System.out.println(result==0?-1:result);
	}



	private static void verticalSearch(int j) {
		int from=-1;
		int to=-1;
		int bridgeLength=0;
		
		for (int i = 0; i < N; i++) {
			if(map[i][j]==0) bridgeLength++;
			else {
				if(from==-1) {
					from = map[i][j];
					bridgeLength=0;
				}
				else {
					if(map[i][j]==from) {
						bridgeLength=0;
						continue;
					}
					to = map[i][j];
					if(bridgeLength>1) {
						graph.get(from).add(new Vertex(to,bridgeLength));
						graph.get(to).add(new Vertex(from,bridgeLength));
					}
					from = to;
					to = -1;
					bridgeLength = 0;
				}
			}
		}
	}



	private static void horizonSearch(int i) {
		int from=-1;
		int to=-1;
		int bridgeLength=0;
		
		for (int j = 0; j < M; j++) {
			if(map[i][j]==0) bridgeLength++;
			else {
				if(from==-1) {
					from = map[i][j];
					bridgeLength=0;
				}
				else {
					if(map[i][j]==from) {
						bridgeLength=0;
						continue;
					}
					to = map[i][j];
					if(bridgeLength>1) {
						graph.get(from).add(new Vertex(to,bridgeLength));
						graph.get(to).add(new Vertex(from,bridgeLength));
					}
					from = to;
					to = -1;
					bridgeLength = 0;
				}
			}
		}
	}



	private static void printmap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}		
	}



	private static void bfs(int i, int j, int numIsland) {
		Queue<Pos> queue = new ArrayDeque<>();
		Pos a = new Pos(i,j);
		queue.offer(a);
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			visited[x][y] = true;
			map[x][y] = numIsland;
			for (int k = 0; k < 4; k++) {
				int dx = x+xdir[k];
				int dy = y+ydir[k];
				if(isValid(dx,dy) && !visited[dx][dy]) {
					queue.offer(new Pos(dx,dy));
				}
			}
		}
	}



	private static boolean isValid(int dx, int dy) {
		if(dx<0 || dx>=N || dy<0 || dy>=M || map[dx][dy]==0) return false;
		return true;
	}

}


