import java.util.Scanner;

public class Main_3043_백설공주와일곱난쟁이_오승진 {
    static int[] dwarfs;
    static int totalSum;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dwarfs = new int[9];
        numbers = new int[2];

        for (int i = 0; i <9;i++){
            dwarfs[i] = sc.nextInt();
        }

        totalSum=0;
        for (int dwarf :dwarfs) {
            totalSum+=dwarf;
        }

        comb(0,0);
    }

    private static void comb(int cnt, int start) {
        if(cnt==2) {
            int temp = totalSum;
            for (int i = 0; i < 2; i++) {
                temp-=numbers[i];
            }
            if (temp==100){
                for (int dwarf :
                        dwarfs) {
                    if (dwarf==numbers[0]||dwarf==numbers[1]) continue;
                    System.out.println(dwarf);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            numbers[cnt]=dwarfs[i];
            comb(cnt+1,i+1);
        }
    }
}
