import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.binarySearch;

class Jewelry{
    int M;
    int V;
    Jewelry(int M, int V){
        this.M = M;
        this.V = V;
    }

    @Override
    public String toString() {
        return "Jewelry{" +
                "M=" + M +
                ", V=" + V +
                '}';
    }
}
public class Main {
    static int N;
    static int K;
    static PriorityQueue<Integer> pq;
    static List<Integer> bags;
    static List<Jewelry> jewelries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        bags = new ArrayList<>();
        jewelries = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int tempM = Integer.parseInt(input[0]);
            int tempV = Integer.parseInt(input[1]);

            jewelries.add(new Jewelry(tempM, tempV));
        }
        for (int i = 0; i < K; i++) {
            int bag = Integer.parseInt(br.readLine());
            bags.add(bag);
            if(bag>max) max=bag;
        }
        jewelries.sort((Jewelry o1, Jewelry o2) -> {
            if(o1.M==o2.M)
                return o2.V-o1.V;
            else
                return o1.M-o2.M;
        });
//        System.out.println(jewelries.toString());
        bags.sort((o1, o2) -> o1-o2);
//        System.out.println(bags.toString());

        int index = 0;
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            while (index<N && jewelries.get(index).M<=bags.get(i)){
                pq.offer(jewelries.get(index).V);
                index++;
            }
//            System.out.println(pq.toString());
            if(!pq.isEmpty())
                answer += pq.poll();
        }
        System.out.println(answer);

    }
}

