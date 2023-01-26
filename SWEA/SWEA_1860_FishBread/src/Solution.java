import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 1; T <= tc; T++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			boolean isPossible = true;
			int[] guest = new int[N];
			for (int i = 0; i < guest.length; i++) {
				guest[i]=sc.nextInt();
			}
			Arrays.sort(guest);
//			System.out.println(Arrays.toString(guest));
			
			for (int i = 0; i < guest.length; i++) {
				if(guest[i]/M*K-(i+1)<0) {
					System.out.println("#"+T+" Impossible");
					isPossible=false;
					break;
				}
			}
			if(isPossible)
				System.out.println("#"+T+" Possible");
		}
	}

}
