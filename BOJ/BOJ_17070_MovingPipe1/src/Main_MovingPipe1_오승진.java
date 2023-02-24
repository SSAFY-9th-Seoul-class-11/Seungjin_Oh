import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Pos{
	int x;
	int y;
	int position;
	public Pos(int x, int y, int position) {
		super();
		this.x = x;
		this.y = y;
		this.position = position;
	}
}

public class Main_MovingPipe1_오승진 {
	static int N;
	static int[][] map;
//	static boolean[][] isVisited;
	static int[][][] dp; //우,하,대각
	static Queue<Pos> queue= new ArrayDeque<>();
	
	static int[] xdir= {0,1,1};
	static int[] ydir= {1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
//		isVisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		
		pipe(0,1,0);
		System.out.println(Integer.max(dp[N-1][N-1][0], Integer.max(dp[N-1][N-1][1], dp[N-1][N-1][2])));
	}

	private static void pipe(int x, int y,int position) {
//		isVisited[x][y] = true;
		queue.offer(new Pos(x,y,position));
		
		while(!queue.isEmpty()) {
//			System.out.println(queue.peek().x+","+queue.peek().y);
			Pos temp = queue.poll();
			int i = temp.x;
			int j = temp.y;
			int qPosition = temp.position;
			
			for (int k = 0; k < 3; k++) {
				int dx = i+xdir[k];
				int dy = j+ydir[k];
				
//				System.out.println("check is Valid "+dx+","+dy);
				if(isValid(dx,dy,k,qPosition) && map[dx][dy]!=1) {
//					isVisited[dx][dy]=true;
					dp[dx][dy][k]+=1;
					if(k==2) {
						dp[dx][dy][0]+=1;
						dp[dx][dy][1]+=1;
					}
					else {
						dp[dx][dy][2]+=1;
					}
//					System.out.println("offer"+" "+dx+","+dy);
					queue.offer(new Pos(dx,dy,k));
				}
			}
		}
	}

	private static boolean isValid(int dx, int dy, int k, int position) {
		if(dx<0 || dx>=N || dy<0 || dy>=N || //isVisited[dx][dy] ||
				((Math.abs(k-position)==1)&&(k+position==1)) || ((k==2)&&(map[dx-1][dy]==1 || map[dx][dy-1]==1))) return false;
		return true;
	}

}
