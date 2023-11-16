package atcoder.abc328;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        for(int i = 1; i <= n; i++) {
            int d = sc.nextInt();

            for(int j = 1; j <= d; j++) {
                String date = i + "" + j;

                boolean ok = true;
                for(int k = 1; k < date.length(); k++) {
                    if(date.charAt(k - 1) != date.charAt(k)) {
                        ok = false;
                        break;
                    }
                }

                if(ok) {
                    result++;
                }
            }

        }
        System.out.println(result);
    }
}
