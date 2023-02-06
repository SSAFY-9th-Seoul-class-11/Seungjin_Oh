import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb;
	static int cnt;

	public static void move(int n, int s, int e) {
		if(n<=0) return;
		if(s+e>3) move(n-1,s,Math.abs(s-e));
		else move(n-1,s,3);
		cnt++;
		sb.append(s+" "+e+'\n');
		if(s+e>3) move(n-1,Math.abs(s-e),e);
		else move(n-1,3,e);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		cnt=0;
		
		move(N, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

}
