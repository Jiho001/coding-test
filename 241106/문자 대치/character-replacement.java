import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String result = "";
        if(input.indexOf(0) == '.') {
            result += ".";
            int dotCount = -1;
        }
        int count = 0;
        int dotCount = 0;
        List<Integer> xCountList = new ArrayList<>();
        List<Integer> dotIndexList = new ArrayList<>();
        for(int i = 0; i<input.length(); i++){
            char c = input.charAt(i);
            if (c == 'X') {
                count++;
            } else if (c == '.') {
                    if (count % 2 == 1 && count != 1) {
                        System.out.print(-1);
                        return;
                    }
                    dotCount++;
                    xCountList.add(count);
                    count = 0;
            }
            if(i==input.length()-1){
                if(count%2 == 1){
                    System.out.print(-1);
                    return;
                }
            }
            if(i==input.length()-1){
                xCountList.add(count);
            }
        }

        for(int i=0;i<dotCount+1;i++){
            int c = xCountList.get(i);
            String a = repeatString("a", (c/4) *4);
            String b = repeatString("b", c%4);
            if(i!=dotCount){
                result = result + a + b + '.';
            } else{
                result = result + a + b;
            }
        }
        System.out.println(result);
    }
    public static String repeatString(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}