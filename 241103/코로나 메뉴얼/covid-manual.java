import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emer = 0;
        for(int i=0;i<3;i++){
            String symptom = sc.next();
            int temp = sc.nextInt();
            if (symptom == "Y" && temp >= 37)
                emer++;
        }
        if (emer >= 2) 
            System.out.print("E");
        else
            System.out.print("N");
        
    }
}