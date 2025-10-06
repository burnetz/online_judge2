package atcoder.abc426;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int count[] = new int[n + 1];
        Arrays.fill(count, 1);
        count[0] = 0;
        //明らかにアップグレード済みのバージョンはチェックしないようにする
        int lowest = 1;

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum = 0;
            for(int j = lowest; j <= x; j++) {
                sum += count[j];
                count[j] = 0;
            }

            System.out.println(sum);
            count[y] += sum;
            //２重ループだがlowestが単調増加なので間に合う
            lowest = Math.max(lowest, x + 1);

        }
    }
}