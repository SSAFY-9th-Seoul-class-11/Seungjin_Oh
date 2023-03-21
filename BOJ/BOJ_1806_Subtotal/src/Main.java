import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int S;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int start=0;
        int end=0;
        int tmpSum=arr[0];
        int tmpLength=1;
        int minLength=Integer.MAX_VALUE;

        while(start<arr.length && end<arr.length) {
            if (tmpSum>=S) {
                tmpLength=end-start+1;
                if (tmpLength<minLength) minLength = tmpLength;
                tmpSum-=arr[start];
                start++;
                if(start>end && start<arr.length){
                    end = start;
                    tmpSum=arr[start];
                }
            } else {
                end++;
                if (end<arr.length) tmpSum+=arr[end];
            }
        }
        int ans=minLength>=Integer.MAX_VALUE?0:minLength;
        System.out.println(ans);
    }
}