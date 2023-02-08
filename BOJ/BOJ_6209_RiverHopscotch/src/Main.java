import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int d=Integer.parseInt(input[0]);
		int n=Integer.parseInt(input[1]);
		int m=Integer.parseInt(input[2]);
		
		int[] rocks = new int[n+2];
		int[] diff = new int[n+1];
		for (int i = 1; i <= n; i++) {
			rocks[i]=Integer.parseInt(br.readLine());
		}
		rocks[n+1]=d;
		Arrays.sort(rocks);
		for (int i = 0; i <= n; i++) {
			diff[i] = rocks[i+1]-rocks[i];
		}
		
		
	}

}
