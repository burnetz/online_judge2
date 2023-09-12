package atcoder.abc319;

import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            int tmp = -1;
            for(int j = 1; j <= 9; j++) {
                if(n % j == 0 && i % (n / j) == 0) {
                    tmp = j;
                    break;
                }
            }

            if(tmp < 0) {
                System.out.print("-");
            }
            else {
                System.out.print(tmp);
            }
         }

    }
}
