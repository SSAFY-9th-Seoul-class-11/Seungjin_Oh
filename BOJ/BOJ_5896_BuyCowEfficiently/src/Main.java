import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Cow{
    int index;
    int originalPrice;
    int couponPrice;
    public Cow(int index, int originalPrice, int couponPrice){
        this.index = index;
        this.originalPrice = originalPrice;
        this.couponPrice = couponPrice;
    }

}

public class Main {
    static int N;
    static int K;
    static long M;
    static Cow[] cows;
    static boolean[] isBuy;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        M = Long.parseLong(input[2]);
        answer=0;
        isBuy = new boolean[N];

        cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            Cow cow = new Cow(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            cows[i] = cow;
        }

        Arrays.sort(cows, (a,b)->{
            if(a.couponPrice==b.couponPrice){
                return b.originalPrice-a.originalPrice;
            }
            return a.couponPrice-b.couponPrice;
        });

        PriorityQueue<Cow> pq = new PriorityQueue<>((a,b)->{
            return a.originalPrice-b.originalPrice;
        });

        for (int i = 0; i < K; i++) {
            if (cows[i].couponPrice<=M){
                M-=cows[i].couponPrice;
                answer++;
                isBuy[cows[i].index]=true;
                pq.add(cows[i]);
            }
        }

        Arrays.sort(cows, (a,b)->
            a.originalPrice-b.originalPrice
        );

        for (int i = 0; i < N; i++) {
            if(isBuy[cows[i].index]) continue;
            if(!pq.isEmpty()) {
                Cow cow = pq.peek();
                if (Math.min(cow.originalPrice - cow.couponPrice + cows[i].couponPrice,cows[i].originalPrice) > M) {//살수없어?
                    continue;
                }
                if (cow.originalPrice+cows[i].couponPrice<cow.couponPrice+cows[i].originalPrice){ //바꾸는게 이득임?
                    pq.poll(); //사
                    M -= cows[i].couponPrice;
                    M += cow.couponPrice;
                    M -= cow.originalPrice;
                    answer++;
                    isBuy[cows[i].index] = true;
                    pq.add(cows[i]);
                } else { //안바꾸는게 이득임?
                    M -= cows[i].originalPrice; //사
                    answer++;
                    isBuy[cows[i].index] = true;
                }
            } else {
                if(cows[i].originalPrice<=M){
                    M-=cows[i].originalPrice;
                    answer++;
                    isBuy[cows[i].index]=true;
                }
            }
        }
        System.out.println(answer);

    }
}