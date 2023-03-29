import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;
    boolean deleted;
    Shark(String[] info) {
        this.r = Integer.parseInt(info[0])-1;
        this.c = Integer.parseInt(info[1])-1;
        this.s = Integer.parseInt(info[2]);
        this.d = Integer.parseInt(info[3]);
        this.z = Integer.parseInt(info[4]);
        this.deleted = false;
    }
}
public class Main {
    static int R;
    static int C;
    static int M;
    static Shark[] sharks;
    static Shark[][] map;
    static int answer;
    static int[] xdir={0,-1,1,0,0};
    static int[] ydir={0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);
        sharks = new Shark[M];
        map = new Shark[R][C];
        int fisher = -1;

        for (int i = 0; i < M; i++) {
            sharks[i] = new Shark(br.readLine().split(" "));
        }

        for (int time = 0; time < C; time++) {
//            System.out.println(fisher+","+answer);
            makeMap();
//            printMap();
            fisher++;
            catchShark(fisher);
            moveShark();
        }

        System.out.println(answer);
    }

    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]==null || map[i][j].deleted) System.out.print(0+" ");
                else System.out.print(map[i][j].z+" ");
            }
            System.out.println();
        }
    }

    private static void moveShark() {
        for (int i = 0; i < M; i++) {
            Shark s = sharks[i];
            if(!s.deleted) {
                map[s.r][s.c]=null;
                for (int j = 0; j < s.s; j++) {
                    boolean changeDirection = false;
                    s.r+=xdir[s.d];
                    if( s.r<0 || s.r>=R ) {
                        s.r-=2*xdir[s.d];
                        changeDirection=true;
                    }
                    s.c+=ydir[s.d];
                    if( s.c<0 || s.c>=C ) {
                        s.c-=2*ydir[s.d];
                        changeDirection=true;
                    }
                    if(changeDirection) {
                        if (s.d%2==0) s.d-=1;
                        else s.d+=1;
                    }
                }
            }
        }
    }

    private static void catchShark(int fisher) {
        for (int i = 0; i < R; i++) {
            if(map[i][fisher]!=null && !map[i][fisher].deleted) {
                answer+=map[i][fisher].z;
                map[i][fisher].deleted = true;
                break;
            }
        }
    }

    private static void makeMap() {
        for (int i = 0; i < M; i++) {
            if(!sharks[i].deleted){
                if(map[sharks[i].r][sharks[i].c]==null || map[sharks[i].r][sharks[i].c].deleted) {
                    map[sharks[i].r][sharks[i].c] = sharks[i];
                }
                else if(!map[sharks[i].r][sharks[i].c].deleted) {
                    if(map[sharks[i].r][sharks[i].c].z<sharks[i].z) {
                        map[sharks[i].r][sharks[i].c].deleted = true;
                        map[sharks[i].r][sharks[i].c] = sharks[i];
                    } else {
                        sharks[i].deleted = true;
                    }
                }
            }
        }
    }
}