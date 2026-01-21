package atcoder.abc432;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        //答えとしてあり得る最大値。実際、条件を満たす組み合わせがあるなら各人ごとの重さの合計をこの値にできる。
        long amount = (long)a[0] * y;
        long result = a[0];

        for(int i = 1; i < n; i++) {
            long diff = (long)a[i] * y - amount;

            if(diff == 0) {
                result += a[i];
                continue;
            }

            //(y-x)ずつしか合計を減らすことができないので、差分が(y-x)の倍数でないときは不可
            if(diff % (y - x) != 0) {
                System.out.println(-1);
                return;
            }

            //倍数であっても元々の所持数よりも多く減らさなければいけない場合は不可
            long times = diff / (y - x);
            if(times > a[i]) {
                System.out.println(-1);
                return;
            }

            result += a[i] - times;
        }

        System.out.println(result);
    }
}