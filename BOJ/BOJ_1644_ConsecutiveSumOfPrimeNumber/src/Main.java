import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> primeNumbers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primeNumbers=new ArrayList<>();
        if(N==1) {
            System.out.println(0);
            System.exit(0);
        }

        makePrimeNumbers();
//        System.out.println(primeNumbers.toString());
        int length = primeNumbers.size();
        int start=0;
        int end=0;
        int sum=primeNumbers.get(0);
        int answer=0;
        while(end<length && start<length && primeNumbers.get(end)<=N && primeNumbers.get(start)<=N) {
            if(sum<N) {
                if(++end>=length) break;
                sum+=primeNumbers.get(end);
            } else if(sum>N) {
                sum-=primeNumbers.get(start);
                if (++start>=length) break;
                if(start>end) end=start;
            } else {
//                System.out.println(start+" "+end);
//                System.out.println(sum);
                answer++;
                sum-=primeNumbers.get(start++);
            }
        }

        System.out.println(answer);
    }

    private static void makePrimeNumbers() {
        for (int i = 2; i <=N; i++) {
            if(isPrime(i)) primeNumbers.add(i);
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i%j==0) return false;
        }
        return true;
    }
}