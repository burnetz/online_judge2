package atcoder.arc185;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long sum = (long)n * (n + 1) / 2;

            long tmp = 2 * sum % m;
            //BobからするとAliceを詰ませることができるのはAliceのカードが残り1枚のときだけ。
            //Aliceがラスト1枚でmodが0になるためにはBobはtmpのカードを手元に残せば良い。
            //逆にそのようなカードが存在しない場合は詰ませることができない。
            if(tmp <= n && tmp > 0) {
                System.out.println("Bob");
            }
            else {
                System.out.println("Alice");
            }
        }
    }
}
