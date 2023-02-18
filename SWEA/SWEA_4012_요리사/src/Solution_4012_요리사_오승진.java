import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_4012_요리사_오승진 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] synergy;
	static int[] numbers;
	static LinkedList<int[]> combination;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			
			
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			combination=new LinkedList<>();
			numbers=new int[N/2];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(input[j]);
				}
			}
			comb(0,1);
			
			List<int[]> A = new ArrayList<>();
			List<int[]> B = new ArrayList<>();
			
			while(!combination.isEmpty()) {
				A.add(combination.pollFirst());
				B.add(combination.pollLast());
			}
			for (int i = 0; i < A.size(); i++) {
				min = Math.min(calcSynergyDiff(A.get(i), B.get(i)), min);
			}

			
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int calcSynergyDiff(int[] a, int[] b) {
		int synergyA = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i==j) continue;
				synergyA+=synergy[a[i]-1][a[j]-1];
			}
		}
		int synergyB = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i==j) continue;
				synergyB+=synergy[b[i]-1][b[j]-1];
			}
		}

		return Math.abs(synergyA-synergyB);
	}


	private static void comb(int cnt, int start) {
		if(cnt==N/2) {
			int[] temp = new int[N/2];
			for (int i = 0; i < N/2; i++) {
				temp[i]=numbers[i];
			}
			combination.add(temp);
			return;
		}
		for (int i = start; i <=N; i++) {
			numbers[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

}
