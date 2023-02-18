import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> electricWire = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(input[0]);
            temp[1] = Integer.parseInt(input[1]);
            electricWire.add(temp);
        }

        electricWire.sort((s1, s2) -> s1[0] - s2[0]);

        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = electricWire.get(i)[1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i]<dp[j] && arr[i]>arr[j])
                    dp[i] = dp[j];
            }
            dp[i]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (i>max) max=i;
        }
        System.out.println(N-max);
    }
}
