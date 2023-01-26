import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <=10; tc++) {
			int answer=0;
			int n = Integer.parseInt(sc.next());
			String[][] map = new String[8][8];
			for (int i = 0; i < map.length; i++) {
				String temp = sc.next();
				map[i] = temp.split("");
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length-n+1; j++) {
					String[] temp = new String[n];
					for (int k = 0; k < n; k++) {
						temp[k]=map[i][j+k];
					}
					if (isPalindrome(temp)) {
						answer++;
					} 
				}
			}
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8-n+1; j++) {
					String[] temp = new String[n];
					for (int k = 0; k < n; k++) {
						temp[k]=map[j+k][i];
					}
					if (isPalindrome(temp)) {
						answer++;
					} 
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

	public static boolean isPalindrome(String[] arr) {
		String[] temp = arr.clone();
		List<String> listItem = Arrays.asList(arr);
		Collections.reverse(listItem);
		String[] reversed = listItem.toArray(arr);
		if (Arrays.equals(reversed,temp)) {
			return true;
		}
		return false;
	}

}
