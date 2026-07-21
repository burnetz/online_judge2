package atcoder.arc219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long result = 0;
        int mod = 998244353;
        //まず、作りたいPの先頭が1でないとルール上QをどういじってもPにならない。
        //逆に先頭が1なら区間(1,r)を反転させることでQ'=PにできるようなQがn-1種類存在する。
        //更にPの先頭が1,2なら更にQのパターン数は増える。
        for(int i = 0; i < n; i++) {
            if(a[i] != i + 1) {
                break;
            }

            //ここに来るのはPが昇順に並んでいるとき。このときQ'=P=Qであるパターンを追加する。
            if(i == n - 1) {
                result++;
            }
            else {
                result += n - i - 1;
            }
            result %= mod;
        }

        System.out.println(result);
    }

}
