import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, K;
        int answer = 0;

        N = sc.nextInt();
        K = sc.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int i=N-1;
        while(K>0){
            if (coins[i] > K) {
                i--;
                continue;
            }
            else{
                K-=coins[i];
                answer++;
            }
        }
        System.out.println(answer);

    }
}
