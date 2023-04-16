import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        sudoku(0, 0);
    }

    private static void sudoku(int x, int y) {
        if (map[x][y]==0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    if (x == 8 && y == 8) {
                        print();
                        System.exit(0);
                    } else {
                        if (y == 8) {
                            sudoku(x + 1, 0);
                        } else {
                            sudoku(x, y + 1);
                        }
                    }
                    map[x][y] = 0;
                }
            }
        } else {
            if (x == 8 && y == 8) {
                print();
                System.exit(0);
            } else {
                if (y == 8) {
                    sudoku(x + 1, 0);
                } else {
                    sudoku(x, y + 1);
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean check(int x, int y, int i) {
        for (int j = 0; j < 9; j++) {
            if (map[x][j] == i) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (map[j][y] == i) {
                return false;
            }
        }
        int x1 = (x / 3) * 3;
        int y1 = (y / 3) * 3;
        for (int j = x1; j < x1 + 3; j++) {
            for (int k = y1; k < y1 + 3; k++) {
                if (map[j][k] == i) {
                    return false;
                }
            }
        }

        return true;
    }
}