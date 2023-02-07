import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] temp;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {




			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			String command = input[1];

			map = new int[N][N];
			temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}  //map 입력

			if(command.equals("up")) { //up이면 그냥 game-move
				game(map);
				move(map);
			}

			else if(command.equals("down")) { //down이면 180도 회전한 다음 game-move-180도 회전
				for (int i = N-1; i >=0; i--) {
					for (int j = N-1; j >=0; j--) {
						temp[N-1-i][N-1-j]=map[i][j];
					}
				}
				game(temp);
				move(temp);
				map = new int[N][N];
				for (int i = N-1; i >=0; i--) {
					for (int j = N-1; j >=0; j--) {
						map[N-1-i][N-1-j]=temp[i][j];
					}
				}
			}

			else if(command.equals("left")) { //left면 오른쪽으로 90도 회전 - game-move-왼쪽으로 90도 회전
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						temp[i][j] = map[N-1-j][i];
					}
				}

				game(temp);
				move(temp);
				map = new int[N][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = temp[j][N-1-i];
					}
				}

			}

			else if(command.equals("right")) { //right면 왼쪽으로 90도 회전 - game-move-오른쪽으로 90도 회전
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						temp[i][j] = map[j][N-1-i];
					}
				}

				game(temp);
				move(temp);
				map = new int[N][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = temp[N-1-j][i];
					}
				}
			}

			System.out.println("Case #"+tc+":");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}


		}
	}

	private static void move(int[][] arr) { //0을 무시하고 위로 올리는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[j][i]==0) {
					for (int k = j+1; k < N; k++) {
						if(arr[k][i]!=0) {
							arr[j][i]=arr[k][i];
							arr[k][i]=0;
							break;
						}
					}
				}
			}
		}
	}

	private static void game(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = i+1; k < N; k++) { //아래로 탐색하면서
					if(arr[k][j]==0) continue;
					else if(arr[k][j]==arr[i][j]) { //가장 처음 만나는 0이아닌 숫자가 같은 숫자일 때
						arr[k][j]=0; //아래를 0으로 만들고
						arr[i][j]*=2; //위를 2배로 
						break;
					}
					else break;
				}
			}
		}
	}

}
