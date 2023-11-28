package atcoder.abc330;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long d = sc.nextLong();

        long result = Long.MAX_VALUE;

        //xとyを全パターン試すことはできないので
        //xに応じてyはある程度当たりをつける。
        for(int i = 0; i <= 1_000_000; i++) {
            int tmpY = (int)Math.sqrt(d - (long)i*i);

            for(int j = Math.max(0, tmpY - 2); j <= tmpY + 2; j++) {
                result = Math.min(result, Math.abs((long)i * i + (long)j * j - d));
            }
        }

        System.out.println(result);
    }
}
