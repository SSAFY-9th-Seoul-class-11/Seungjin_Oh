import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        if (A==B) {
            System.out.println(1);
            return;
        }

        int answer = 0;
        Queue<Long> queue = new ArrayDeque<>();
        queue.offer(A);
        queue.offer((long) -1);
        boolean isB = false;

        while (!queue.isEmpty()) {
            long x = queue.poll();
            if (x == -1) {
                if (queue.isEmpty()) break;
                queue.offer((long) -1);
                answer++;
                continue;
            }

            long dx = x*2;
            if(dx==B) {
                isB = true;
                answer++;
                break;
            }
            if(dx<=B) queue.offer(dx);

            dx = x*10+1;
            if(dx==B) {
                isB = true;
                answer++;
                break;
            }
            if(dx<=B) queue.offer(dx);
        }
        if (isB) System.out.println(answer+1);
        else System.out.println(-1);
    }
}