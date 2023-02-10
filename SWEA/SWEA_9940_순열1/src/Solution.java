import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String answer = "Yes";
			String[] input = br.readLine().split(" ");
			int[] cnt=new int[N+1];
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(input[i]);
				if(num>N || num<1) {
					answer="No";
					break;
				}
				else {
					cnt[num]++;
					if(cnt[num]>1) {
						answer="No";
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

}
