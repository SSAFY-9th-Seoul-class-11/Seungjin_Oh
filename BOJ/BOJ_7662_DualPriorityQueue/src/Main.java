import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T ; tc++) {
			
			
			
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1,o2) -> o1-o2);
			PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1,o2) -> o2-o1);
			int qSize = 0;
			
			for (int i = 0; i < k; i++) {
				String[] input = br.readLine().split(" ");
				String command = input[0];
				
				int num = Integer.parseInt(input[1]);
				if(command.equals("I")) {
					queue1.offer(num);
					queue2.offer(num);
					qSize++;
				}
				else {
					if(qSize==0) continue;
					
					if(num==-1) queue1.poll(); //최소
					else queue2.poll(); //최대
					qSize--;
				}
			}
			
			if(qSize==0) System.out.println("EMPTY");
			else {
				if(qSize==1) System.out.println(queue1.peek()+" "+queue1.peek());
				else System.out.println(queue2.peek()+" "+queue1.peek());
			}
			
			
			
		}
	}

}
