import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int[][] sticker=new int[2][N];

			for (int i = 0; i < 2; i++) {
				String[] input=br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					sticker[i][j]=Integer.parseInt(input[j]);
				}
			}

			if (N<2){
				sb.append(Math.max(sticker[0][N-1],sticker[1][N-1])+"\n");
				continue;
			}

			sticker[0][1]+=sticker[1][0];
			sticker[1][1]+=sticker[0][0];


			for (int i = 2; i <N; i++) {
				sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
				sticker[1][i] += Math.max(sticker[0][i-1], sticker[0][i-2]);
			}
			sb.append(Math.max(sticker[0][N-1],sticker[1][N-1])+"\n");
		}
		System.out.println(sb.toString());
	}
}


