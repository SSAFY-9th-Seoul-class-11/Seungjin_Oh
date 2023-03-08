import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static int N;
    static int[] arr;
    static int[] indexes;
    static List<Integer> lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        indexes = new int[N];
        lis = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        lis.add(arr[0]);
        indexes[0] = 0;

        for (int i = 1; i < N; i++) {
            int index = lis.size();
            if(arr[i]>lis.get(index-1)) lis.add(arr[i]);
            else {
                index = binarySearch((ArrayList<Integer>) lis, arr[i],0,index-1);
                lis.set(index,arr[i]);
            }
            indexes[i] = index;
        }

//        System.out.println(Arrays.toString(indexes));
        Stack<Integer> answer = new Stack<>();
        int x = lis.size()-1;
        System.out.println(x+1);
        for (int i = N-1; i>=0 ; i--) {
            if(x==indexes[i]) {
                answer.push(arr[i]);
                x--;
            }
        }
        while (!answer.isEmpty()) {
            System.out.print(answer.pop()+" ");
        }
    }



    public static int binarySearch(ArrayList<Integer> lis, int num, int left, int right) {
        while (left < right) {
            int mid = (left + right)/ 2;
            if(lis.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}