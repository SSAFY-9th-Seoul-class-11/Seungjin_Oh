import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 2000000000;
		int a = 0, b=0;
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		while(left<right) {
			int temp = arr[left]+arr[right];
//			System.out.println(arr[left]+" "+arr[right]+" "+temp);
			if(Math.abs(temp)<Math.abs(answer)) {
				answer = temp;
				a=arr[left];
				b=arr[right];
			}

			if(temp<0) left++; else right--;
		}
		System.out.println(a+" "+b);
	}

}
