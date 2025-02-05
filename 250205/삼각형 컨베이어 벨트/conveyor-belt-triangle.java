import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200;
    
    public static int n, t;
    
    public static int[] l = new int[MAX_N + 1];
    public static int[] r = new int[MAX_N + 1];
    public static int[] d = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            l[i] = sc.nextInt();

         for(int i = 0; i < n; i++)
            r[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
            
        while(t-- > 0) {
            int temp = l[n - 1];
            
            for(int i = n - 1; i >= 1; i--)
                l[i] = l[i - 1];
            l[0] = d[n - 1];
            
            int temp2 = r[n - 1];
            for(int i = n - 1; i >= 1; i--)
                r[i] = r[i - 1];
            r[0] = temp;

            for(int i = n - 1; i >= 1; i--)
                d[i] = d[i - 1];
            d[0] = temp2;
        }

        for(int i = 0; i < n; i++)
            System.out.print(l[i] + " ");
        System.out.println();
        
        for(int i = 0; i < n; i++)
            System.out.print(r[i] + " ");
        System.out.println();

        for(int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
    }
}
