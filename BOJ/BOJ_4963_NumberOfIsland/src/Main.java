import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] input = br.readLine().split(" ");
			w=Integer.parseInt(input[0]);
			h=Integer.parseInt(input[1]);
			if (w==0 || h==0) break;
			map=new int[h][w];
			answer = 0;
			for (int i = 0; i < h; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			} 
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (dfs(i,j)==true) {
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static boolean dfs(int i, int j) {
		if(!isValidPos(i,j)) return false;
		
		if(map[i][j]==1) {
			map[i][j]=0;
			dfs(i+1,j);
			dfs(i,j+1);
			dfs(i-1,j);
			dfs(i,j-1);
			
			dfs(i-1,j-1);
			dfs(i-1,j+1);
			dfs(i+1,j-1);
			dfs(i+1,j+1);
			
			return true;
		}
		return false;
	}

	private static boolean isValidPos(int x, int y) {
		if (x<0 || y<0 || x>=h || y>=w) return false;
		return true;
	}

}
