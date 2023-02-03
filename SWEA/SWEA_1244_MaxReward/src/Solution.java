import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	public static String num;
	public static int N;
	public static ArrayList<Set<String>> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			
			
			String[] input = br.readLine().split(" ");
			
			num = input[0];
			N = Integer.parseInt(input[1]);
			arr = new ArrayList<Set<String>>();
			
			Set<String> tmp = new HashSet<>();
			tmp.add(num);
			arr.add(tmp);
			for (int i = 1; i <= N; i++) {
				tmp = new HashSet<>();
				for (String x : arr.get(i-1)) {
					char[] temp = toArr(x);
					for (int k = 0; k < temp.length-1; k++) {
						for (int l = k+1; l < temp.length; l++) {
							char[] temp2 = temp.clone();
							char t;
							t=temp2[k];
							temp2[k]=temp2[l];
							temp2[l]=t;
							String str = new String(temp2);
							tmp.add(str);
						}
					}
				}
				arr.add(tmp);
			}
			
			int max=-1;
			for (String string : arr.get(N)) {
				if (max<Integer.parseInt(string)) {
					max=Integer.parseInt(string);
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
		
	}

	private static char[] toArr(String x) {
		char[] nArr = new char[x.length()];
		for (int i = 0; i < nArr.length; i++) {
			nArr[i] = x.charAt(i);
		}
		return nArr;
	}

}
