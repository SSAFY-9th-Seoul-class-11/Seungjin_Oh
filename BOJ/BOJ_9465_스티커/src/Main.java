import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] xdir = {-1,1,0,0};
	    int[] ydir = {0,0,-1,1};
	    int[] xdir2 = {-2,2,0,0};
	    int[] ydir2 = {0,0,-2,2};
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int[][] sticker=new int[2][N];
			int[][] dp=new int[2][N];
			for (int i = 0; i < 2; i++) {
				String[] input=br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					sticker[i][j]=Integer.parseInt(input[j]);
				}
			}
			
			dp[0][0]=sticker[0][0];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					if(i==0&&j==0)continue;
					List<Integer> nearBy = new ArrayList<>();
					for (int k = 0; k < 4; k++) {
						int dx = i+xdir[k];
		                int dy = j+ydir[k];

		                if (isValidPosition(dx,dy)){
		                    nearBy.add(dp[dx][dy]);
		                }
					}
					for (int k = 0; k < 4; k++) {
						int dx = i+xdir2[k];
		                int dy = j+ydir2[k];

		                if (isValidPosition(dx,dy)){
		                    nearBy.add(dp[dx][dy]+sticker[i][j]);
		                }
					}
					dp[i][j] = Collections.max(nearBy);
				}
			}
			
//			System.out.println(dp[1][N-1]);
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

	private static boolean isValidPosition(int x, int y) {
		if(x<0||x>=2||y<0||y>=N) return false;
        return true;
	}

}
