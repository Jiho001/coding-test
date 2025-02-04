import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200;

    public static int n, t;

    public static int[] u = new int[MAX_N + 1];
    public static int[] d = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            u[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
            
        while(t-- > 0) {
            int temp = u[n - 1];
            
            for(int i = n - 1; i >= 1; i--)
                u[i] = u[i - 1];
            u[0] = d[n - 1];
            
            for(int i = n - 1; i >= 1; i--)
                d[i] = d[i - 1];
            d[0] = temp;
        }

        for(int i = 0; i < n; i++)
            System.out.print(u[i] + " ");
        System.out.println();
        
        for(int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
        System.out.println();
    }
}
