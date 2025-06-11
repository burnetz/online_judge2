package atcoder.abc409;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        //辺を3等分できないならそもそも作れない
        if(l % 3 != 0) {
            System.out.println(0);
            return;
        }

        int count[] = new int[l];
        count[0] = 1;

        int prev = 0;
        //各座標ごとに登場回数を数える
        for(int i = 1; i < n; i++) {
            int tmp = sc.nextInt();

            prev = (prev + tmp) % l;
            count[prev]++;
        }

        long result = 0;
        for(int i = 0; i < l / 3; i++) {
            result += (long)count[i] * count[i + l / 3] * count[i + 2 * l / 3];
        }

        System.out.println(result);
    }
}