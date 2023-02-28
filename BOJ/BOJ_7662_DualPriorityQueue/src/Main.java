import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T ; tc++) {
			
			
			
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> queue = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				String[] input = br.readLine().split(" ");
				String command = input[0];
				int num = Integer.parseInt(input[1]);
				if(command.equals("I")) {
					queue.put(num, queue.getOrDefault(num, 0)+1);
				}
				else {
					if(queue.size()==0) continue;
					int key = num==1?queue.lastKey():queue.firstKey();
					if(queue.get(key)==1) queue.remove(key);
					else queue.put(key, queue.get(key)-1);
				}
			}
			
			if(queue.isEmpty()) System.out.println("EMPTY");
			else System.out.println(queue.lastKey()+" "+queue.firstKey());
			
		}
	}

}
