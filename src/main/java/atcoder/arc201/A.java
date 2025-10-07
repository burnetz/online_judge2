package atcoder.arc201;

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

        //div1のために極振りした場合何セット作れるか
        long div1Max = 0;
        //その余りで何セットdiv2を作れるか
        long div2Min = 0;
        //極振りした状態からdiv2のために何セットのdiv1を削れるか
        long free = 0;

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int tmpDiv1 = Math.min(a, b);
            int tmpDiv2 = Math.min(b - tmpDiv1, c);

            div1Max += tmpDiv1;
            div2Min += tmpDiv2;

            int tmpFree = Math.min(tmpDiv1, Math.min(b - tmpDiv2, c - tmpDiv2));
            free += tmpFree;
        }

        //div1極振りでもdiv2の方が多いなら融通する必要はない。
        if(div1Max < div2Min) {
            System.out.println(div1Max);
        }
        else {
            //div1上限とdiv2下限の間が理想だが、不可能ならfreeの分だけ融通した後のセット数
            long result = Math.min((div1Max + div2Min) / 2, div2Min + free);

            System.out.println(result);
        }
    }

}
