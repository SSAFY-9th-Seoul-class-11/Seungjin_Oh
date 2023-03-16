import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class compare implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        for (int i = 0; i < o2.size(); i++) {
            if (o1.get(i).equals(o2.get(i))) continue;
            else return o1.get(i) - o2.get(i);
        }
        return 0;
    }
}

public class Main {
    static int N;
    static int M;
    static Integer[] arr;
    static int[] permu;
    static List<ArrayList<Integer>> answerList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new Integer[N];
        permu = new int[N];
        answerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr, (i1,i2) -> i2 - i1);

        for (int i = 0; i < M ; i++) {
            permu[N-1-i] = M-i;
        }

        do {
            ArrayList<Integer> tempList = new ArrayList<>();
            int[] temp = new int[M+1];
            for (int i = 0; i < N; i++) {
                if(permu[i]!=0) temp[permu[i]] = arr[i];
            }
            for (int i = M; i >= 1; i--) {
                tempList.add(temp[i]);
            }
            answerList.add(tempList);
        }while(np(permu));

        Collections.sort(answerList, new compare());
        for (ArrayList<Integer> answer : answerList) {
            for (Integer num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static boolean np(int[] permu) {
        int i = N-1;
        while(i>0&&permu[i-1]>=permu[i]) --i;
        if(i==0) return false;

        int j = N-1;
        while(permu[i-1]>=permu[j]) --j;

        swap(permu,i-1,j);
        int k = N-1;
        while(i<k) swap(permu,i++,k--);

        return true;
    }

    private static void swap(int[] p, int i, int j) {
        int temp=p[i];
        p[i]=p[j];
        p[j]=temp;
    }
}