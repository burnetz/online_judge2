package atcoder.abc441;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long x = sc.nextLong();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        long sum = 0;

        //とりあえず大きい順にカップを選び続けるのが最適。
        //この方法で高橋くんにとって最悪なのは小さいカップK個に酒が入っているパターン。
        for(int i = k - 1; i >= 0; i--) {
            sum += a[i];

            if(sum >= x) {
                int result = (n - k) + (k - i);
                System.out.println(result);
                return;
            }
        }

        System.out.println(-1);

    }
}