import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208_Flatten {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int[] arr = new int[101];
			int dump = sc.nextInt();
			
			for (int j = 0; j < 100; j++) {
				int tmp = sc.nextInt();
				arr[tmp]+=1;
			}

			int left = 1;
			int right = 100;
			
			for (int j = 1; j < 101; j++) {
				if(arr[j]!=0) {
					left = j;
					break;
				}
			}
			for (int j = 100; j>0; j--) {
				if(arr[j]!=0) {
					right = j;
					break;
				}
			}
			for(int count = 0;count<dump;count++) {
				int sum = Arrays.stream(arr).sum();
//				System.out.print(count);
//				System.out.print(" ");
//				System.out.print(left);
//				System.out.print(" ");
//				System.out.print(right);
//				System.out.print(" ");
//				System.out.print(sum);
//				System.out.println(Arrays.toString(arr));
				while(arr[right]<=0) right--;
				if(right==left+1) {
					break;
				}
				arr[right]--;
				arr[right-1]++;
				arr[left]--;
				arr[left+1]++;
				
				if(arr[left]<=0) left++;
			}
			System.out.printf("#%d %d\n",i,right-left);
		}
	}
}
