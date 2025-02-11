import java.util.Scanner;

public class Main {
    public static final int SHIFT_LEFT = 1;
    public static final int SHIFT_RIGHT = 0;
    public static final int MAX_M = 100;
    public static final int MAX_N = 100;
    
    public static int n, m, q;
    
    public static int[][] a = new int[MAX_N + 1][MAX_M + 1];
    
    public static void shift(int row, int dir) {
        // 오른쪽으로 밀어야 하는 경우
        if(dir == SHIFT_RIGHT) {
            int temp = a[row][m];
            for(int col = m; col >= 2; col--)
                a[row][col] = a[row][col - 1];
            a[row][1] = temp;
        }
        else {
            int temp = a[row][1];
            for(int col = 1; col <= m - 1; col++)
                a[row][col] = a[row][col + 1];
            a[row][m] = temp;
        }
    }
    
    public static boolean hasSameNumber(int row1, int row2) {
        for(int col = 1; col <= m; col++)
            if(a[row1][col] == a[row2][col])
                return true;
        
        return false;
    }
    
    public static int flip(int dir) {
        return (dir == SHIFT_LEFT) ? SHIFT_RIGHT : SHIFT_LEFT;
    }
    public static void simulate(int startRow, int startDir) {
        shift(startRow, startDir);
    
        startDir = flip(startDir);
    
        for(int row = startRow, dir = startDir; row >= 2; row--) {
            if(hasSameNumber(row, row - 1)) {
                shift(row - 1, dir);
                dir = flip(dir);
            }
            else
                break;
        }
        for(int row = startRow, dir = startDir; row <= n - 1; row++) {
            if(hasSameNumber(row, row + 1)) {
                shift(row + 1, dir);
                dir = flip(dir);
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        
        for(int row = 1; row <= n; row++)
            for(int col = 1; col <= m; col++)
                a[row][col] = sc.nextInt();
        
        while(q-- > 0) {
            int r;
            char d;
            r = sc.nextInt();
            d = sc.next().charAt(0);

            simulate(r, d == 'L' ? SHIFT_RIGHT : SHIFT_LEFT);
        }

        // 출력:
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= m; col++)
                System.out.print(a[row][col] + " ");
            System.out.println();
        }
    }
}
