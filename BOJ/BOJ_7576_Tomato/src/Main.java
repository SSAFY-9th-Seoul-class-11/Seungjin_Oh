import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
    int x;
    int y;

    Pos(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
	static int M;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		int[] xdir = {-1,1,0,0};
	    int[] ydir = {0,0,-1,1};
	    int answer=0;
		
		Queue<Pos> q = new LinkedList<>();
		int[][] box = new int [N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(input[j]);
				if(box[i][j]==1) {
					q.offer(new Pos(i,j));
					visited[i][j]=true;
				}
			}
		}
		
		q.offer(new Pos(-1,-1));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int a=p.x;
			int b=p.y;
			
			if(a==-1 && b==-1) {
				if(q.isEmpty()) break;
				q.offer(new Pos(-1,-1));
				answer++;
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = a+xdir[i];
                int dy = b+ydir[i];

                if (isValidPosition(dx,dy)){
                    if (!visited[dx][dy] && box[dx][dy]==0){
                        visited[dx][dy]=true;
                        box[dx][dy]=1;
                        q.offer(new Pos(dx,dy));
                    }
                }
			}
		}
		
		boolean isValid=true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
					isValid=false;
					break;
				}
			}
		}
		
		if(isValid) System.out.println(answer);
		else System.out.println(-1);
		
	}

	private static boolean isValidPosition(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) return false;
        return true;
	}

}
