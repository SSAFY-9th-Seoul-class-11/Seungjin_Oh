import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        char[] Operators = new char[25];
        int opSize = 0;
        int answer = 0;

        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)=='+'||temp.charAt(i)=='-'){
                Operators[opSize]=temp.charAt(i);
                opSize++;
            }
        }

        String[] number = temp.split("-|\\+");
        String[] expression = new String[opSize+ number.length];
        for (int i = 0; i < number.length; i++) {
            expression[i*2]=number[i];
        }
        for (int i = 0; i < opSize; i++) {
            expression[i*2+1]= String.valueOf(Operators[i]);
        }

        boolean meetMinus = false;
        int tmp=0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("-")){
                if (meetMinus){
                    answer-=tmp;
                    tmp=0;
                }
                else{
                    meetMinus=true;
                }
            }
            else if(expression[i].equals("+")) continue;
            else{
                if (meetMinus){
                    tmp+=Integer.parseInt(expression[i]);
                }
                else{
                    answer+=Integer.parseInt(expression[i]);
                }
            }
        }
        if (tmp!=0) answer-=tmp;
        System.out.println(answer);
    }
}
