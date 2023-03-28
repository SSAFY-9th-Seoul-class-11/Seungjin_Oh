import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static char[] operator={'+','-','*','/','(',')'};
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now=='+' || now=='-'){
                while(!stack.isEmpty() && (stack.peek()=='*'||stack.peek()=='/'||stack.peek()=='+'||stack.peek()=='-')) {
                    System.out.print(stack.pop());
                }
                stack.push(now);
            }
            else if (now=='*' || now=='/') {
                while(!stack.isEmpty() && (stack.peek()=='*'||stack.peek()=='/')) {
                    System.out.print(stack.pop());
                }
                stack.push(now);
            }
            else if (now=='(') {
                stack.push(now);
            }
            else if (now==')') {
                while(!stack.isEmpty() && (stack.peek()!='(')) {
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
            else {
                System.out.print(now);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}