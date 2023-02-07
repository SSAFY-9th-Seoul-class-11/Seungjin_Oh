import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
		}
		arr.sort((x,y)->x.get(0)-y.get(0));
//		for (ArrayList<Integer> x : arr) {
//			System.out.println(x.get(0)+" "+x.get(1));
//		}
		int answer = 1;
		ArrayList<ArrayList<Integer>> classRoom = new ArrayList<ArrayList<Integer>>();
		classRoom.add(arr.get(0));
		for (int i = 1; i < arr.size(); i++) {
			boolean isPossible = false;
			for (int j = 0; j < classRoom.size(); j++) {
				if (arr.get(i).get(0)>=classRoom.get(j).get(1)) {
					isPossible = true;
					classRoom.remove(j);
				}
			}
			if(isPossible==false) {
				answer++;
			}

			classRoom.add(arr.get(i));
			classRoom.sort((x,y)->x.get(1)-y.get(1));
//			for (ArrayList<Integer> x : classRoom) {
//				System.out.println(x.get(0)+" "+x.get(1));
//			}
//			System.out.println();
		}
		
		
		System.out.println(answer);
	}

}
