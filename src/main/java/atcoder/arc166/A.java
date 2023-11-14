package atcoder.arc166;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String str1 = sc.next();
            String str2 = sc.next();

            boolean result = solve(n, str1, str2);
            System.out.println(result ? "Yes" : "No");
        }
    }

    static boolean solve(int n, String str1, String str2) {
        str1 += 'C';
        str2 += 'C';
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        //Cを横に動かすことはできない。新たにCを作ることもできない。
        //そのため両方の文字列でCになっている箇所を区切りとし
        //各区間を個別に一致させられるか考える。
        int start = 0;
        int end = 0;
        for(int i = 0; i <= n; i++){
            if(array1[i] == 'C' && array2[i] == 'C') {
                end = i;
                if(!solve2(array1, array2, start, end)) {
                    return false;
                }
                start = i + 1;
            }
        }

        return true;
    }
    static boolean solve2(char[] str1, char[] str2, int start, int end) {
        int a1 = 0;
        int a2 = 0;
        int b1 = 0;
        int b2 = 0;
        for(int i = start; i < end; i++) {
            //この関数に入っている時点でstr1[i]はCではないので
            //もしstr2[i]がCなら一致させるのは不可能になる。
            if(str2[i] == 'C') {
                return false;
            }
            if(str1[i] == 'A') {
                a1++;
            }
            if(str2[i] == 'A') {
                a2++;
            }
            if(str1[i] == 'B') {
                b1++;
            }
            if(str2[i] == 'B') {
                b2++;
            }
        }

        if(a1 > a2 || b1 > b2) {
            return false;
        }

        //str2の方がAを多く含んでいる場合
        //str1のCをAに置き換えて一致させられるか試す。
        if(a1 < a2) {
            int tmpA1 = a1;
            //Aはなるべく左から埋めていく。
            //スワップで必要に応じて右に持っていくことは可能であるため。
            for(int i = start; i < end; i++) {
                if(str1[i] == 'C' && str2[i] != 'C') {
                    str1[i] = 'A';
                    tmpA1++;
                    if(tmpA1 == a2) {
                        break;
                    }
                }

                //この方法で個数が合わないなら一致させることは不可能
                if(i == end - 1) {
                    return false;
                }
            }
        }
        if(b1 < b2) {
            int tmpB1 = b1;
            //同様に、Bはなるべく右から埋める。
            for(int i = end - 1; i >= start; i--) {
                if(str1[i] == 'C' && str2[i] != 'C') {
                    str1[i] = 'B';
                    tmpB1++;
                    if(tmpB1 == b2) {
                        break;
                    }
                }

                if(i == 0) {
                    return false;
                }
            }
        }

        b1 = 0;
        b2 = 0;
        for(int i = start; i < end; i++) {
            if(str1[i] == 'B') {
                b1++;
            }
            if(str2[i] == 'B') {
                b2++;
            }

            //Bは左に持っていくことはできるが右には移動できない。
            //そのため途中でstr1で見たBの数の方が多くなったら一致は不可能。
            if(b1 > b2) {
                return false;
            }

            if(i == end - 1) {
                if(b1 != b2) {
                    return false;
                }
            }
        }
        return true;
    }

}