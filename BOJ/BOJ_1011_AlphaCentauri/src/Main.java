import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			
			
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			int n=y-x;
			int s=(int)Math.sqrt(n);
			if(n==Math.pow(s, 2)) System.out.println(2*s-1);
			else if(n>s*(s+1)) System.out.println(2*s+1);
			else System.out.println(2*s);
			
			
		}
	}

}
