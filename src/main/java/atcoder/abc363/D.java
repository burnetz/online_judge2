package atcoder.abc363;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        //やや面倒なので結果が0〜9になるものは特別扱い
        if(n <= 10) {
            System.out.println(n - 1);
            return;
        }
        //それぞれの桁数における回文の数（累積ではない）
        long numOfPalindron[] = new long[100];

        numOfPalindron[1] = 10;
        numOfPalindron[2] = 9;

        for(int i = 3; i < 100; i++) {
            if(i % 2 == 1) {
                //1桁小さいものの間に0〜9を挿入すれば作れる
                numOfPalindron[i] = numOfPalindron[i - 1] * 10;
            }
            else {
                //1桁小さいものと全く同じ個数になる
                numOfPalindron[i] = numOfPalindron[i - 1];
            }
        }

        n -= numOfPalindron[1];
        //桁数を確定させる
        for(int i = 2; ; i++) {
            if(n <= numOfPalindron[i]) {
                if(i % 2 == 0) {
                    int numOfBaseDigit = i / 2;

                    long baseNum = (long)Math.pow(10, numOfBaseDigit - 1) + n - 1;

                    String str = Long.toString(baseNum);
                    StringBuffer sb = new StringBuffer(str).reverse();

                    System.out.println(str + sb);
                    return;
                }
                else {
                    int numOfBaseDigit = i / 2 + 1;
                    long baseNum = (long)Math.pow(10, numOfBaseDigit - 1) + n - 1;

                    String str = Long.toString(baseNum);
                    //真ん中の数字が重複しないよう気をつける
                    StringBuffer sb = new StringBuffer(str.substring(0, str.length() - 1)).reverse();

                    System.out.println(str + sb);

                    return;
                }
            }

            n -= numOfPalindron[i];
        }
    }
}