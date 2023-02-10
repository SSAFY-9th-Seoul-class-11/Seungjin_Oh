import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max_N = n+10;
		List<Integer> values = new ArrayList<>();
		List<Integer> tags = new ArrayList<>();

		values.add(0);
		tags.add(0);
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			values.add(Integer.parseInt(input[i]));
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			tags.add(Integer.parseInt(input[i]));
		}
		
		Collections.sort(values);
		Collections.sort(tags);
		values.add(0);
		tags.add(0);
		
		int[][] dp = new int[max_N][4];
		
		for (int i = n; i > 0;i--) {
			dp[i][2] = Math.max(dp[i+1][2], Math.abs(values.get(i)-tags.get(i)));
			dp[i][3] = Math.min(Math.max(dp[i+1][2], Math.abs(values.get(i)-tags.get(i))), Math.max(dp[i+1][3],Math.abs(values.get(i)-tags.get(i-1))));}
		
		int[] pair = {Integer.MAX_VALUE,Integer.MAX_VALUE};
		
		
		for (int i = 1; i < n+1; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.abs(values.get(i)-tags.get(i)));
			dp[i][1] = Math.min(Math.max(dp[i-1][0], Math.abs(values.get(i)-tags.get(i))), Math.max(dp[i-1][1],Math.abs(values.get(i)-tags.get(i+1))));
			int[] compare_a = {Math.max(dp[i-1][1], dp[i+1][2]), values.get(i)};
			if (pair[0]>compare_a[0]) {
				pair=compare_a;}
			else if(pair[0]==compare_a[0]) {
				if(pair[1]>compare_a[1]) {
					pair=compare_a;}}
			int[] compare_b = {Math.max(dp[i-1][0], dp[i+1][3]), values.get(i)};
			if (pair[0]>compare_b[0]) {
				pair=compare_b;}
			else if(pair[0]==compare_b[0]) {
				if (pair[1]>compare_b[1]) {
					pair=compare_b;}}}
		System.out.println(pair[1]);
	}
}
