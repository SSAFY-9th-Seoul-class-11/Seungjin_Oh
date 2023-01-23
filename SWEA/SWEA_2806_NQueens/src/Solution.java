import java.util.Scanner;

public class Solution {
    public static int[] map;
    public static int N;
    public static int answer=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N];
            answer=0;

            nQueen(0);
            System.out.printf("#%d %d\n",tc,answer);
        }
    }

    private static void nQueen(int q) {
        if (N==q){
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[q]=i;
            if (isPossible(q)) nQueen(q+1);
//            if (result==1) return;
        }
    }

    private static boolean isPossible(int c) {
        for (int i = 0; i < c; i++) {
            if (map[c]==map[i]) return false;
            else if(Math.abs(c - i) == Math.abs(map[c] - map[i])) return false; //열의 차와 행의 차가 같을 경우 대각선에 놓여있음.
        }
        return true;
    }

}

