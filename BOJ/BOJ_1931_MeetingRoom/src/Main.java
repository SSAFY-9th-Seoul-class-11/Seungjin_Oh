import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] timeTable = new int[N][2];
        int answer =0;

        for (int i = 0; i < N; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }

        Arrays.sort(timeTable, (o1, o2) -> {
            if (o1[1]== o2[1]) {
                return o1[0]-o2[0];
            }
            else return o1[1]-o2[1];
        });

        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (timeTable[i][0]>=endTime){ //startTime이 endTime보다 이후면
                answer++;
                endTime = timeTable[i][1];
            }
        }

        System.out.println(answer);
    }
}

