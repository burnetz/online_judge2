package atcoder.arc106;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //Nが2以下のときはどちらの解き方でも差が出ないので
        //M=0のとき以外は解なし
        if(n <= 2) {
            if(m == 0) {
                //どのような区間でもよい
                for(int i = 1; i <= n ; i++) {
                    System.out.println(2*i + " " + (2*i + 1));
                }
            }
            else {
                System.out.println(-1);
            }
            return;
        }

        //青木くんの方が大きくなる方法はないのでM < 0は全て解なし。
        //また、M=NまたはM=N-1だと後述の方法が使えないので解なし。
        if(m < 0 || m > n - 2) {
            System.out.println(-1);
            return;
        }

        //M=0ならば全く被りのない区間をN個作るだけでよい。
        //差を出すためには被りのない小さな区間を大きな区間で覆うことで実現できる。
        for(int i = 1; i <= m + 1; i++) {
            System.out.println(2*i + " " + (2*i + 1));
        }
        System.out.println("1 1000000");

        //余った個数分の被りのない区間を適当に作る。
        for(int i = 1; i <= n - m - 2; i++) {
            System.out.println((2*i + 1000000) + " " + (2*i + 1000001));
        }
    }

}