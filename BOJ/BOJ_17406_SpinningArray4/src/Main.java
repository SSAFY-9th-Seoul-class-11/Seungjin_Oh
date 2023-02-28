import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][] savemap;
    static int[][] rcs;
    static int[] permutationIndex;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N  = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        rcs = new int[K][3];

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        savemap = new int[N][M];
        for (int i = 0; i < N; i++) {
            savemap[i] = map[i].clone();
        }

        permutationIndex=new int[K];
        for (int i = 0; i < K; i++) {
            permutationIndex[i] = i;
            input = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rcs[i][j] = Integer.parseInt(input[j]);
            }
        }

        do {
            map=savemap;
            int answer=0;
//            System.out.println(Arrays.toString(permutationIndex));
            for (int index : permutationIndex) {
                spin(rcs[index]);
//                print(map);
            }
            answer = calcValue(map);
            if(answer<min) min = answer;
        }while (np(permutationIndex));

        System.out.println(min);
    }

    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void spin(int[] rcs) {
        int r = rcs[0];
        int c = rcs[1];
        int s = rcs[2];

        int startPointX = r-s-1;
        int startPointY = c-s-1;

        int endPointX = r+s-1;
        int endPointY = c+s-1;

        int[][] temp = new int[N][M];
        int spinArrSize = (2*s)+1;
        int[][] spinArr = new int[spinArrSize][spinArrSize];
        int[][] tempSpinArr = new int[spinArrSize][spinArrSize];

        for (int i=0, x = startPointX; x <= endPointX; x++,i++) {
            for (int j=0, y = startPointY; y <= endPointY; y++,j++) {
                spinArr[i][j] = map[x][y];
            }
        }

//        System.out.println("spinArr");
//        print(spinArr);

        int tmpX = 0;
        int tmpY = 0;

        while (spinArrSize>0){
            int saveTmpX = tmpX;
            int saveTmpY = tmpY;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < spinArrSize; tmpX++,i++) {
                queue.offer(spinArr[tmpX][tmpY]);
            }
            tmpX--;
            tmpY++;
            for (int i = 0; i < spinArrSize-1; tmpY++,i++) {
                queue.offer(spinArr[tmpX][tmpY]);
            }
            tmpY--;
            tmpX--;
            for (int i = 0; i < spinArrSize-1; tmpX--,i++) {
                queue.offer(spinArr[tmpX][tmpY]);
            }
            tmpX++;
            tmpY--;
            for (int i = 0; i < spinArrSize - 2; tmpY--,i++) {
                queue.offer(spinArr[tmpX][tmpY]);
            }


            queue.offer(queue.poll());

            tmpX = saveTmpX;
            tmpY = saveTmpY;

            for (int i = 0; i < spinArrSize; tmpX++,i++) {
                tempSpinArr[tmpX][tmpY] = queue.poll();
            }
            tmpX--;
            tmpY++;
            for (int i = 0; i < spinArrSize - 1; tmpY++,i++) {
                tempSpinArr[tmpX][tmpY] = queue.poll();
            }
            tmpY--;
            tmpX--;
            for (int i = 0; i < spinArrSize-1; tmpX--,i++) {
                tempSpinArr[tmpX][tmpY] = queue.poll();
            }
            tmpX++;
            tmpY--;
            for (int i = 0; i < spinArrSize - 2; tmpY--,i++) {
                tempSpinArr[tmpX][tmpY] = queue.poll();
            }

//            System.out.println(tmpX+","+tmpY);
            spinArrSize-=2;
            saveTmpX++;
            saveTmpY++;
            tmpX = saveTmpX;
            tmpY = saveTmpY;
        }

//        System.out.println("after spin");
//        print(tempSpinArr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!(i>=startPointX && i<=endPointX && j>=startPointY && j<=endPointY)) temp[i][j] = map[i][j];
                else{
                    temp[i][j] = tempSpinArr[i-startPointX][j-startPointY];
                }
            }
        }

        map = temp;
    }

    private static int calcValue(int[][] map) {
        int tmpmin=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int answer=0;
            for (int j = 0; j < M; j++) {
                answer+=map[i][j];
            }
            if (answer<tmpmin) tmpmin = answer;
        }
        return tmpmin;
    }

    private static boolean np(int[] permutationIndex) {
        int n = permutationIndex.length;

        int i=n-1;
        while(i>0 && permutationIndex[i-1]>=permutationIndex[i]) --i;
        if (i==0) return false;

        int j = n-1;
        while(permutationIndex[i-1] >= permutationIndex[j]) --j;

        swap(permutationIndex, i-1, j);
        int k=n-1;
        while(i<k) swap(permutationIndex,i++,k--);

        return true;
    }

    private static void swap(int[] permutationIndex, int i, int j) {
        int temp = permutationIndex[i];
        permutationIndex[i] = permutationIndex[j];
        permutationIndex[j] = temp;
    }
}