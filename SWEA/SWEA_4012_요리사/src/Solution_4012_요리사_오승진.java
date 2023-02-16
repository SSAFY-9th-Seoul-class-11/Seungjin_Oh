import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution_4012_요리사_오승진 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] synergy;
	static int[] numbers;
	static int[] numbers2;
	static LinkedList<int[]> combination;
	static List<Integer> synergyA;
	static List<Integer> synergyB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			
			
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			combination=new LinkedList<>();
			numbers=new int[N/2];
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(input[j]);
				}
			}
			comb(0,1);
			
//			for (int[] is : combination) {
//				System.out.println(is[0]+","+is[1]);
//			}
			
			List<int[]> A = new ArrayList<>();
			List<int[]> B = new ArrayList<>();
			
			while(!combination.isEmpty()) {
				A.add(combination.pollFirst());
				B.add(combination.pollLast());
			}
			
			List<Integer> synergyDiff = new ArrayList<>();
			for (int i = 0; i < A.size(); i++) {
				int[] a = A.get(i);
				int[] b = B.get(i);
//				for (int x : a) {
//					System.out.print(x+" ");
//				}
//				System.out.println();
//				for (int x : b) {
//					System.out.print(x+" ");
//				}
//				System.out.println();
//				System.out.println();
				
				numbers2=new int[2];
				synergyA = new ArrayList<>();
				comb2(0,0,a,synergyA);
				numbers2=new int[2];
				synergyB = new ArrayList<>();
				comb2(0,0,b,synergyB);
				
				for (int j = 0; j < synergyA.size(); j++) {
					synergyDiff.add(Math.abs(synergyA.get(j)-synergyB.get(j)));
				}
			}
			
			sb.append("#"+tc+" "+Collections.min(synergyDiff)+"\n");
			
			
		}
		System.out.println(sb.toString());
	}
	
	
	private static void comb(int cnt, int start) {
		if(cnt==N/2) {
//			System.out.println(Arrays.toString(numbers));
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
	
	private static void comb2(int cnt, int start, int[] array, List<Integer> synergyList) {
		if(cnt==2) {
//			System.out.println(Arrays.toString(numbers));
			int a=numbers2[0];
			int b=numbers2[1];
			int temp = synergy[a-1][b-1]+synergy[b-1][a-1];
			
			synergyList.add(temp);
			return;
		}
		for (int i = start; i <array.length; i++) {
			numbers2[cnt] = array[i];
			comb2(cnt+1,i+1,array,synergyList);
		}
	}

}
