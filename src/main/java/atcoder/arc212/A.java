package atcoder.arc212;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int mod = 998244353;

        long result = 0;
        //サイクルを残すために消せる辺の組み合わせは
        //{(1,2),(3,4)},{(1,3),(2,4)},{(1,4),(2,3)}の3つしか存在しない。
        //そのことに気づけばこの3つに辺の重みをいくら割り当てるかという問題になりO(N^2)で解ける。
        for(int i = 2; i < k; i++) {
            for(int j = 2; j + i < k; j++) {
                int l = k - i - j;
                //あり得るグラフ数。-1となっているのは辺の重みを0にするような割り当て方ができないため。
                long num = (long)(i - 1) * (j - 1) * (l - 1);
                //最も重いグループが削除される。
                long weight = k - Math.max(i, Math.max(j, l));

                result += num * weight;
                result %= mod;
            }
        }

        System.out.println(result);
    }
}
