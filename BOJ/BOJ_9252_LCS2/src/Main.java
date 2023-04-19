import java.util.Scanner;
import java.util.Stack;

public class Main {
    static char[] s1;
    static char[] s2;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.next().toCharArray();
        s2 = sc.next().toCharArray();
        dp = new int[s1.length+1][s2.length+1];
        for(int i=1; i<=s1.length; i++) {
            for(int j=1; j<=s2.length; j++) {
                dp[i][j] = s1[i-1]==s2[j-1]?dp[i-1][j-1]+1:Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int answer = dp[s1.length][s2.length];
        System.out.println(answer);
        if (answer != 0) {
            Stack<Character> stack = new Stack<>();
            int i = s1.length;
            int j = s2.length;
            while (i > 0 && j > 0) {
                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else if (dp[i][j] == dp[i][j - 1]) {
                    j--;
                } else {
                    stack.push(s1[i - 1]);
                    i--;
                    j--;
                }
            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}