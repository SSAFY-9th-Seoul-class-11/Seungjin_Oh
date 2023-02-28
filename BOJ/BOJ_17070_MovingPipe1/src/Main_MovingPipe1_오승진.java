import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main_MovingPipe1_오승진 {
	static int N;
	static int[][] map;
	static int[][][] dp; //우,하,대각
	static int[] xdir = {0,1,1};
	static int[] ydir = {1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
		
		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		dp[0][1][0]=1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					int dx = i+xdir[k];
					int dy = j+ydir[k];
					
					if(isValid(dx,dy)) {
						if(k!=2 || ((k==2)&&(map[dx-1][dy]!=1 && map[dx][dy-1]!=1))) {
							dp[dx][dy][k]+=dp[i][j][2];
							if(k==2) {
								dp[dx][dy][k]+=dp[i][j][1];
								dp[dx][dy][k]+=dp[i][j][0];
							}
							else {
								dp[dx][dy][k]+=dp[i][j][k];
							}
						}
					}
				}
			}
		}
		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < N; j++) {
//				for (int k=0; k<N; k++) {
//					System.out.print(dp[j][k][i]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
//		System.out.println(Integer.max(dp[N-1][N-1][0], Integer.max(dp[N-1][N-1][1], dp[N-1][N-1][2])));
	}

	private static boolean isValid(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N ) return false;
		if(map[x][y]==1) return false;
		return true;
	}

}
