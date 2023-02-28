import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

class Tetromino {
	Pos position;
	Pos[] space;
	String shape;
	public Tetromino (int x, int y, String shape) {
		this.position = new Pos(x,y);
		this.shape = shape;
		this.space = new Pos[4];
		setSpace();
	}
	
	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
		setSpace();
	}
	
	public void setSpace() {
		Pos temp = new Pos(this.position.x, this.position.y);
		space[0] = temp;
		switch (shape) {
		case "I":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x,temp.y+2);
			space[3] = new Pos(temp.x,temp.y+3);
			break;
		case "O":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x,temp.y+1);
			space[3] = new Pos(temp.x+1,temp.y+1);
			break;
		case "Z":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x+1,temp.y+1);
			space[3] = new Pos(temp.x+1,temp.y+2);
			break;
		case "S":
			space[1] = new Pos(temp.x,temp.y-1);
			space[2] = new Pos(temp.x+1,temp.y-1);
			space[3] = new Pos(temp.x+1,temp.y-2);
			break;
		case "J":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+2,temp.y);
			space[3] = new Pos(temp.x+2,temp.y-1);
			break;
		case "L":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+2,temp.y);
			space[3] = new Pos(temp.x+2,temp.y+1);
			break;
		case "T":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x,temp.y+1);
			space[3] = new Pos(temp.x,temp.y-1);
			break;
		case "I_rotate":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+2,temp.y);
			space[3] = new Pos(temp.x+3,temp.y);
			break;
		case "Z_rotate":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y-1);
			space[3] = new Pos(temp.x+2,temp.y-1);
			break;
		case "S_rotate":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y+1);
			space[3] = new Pos(temp.x+2,temp.y+1);
			break;
		case "J_rotate1":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y+1);
			space[3] = new Pos(temp.x+1,temp.y+2);
			break;
		case "J_rotate2":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x+1,temp.y);
			space[3] = new Pos(temp.x+2,temp.y);
			break;
		case "J_rotate3":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x,temp.y+2);
			space[3] = new Pos(temp.x+1,temp.y+2);
			break;
		case "L_rotate1":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x,temp.y+1);
			space[3] = new Pos(temp.x,temp.y+2);
			break;
		case "L_rotate2":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x+1,temp.y+1);
			space[3] = new Pos(temp.x+2,temp.y+1);
			break;
		case "L_rotate3":
			space[1] = new Pos(temp.x,temp.y+1);
			space[2] = new Pos(temp.x,temp.y+2);
			space[3] = new Pos(temp.x-1,temp.y+2);
			break;
		case "T_rotate1":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y-1);
			space[3] = new Pos(temp.x+2,temp.y);
			break;
		case "T_rotate2":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y-1);
			space[3] = new Pos(temp.x+1,temp.y+1);
			break;
		case "T_rotate3":
			space[1] = new Pos(temp.x+1,temp.y);
			space[2] = new Pos(temp.x+1,temp.y+1);
			space[3] = new Pos(temp.x+2,temp.y);
			break;
		}
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static Tetromino[] blocks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		blocks = new Tetromino[19];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		String[] blockNames = {"I","O","Z","S","J","L","T","I_rotate","Z_rotate",
		                       "S_rotate","J_rotate1","J_rotate2","J_rotate3",
		                       "L_rotate1","L_rotate2","L_rotate3","T_rotate1","T_rotate2","T_rotate3"};
		
		{int i=0;
		for (String blockName : blockNames) {
			blocks[i] = new Tetromino(0,0,blockName);
			i++;
		}}
		
		int max = Integer.MIN_VALUE;
		for (Tetromino block : blocks) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int sum = 0;
					block.setPosition(i, j);
					if(isValid(block)){
						for (int k = 0; k < 4; k++) {
							sum+=map[block.space[k].x][block.space[k].y];
						}
					}
					if(max<sum) {
//						System.out.println(block.position.x+","+block.position.y);
//						System.out.println(block.shape);
						max=sum;
					}
				}
			}
		}
		
		System.out.println(max);
	}

	private static boolean isValid(Tetromino block) {
		for (Pos p : block.space) {
			if(p.x<0 || p.x>=N || p.y<0 || p.y>=M) return false;
		}
		return true;
	}

}

