package atcoder.abc318;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        long p = sc.nextInt();

        long fee[] = new long[n];
        for(int i = 0; i < n; i++) {
            fee[i] = sc.nextLong();
        }

        Arrays.sort(fee);

        //割引券を使うタイミングは任意なのだから明らかに高いときに使ったほうが良い。
        long sum = 0;
        for(int i = n - 1; i >= 0;) {
            long tmpSum = 0;
            for(int j = i; j >= Math.max(0, i - d + 1); j--) {
                tmpSum += fee[j];
            }
            sum += Math.min(tmpSum, p);
            i -= d;
        }

        System.out.println(sum);
    }
}
