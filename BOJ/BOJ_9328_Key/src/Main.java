import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos{
    int x;
    int y;

    public Pos(int i, int j) {
        this.x = i;
        this.y = j;
    }
}

public class Main {
    static int H;
    static int W;
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] xdir = {0, 0, 1, -1};
    static int[] ydir = {1, -1, 0, 0};
    static Map<Character, List<Pos>> gates = new HashMap<>();
    static boolean[] keys;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {


            String[] input = br.readLine().split(" ");
            H = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            map = new char[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            answer = 0;
            keys = new boolean[26];
            for (int i = 0; i < 26; i++) {
                gates.put((char) ('A' + i), new ArrayList<>());
            }

            for (int i = 0; i < H+2; i++) {
                for (int j = 0; j < W+2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= H; i++) {
                String in = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = in.charAt(j-1);
                }
            }

            String in = br.readLine();
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) != '0') {
                    keys[in.charAt(i) - 'a'] = true;
                }
            }

            bfs(0, 0);
            System.out.println(answer);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + xdir[k];
                int ny = y + ydir[k];

                if (nx < 0 || ny < 0 || nx >= H + 2 || ny >= W + 2) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;

                if (map[nx][ny] == '.') {
                    q.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == '$') {
                    answer++;
                    q.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    keys[map[nx][ny] - 'a'] = true;
                    q.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                    if(gates.get((char) (map[nx][ny] - 'a' + 'A')).size() != 0) {
                        List<Pos> list = gates.get((char) (map[nx][ny] - 'a' + 'A'));
                        for (int l = 0; l < list.size(); l++) {
                            Pos p = list.get(l);
                            q.add(new Pos(p.x, p.y));
                            visited[p.x][p.y] = true;
                        }
                        gates.get((char) (map[nx][ny] - 'a' + 'A')).clear();
                    }
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    if (keys[map[nx][ny] - 'A']) {
                        q.add(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    } else {
                        gates.get(map[nx][ny]).add(new Pos(nx, ny));
                    }
                }
            }
        }
    }
}


