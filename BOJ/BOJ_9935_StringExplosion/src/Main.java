import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    static Stack<Character> stack;
    static char[] T;
    static String P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine().toCharArray();
        P = br.readLine();
        stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            stack.push(T[i]);
            if(check()) {
                for (int j = 0; j < P.length(); j++) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
    }

    private static boolean check() {
        if(stack.size() < P.length()) return false;
        for (int i = 0; i < P.length(); i++) {
            if(stack.get(stack.size()-1-i) != P.charAt(P.length()-1-i)) return false;
        }
        return true;
    }
}