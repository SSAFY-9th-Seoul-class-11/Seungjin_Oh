import java.io.IOException;
import java.util.HashSet;
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
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};
    static Set<String> arr;

    private static void dfs(int x,int y,String n) {
        n=n+map[x][y];
        if(n.length()==7){
            arr.add(n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x+xdir[i];
            int dy = y+ydir[i];

            if (isValidPosition(dx,dy)){
                dfs(dx,dy,n);
            }
        }
    }
    
    private static boolean isValidPosition(int x, int y) {
        if(x<0||x>=4||y<0||y>=4) return false;
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

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i,j,"");
                }
            }
            System.out.println("#"+tc+" "+arr.size());
		}
	}

}
