import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static List<int[]> electircWire;
	static int[] arr;
	static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        electircWire = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(input[0]);
            temp[1] = Integer.parseInt(input[1]);
            electircWire.add(temp);
        }

        electircWire.sort((s1, s2) -> s1[0] - s2[0]);
        
        
        lis = new int[N];
        lis[0] = electircWire.get(0)[1];
        int j=0;
        for (int i = 1; i < N; i++) {
        	for (int k = 0; k <=j; k++) {
        		System.out.print(lis[k]+" ");
        	}
        	System.out.println();
            int num = electircWire.get(i)[1];
            if(lis[j]<num) {
            	lis[j+1] = num;
            	j+=1;
            }
            else lis[binarySearch(0,j,num)]=num;
        }
        System.out.println();
        System.out.println(N-j);
    }

	private static int binarySearch(int start, int end, int num) {
		if(start>=end) return end;
		int mid = (start+end)/2;
		if(lis[mid]<num) return binarySearch(mid+1, end, num);
		else return binarySearch(start, mid, num);
	}
}
