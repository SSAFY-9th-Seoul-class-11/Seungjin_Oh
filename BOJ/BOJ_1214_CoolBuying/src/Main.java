import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int D;
    static int P;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        D = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        if(P<Q) {
            int temp = P;
            P = Q;
            Q = temp;
        }

        if (D%P==0) {
            System.out.println(D);
            return;
        }

        int N = D/P+1;
        int ans = P*N;
        for (int i = N; i >=0 ; i--) {
            int cost = P*i;
            int remain = D - cost;
            if(remain>0 && remain%Q==0){
                ans=D;
                break;
            }
            if (remain>0) {
                int Qgaesu = remain/Q+1;
                if(cost+Q*Qgaesu<ans) ans = cost+Q*Qgaesu;
            }
        }
        System.out.println(ans);
    }
}