package atcoder.arc222;

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
        int m = sc.nextInt();

        int maxSize = 0;
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();

            maxSize = Math.max(maxSize, b - a);
        }

        //最も長い区間の長さをXとすると、その区間内では1からXまでの数字を1回ずつ使うのが最適。
        //他の区間はそれより短いので、1からXを常にローテーションすれば条件を満たすことができる。
        for(int i = 0; i < n; i++) {
            System.out.print((i % maxSize + 1) + " ");
        }
        System.out.println();

    }
}