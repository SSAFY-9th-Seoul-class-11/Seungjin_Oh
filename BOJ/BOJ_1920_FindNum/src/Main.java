import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] numArr1;
	static int[] numArr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		numArr1 = new int[N];
		
		for (int i = 0; i < N; i++) {
			numArr1[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		numArr2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			numArr2[i] = sc.nextInt();
		}

		Arrays.sort(numArr1);
		for (int i : numArr2) {
			if(binarySearch(i,0,numArr1.length-1)) {
				System.out.println(1);
			}
			else System.out.println(0);
		}		
	}

	private static boolean binarySearch(int i, int first, int last) {
		int mid = (first+last)/2;
		if(numArr1[mid]==i) return true;
		else if(first>=last) return false;
		
		if(i>numArr1[mid]) return binarySearch(i,mid+1,last);
		else return binarySearch(i,first,mid);
	}

}
