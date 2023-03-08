import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer> LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        LIS = new ArrayList<Integer>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        LIS.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if(arr[i]>LIS.get(LIS.size()-1)){
                LIS.add(arr[i]);
            } else {
                int index = BinarySearch(arr[i],0,LIS.size()-1);
                LIS.set(index,arr[i]);
            }
        }

        System.out.println(LIS.size());
    }

    private static int BinarySearch(int num, int left, int right) {
        while (left<right){
            int mid = (left+right)/2;

            if(LIS.get(mid)<num){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}