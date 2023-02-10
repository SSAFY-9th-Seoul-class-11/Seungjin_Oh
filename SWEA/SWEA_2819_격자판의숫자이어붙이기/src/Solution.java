import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Pos {
    int x;
    int y;

    Pos(int x, int y){
        this.x=x;
        this.y=y;
    }
}


public class Solution {
    static int[][] map;
    static int N;
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};
    static Set<Integer> arr;

    private static void bfs(int x,int y,int cnt) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x,y));

        while(!q.isEmpty()){
            Pos p = q.poll();
            int a = p.x;
            int b = p.y;

            if(cnt==N){
            	
            }

            for (int i = 0; i < 4; i++) {
                int dx = a+xdir[i];
                int dy = b+ydir[i];

                if (isValidPosition(dx,dy)){
                    if (!visited[dx][dy] || ans[dx][dy] > ans[a][b] + map[dx][dy]){
                        ans[dx][dy] = ans[a][b]+map[dx][dy];
                        q.offer(new Pos(dx,dy));
                    }
                }
            }
        }
    }
    
    private static boolean isValidPosition(int x, int y) {
        if(x<0||x>=N||y<0||y>=N) return false;
        return true;
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int tc = 1; tc <=T; tc++) {
			
			arr = new HashSet<>();
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			bfs(0,0,1);
			
			
			
		}
	}

}
