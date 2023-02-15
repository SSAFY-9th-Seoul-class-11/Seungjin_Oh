import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int d=Integer.parseInt(input[0]);
		int n=Integer.parseInt(input[1]);
		int m=Integer.parseInt(input[2]);
		
		int[] rocks = new int[n+2];

		for (int i = 1; i <= n; i++) {
			rocks[i]=Integer.parseInt(br.readLine());
		}
		rocks[n+1]=d;
		Arrays.sort(rocks);

		if (n==m) System.out.println(d);  //돌을 전부 다 뺄 수 있으면 한번에 끝까지 점프
		else{
			List<Integer> jumps = new ArrayList<>();
			int left = rocks[0];
			int right = rocks[n+1];
			while(left<=right){
				int mid = (left+right)/2; //돌을 하나만 뺄 수 있다고 가정하면 반-반 뛰는게 가장 크게 뛸 수 있음
				int gijun = 0; //gijun까지 뛰었다고 가정
				int cnt=0; //뺀 돌의 개수

				for (int stone: rocks) {
					if (stone==rocks[0]) continue; //rocks[0]는 출발지라서 continue
					if (stone-gijun<mid){  //이 stone까지 뛰는게 mid보다 작으면
						cnt++; //이 stone을 뺀다고 가정
					}
					else{ //이 stone까지 뛰는게 mid보다 크거나 같으면
						if(stone!=rocks[n+1]){ // 도착지가 아니면
							gijun=stone; //이 stone까지 뛰었다고 가정
						}
					}
				}

				if (cnt>m) right=mid-1; //뺀 돌의 개수가 m보다 크다 -> 너무 많이 뺐음
				else{
					jumps.add(mid);
					left=mid+1; //뺀 돌의 개수가 m보다 작다 -> 너무 적게 뺐음
				}
			}
			System.out.println(Collections.max(jumps));
		}
	}

}
