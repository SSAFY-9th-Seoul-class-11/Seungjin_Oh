import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			String[] input = br.readLine().split(" ");
			String s1 = input[0];
			String s2 = input[1];
			
			System.out.println("#"+tc+" "+sol(s1,s2));
		}
	}

	private static String sol(String s1, String s2) {
		BigInteger l1 = BigInteger.valueOf(s1.length());
        BigInteger l2 = BigInteger.valueOf(s2.length());
        BigInteger gcd = l1.gcd(l2);
        int lcm = (l1.intValue() * l2.intValue()) / gcd.intValue();
        String t1 = "";
        String t2 = "";
        while(t1.length()<lcm) {
        	t1+=s1;
        }
        while(t2.length()<lcm) {
        	t2+=s2;
        }
//        System.out.println(lcm);
//        System.out.println(t1);
//        System.out.println(t2);
        if(t1.equals(t2)) {
        	return "yes";
        }
        return "no";
	}

}
