package atcoder.abc422;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        //A_Cのペアをいくつ作れるか。この時点でAとCのうち高々一方が余る。
        long nAC = Math.min(a, c);
        long remainA = a - nAC;
        long remainC = c - nAC;

        long result = 0;
        //Bの用途はABCを作ること以外に無いので早い段階で使う。仮にBが余っても今後考えない。
        long nABC = Math.min(nAC, b);
        //Bを消費してもなお余ったA_C
        long remainAC = nAC - nABC;
        result += nABC;

        //序盤の工程で余ったAもしくはCを全て使う。
        long nABC2 = Math.min(remainAC, Math.max(remainA, remainC));
        remainAC -= nABC2;
        result += nABC2;
        //それでもA_Cが余った場合、A_Cを崩すことで更にAACやACCを作ることができる。
        result += remainAC*2/3;

        System.out.println(result);

    }
}