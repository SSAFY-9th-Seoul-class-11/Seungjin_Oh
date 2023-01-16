import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int testcase = 1; testcase<=T;testcase++) {	
    		int n = sc.nextInt();
    		int[][] map = new int[n][n];
    		
    		sc.nextLine(); //버퍼 비우기
    		
    		for(int i = 0; i < n; i++){
    			String str = sc.nextLine();
    			for(int j = 0; j < n; j++) {
    				map[i][j] = str.charAt(j) - '0';
    			}
    		}
    		
    		int search_I=0;
    		int search_J=0;
    		int answer = 0;
    		for (int i = n/2; i >= 0; i--) {
    			search_J=0;
    			for (int j = 0; j < i; j++) {
					search_J++;
				}
				for (int j = 0; j < n-i*2; j++) {
					answer+=map[search_I][search_J];
					search_J++;
				}
				search_I++;
			}
    		
    		for (int i = 1; i <= n/2; i++) {
    			search_J=0;
    			for (int j = 0; j < i; j++) {
					search_J++;
				}
				for (int j = 0; j < n-i*2; j++) {
					answer+=map[search_I][search_J];
					search_J++;
				}
				search_I++;
			}
    		
    		System.out.printf("#%d %d\n",testcase,answer);
    	}
    }
}
