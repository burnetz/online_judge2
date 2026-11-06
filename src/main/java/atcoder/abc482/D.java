
package atcoder.abc482;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(0);
            return;
        }
        int[] x = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //基本的にはまずパートナーを一人見つけてその後自分とパートナーが逆方向に進むのが最適。
        //どちらの最寄りをパートナーにするべきかは両方試さないと分からない。
        for(int i = 0; i < n; i++) {
            int resultFirstLeft = 1_000_000_001;
            int resultFirstRight = 1_000_000_001;

            if(i > 0) {
                resultFirstLeft = (x[i] - x[i - 1]) / 2 + Math.max((x[i - 1] - x[0]) / 2, (x[n - 1] - x[i]) / 2);

            }

            if(i < n - 1) {
                resultFirstRight = (x[i + 1] - x[i]) / 2 + Math.max((x[n - 1] - x[i + 1]) / 2, (x[i] - x[0]) / 2);
            }

            System.out.println(Math.min(resultFirstLeft, resultFirstRight));
        }
    }
}