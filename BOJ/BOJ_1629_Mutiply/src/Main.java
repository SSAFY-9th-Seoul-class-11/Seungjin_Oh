import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        System.out.println(pow(a,b)%c);
    
    }
    

    private static long pow(long a, long b) {
        if(b==0) return 1;
        if(b==1) return a;
        if(b%2==0) {
            long temp = pow(a,b/2);
            return temp*temp%c;
        } else {
            return a*pow(a,b-1)%c;
        }
    }
}