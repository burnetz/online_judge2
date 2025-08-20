package atcoder.arc203;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            //各グループから2名ずつ選出した場合、
            //うまく勝敗を決めれば2N人中最大N人が全勝できる。
            //つまり各グループから全勝する人と全敗する人を1人ずつ選ぶということ。
            long result = (long)m / 2 * n;

            //Mが奇数の場合、更に1人だけ全勝できる。
            if(m % 2 == 1) {
                result++;
            }

            System.out.println(result);
        }
    }
}
