import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static List<int[]> electricWire;
	static List<Integer> lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        electricWire = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(input[0]);
            temp[1] = Integer.parseInt(input[1]);
            electricWire.add(temp);
        }

        electricWire.sort((s1, s2) -> s1[0] - s2[0]);
        
        lis = new ArrayList<>();
        lis.add(electricWire.get(0)[1]);
        int[] indexes = new int[N];
        indexes[0] = 0;
        
        for (int i = 1; i < N; i++) {
            int index = lis.size();
            if(electricWire.get(i)[1]>lis.get(index-1)) lis.add(electricWire.get(i)[1]);
            else {
                index = binarySearch(electricWire.get(i)[1],0,index-1);
                lis.set(index,electricWire.get(i)[1]);
            }
            indexes[i] = index;
        }
        
        boolean[] answer = new boolean[N];
        int x = lis.size()-1;
        System.out.println(N-(x+1));
        for (int i = N-1; i>=0 ; i--) {
            if(x==indexes[i]) {
            	answer[i]=true;
                x--;
            }
        }
        for (int i = 0; i < N; i++) {
			if(!answer[i]) System.out.println(electricWire.get(i)[0]);
		}
    }

	private static int binarySearch(int num, int left, int right) {
		while (left < right) {
            int mid = (left + right)/ 2;
            if(lis.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return right;
	}
}
