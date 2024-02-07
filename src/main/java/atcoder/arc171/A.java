package atcoder.arc171;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            solve(n, a, b);
        }
    }

    static void solve(int n, int a, int b) {
        int n2 = n - a;

        //行数よりもルークが多い時点で不可能
        if(n2 < 0) {
            System.out.println("No");
            return;
        }

        //分かりやすさのため偶数番目（0, 2, ...）の行にしかポーンを置かないことにする。
        int even = (n + 1) / 2;
        //ルークをまずは奇数行、余ったルークを偶数行に配置するのが最適。
        //その結果偶数行がいくつ空くかを考える。
        int blankEven = even - Math.max(a - (n - even), 0);

        if (blankEven * n2 >= b) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
