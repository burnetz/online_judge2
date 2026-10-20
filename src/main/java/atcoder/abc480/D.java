
package atcoder.abc480;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] a = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        //通常の累積和
        long[] sum1 = new long[n + 1];
        for(int i = 0; i < n; i++) {
            sum1[i + 1] = sum1[i] + a[i];
        }

        //グループごとの要素数の累積和
        long[] sum2 = new long[n];
        sum2[0] = 1;
        for(int i = 1; i < n; i++) {
            sum2[i] = sum2[i - 1] + i + 1;
        }

        //グループごとの合計の累積和
        long[] sum3 = new long[n];
        sum3[0] = a[0];
        for(int i = 1; i < n; i++) {
            sum3[i] = sum3[i - 1] + sum1[i + 1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            //lとrが何番目のグループに属するかを特定する。
            int index1 = Arrays.binarySearch(sum2, l);
            if(index1 < 0) {
                index1++;
                index1 *= -1;
            }

            int index2 = Arrays.binarySearch(sum2, r);
            if(index2 < 0) {
                index2++;
                index2 *= -1;
            }

            long result = 0;

            //lとrに挟まれたグループについて和を求める
            if(index2 - index1 > 1) {
                result += sum3[index2 - 1] - sum3[index1];
            }

            //lが属するグループの当該区間の和
            int beginIndexInFirstGroup = 1;
            if(index1 > 0) {
                beginIndexInFirstGroup = (int)(l - sum2[index1 - 1]);
            }
            result += sum1[index1 + 1] - sum1[beginIndexInFirstGroup - 1];

            //rが属するグループの当該区間の和
            int endIndexInLastGroup = 1;
            if(index2 > 0) {
                endIndexInLastGroup = (int)(r - sum2[index2 - 1]);
            }
            result += sum1[endIndexInLastGroup];

            //lとrが同じグループの場合はここまでの計算を破棄
            if(index1 == index2) {
                result = sum1[endIndexInLastGroup] - sum1[beginIndexInFirstGroup - 1];
                sb.append(result).append("\n");
                continue;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}