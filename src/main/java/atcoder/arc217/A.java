package atcoder.arc217;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        //例で与えられているN=7の場合、1,3,2,4,5,7,6でも最適となる。
        //大まかには小さい順だが、2k+1の次は2k+3にすることで最下位ビットの無駄を防ぐことができる。
        int offset[] = {0, 1, -1, 0};

        int count = 0;
        for(int i = 0; count < n ; i++) {
            int tmp = i + offset[i % 4] + 1;

            if(tmp <= n) {
                System.out.print(tmp + " ");
                count++;
            }
        }
        System.out.println();
    }
}
