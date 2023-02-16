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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int[][] sticker=new int[2][N+1];
			int[] dp = new int[N+1];
			
			for (int i = 0; i < 2; i++) {
				String[] input=br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					sticker[i][j]=Integer.parseInt(input[j-1]);
				}
			}
			
			int pick;
			if(sticker[0][1]>sticker[1][1]) {
				dp[1]=sticker[0][1];
				pick=0;
			}
			else {
				dp[1]=sticker[1][1];
				pick=1;
			}
			
			for (int i = 2; i <= N; i++) {
				if(dp[i-1]+sticker[Math.abs(pick-1)][i]>dp[i-2]+Math.max(sticker[0][i],sticker[1][i])) {
					dp[i]=dp[i-1]+sticker[Math.abs(pick-1)][i];
					pick=Math.abs(pick-1);
				}
				else {
					if(sticker[0][i]>sticker[1][i]) {
						dp[i]=dp[i-2]+sticker[0][i];
						pick=0;
					}
					else {
						dp[i]=dp[i-2]+sticker[1][i];
						pick=1;
					}
				}
			}
			for (int x : dp) {
				sb.append(x+" ");
			}
			sb.append("\n");
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb.toString());
	}
}


