package atcoder.arc179;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long a[] = Arrays.stream(new long[n]).map(e-> sc.nextLong()).sorted().toArray();

        long nonNegSum = 0;
        long negSum = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] >= 0) {
                nonNegSum += a[i];
            }
            else {
                negSum += a[i];
            }
        }

        //kが0以下のときは合計によって可否が決まる。
        //もし合計がk未満だと、累積和の先頭が0にもかかわらず後で必ずk未満の累積和が発生することになる。
        if(k <= 0 && nonNegSum + negSum < k) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
        for(int i = 0; i < n; i++) {
            //kが正の場合は素直にソート済みの配列を表示すればよい。
            //（a[i]>=0になって以降は累積和が単調増加なので）
            if(k > 0) {
                System.out.print(a[i] + " ");

            }
            //kが0以下の場合、累積和の先頭が0である都合上ここから先もk以上にしかできないので
            //逆順にして十分大きな累積和を維持させる。
            else {
                System.out.print(a[n - i - 1] + " ");
            }
        }
    }
}
