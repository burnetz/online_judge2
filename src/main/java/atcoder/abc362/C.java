package atcoder.abc362;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long l = 0;
        long r = 0;

        long left[] = new long[n];
        long right[] = new long[n];

        for(int i = 0; i < n; i++) {
            long tmpL = sc.nextLong();
            long tmpR = sc.nextLong();

            l += tmpL;
            r += tmpR;

            left[i] = tmpL;
            right[i] = tmpR;
        }

        //0を作れるかどうかの判断自体は簡単。問題は具体的な数列の作成。
        if(l <= 0 && 0 <= r) {
            System.out.println("Yes");

            //最終的にありえる最小値が0からどれだけ離れているかを計算し、
            //それを最初の区間から順に割り振れるだけ割り振る。
            long diff = 0 - l;
            for(int i = 0 ; i < n; i++) {
                long d = Math.min(right[i] - left[i], diff);
                System.out.print(left[i] + d + " ");

                diff -= d;
            }
        }
        else {
            System.out.println("No");
        }
    }
}