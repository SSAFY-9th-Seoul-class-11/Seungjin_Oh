import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int testcase = sc.nextInt();
			int[] arr = new int[8];
			int[] order = {0,1,2,3,4,5,6,7};
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int now=0;
	NEXT:	while(true) {
				for (int i=1; i<=5;i++) {
					if (arr[now]-i>0)
						arr[now]-=i;
					else arr[now]=0;
					order[now]+=8;
					
					if (arr[now]<=0) {
						System.out.print("#"+testcase+" ");
						print(arr,order);
						System.out.println();
						break NEXT;
					}
					now++;
					if(now>7) {
						now=0;
					}
				}
			}
			
		}
		
	}

	private static void print(int[] arr, int[] order) {
		int min=2100000000;
		int minIdx = -1;
		for(int i=0;i<8;i++) {
			if(order[i]<min) {
				min=order[i];
				minIdx = i;
			}
		}
		for(int i=minIdx;i<8;i++)
			System.out.print(arr[i]+" ");
		for(int i=0;i<minIdx;i++)
			System.out.print(arr[i]+" ");
	}

}
