import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < N; i++) {
			int S;
			int T;
			String[] input = br.readLine().split(" ");
			S = Integer.parseInt(input[0]);
			T = Integer.parseInt(input[1]);
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(S);
			temp.add(T);
			arr.add(temp);
			
//			arr.sort(Comparator.naturalOrder());
		}
	}

}
