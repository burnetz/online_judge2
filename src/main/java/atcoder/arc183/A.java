package atcoder.arc183;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        //nが偶数のときは前半グループの一番最後の数列を作る。
        if(n % 2 == 0) {
            StringBuffer sb = new StringBuffer();

            sb.append(n / 2 + " ");

            for(int i = n ; i >= 1; i--) {
                for(int j = 0; j < k; j++) {
                    if(i == n / 2 && j >= k - 1) {
                        continue;
                    }
                    sb.append(i + " ");
                }
            }

            System.out.println(sb);
        }
        //nが奇数のときはまず(n+1)/2を全て使い切る。
        //その後は残りの数字の種類が偶数個になるので偶数のときと同じ考え方を使う。
        else {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < k; i++) {
                sb.append((n + 1) / 2 + " ");
            }

            if(n != 1) {
                sb.append((n - 1) / 2 + " ");

                for(int i = n ; i >= 1; i--) {
                    if(i == (n + 1) / 2) {
                        continue;
                    }
                    for(int j = 0; j < k; j++) {
                        if(i == (n - 1) / 2 && j >= k - 1) {
                            continue;
                        }
                        sb.append(i + " ");

                    }
                }
            }

            System.out.println(sb);
        }
    }
}
