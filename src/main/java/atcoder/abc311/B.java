package atcoder.abc311;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        String plans[] = new String[n];
        for(int i = 0; i < n; i++){
            plans[i] = sc.next();
        }

        int result = 0;
        for(int i = 0; i < d; i++){
            for(int j = i + 1; j <= d; j++) {
                int finalI = i;
                int finalJ = j;
                boolean flag = Arrays.stream(plans).allMatch(s -> {
                    s = s.substring(finalI, finalJ);
                    return s.matches("o*");
                });
                if(flag){
                    result = Math.max(result, j - i);
                }
            }
        }

        System.out.println(result);
    }
}
