import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int C;
    static int P;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        arr = new int[C];
        answer = 0;

        input = reader.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        solve(P);
        System.out.println(answer);
    }

    private static void solve(int p) {
        switch (p) {
            case 1:
                answer+=C;
                for (int i = 0; i <= C - 4; i++) {
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2] && arr[i+2] == arr[i+3])  answer++;
                }
                break;
            case 2:
                for (int i = 0; i <= C - 2; i++) {
                    if(arr[i] == arr[i+1]) answer++;
                }
                break;
            case 3:
                for (int i = 0; i <= C - 3; i++) {
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]-1) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]+1) answer++;
                }
                break;
            case 4:
                for (int i = 0; i <= C - 3; i++) {
                    if(arr[i] == arr[i+1]+1 && arr[i+1] == arr[i+2]) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]-1) answer++;
                }
                break;
            case 5:
                for (int i = 0; i <= C - 3; i++) {
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]+1) answer++;
                }
                for (int i = 0; i <= C - 3; i++) {
                    if (arr[i]-1 == arr[i+1] && arr[i+1] == arr[i+2]-1) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]-1) answer++;
                }
                break;
            case 6:
                for (int i = 0; i <= C - 3; i++) {
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]) answer++;
                }
                for (int i = 0; i <= C - 3; i++) {
                    if (arr[i]+1 == arr[i+1] && arr[i+1] == arr[i+2]) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]+2) answer++;
                }
                break;
            case 7:
                for (int i = 0; i <= C - 3; i++) {
                    if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]) answer++;
                }
                for (int i = 0; i <= C - 3; i++) {
                    if (arr[i] == arr[i+1] && arr[i+1] == arr[i+2]+1) answer++;
                }
                for (int i = 0; i <= C - 2; i++) {
                    if (arr[i] == arr[i+1]-2) answer++;
                }
                break;
        }
    }
}