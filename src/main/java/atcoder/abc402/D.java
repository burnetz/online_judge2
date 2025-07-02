package atcoder.abc402;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Long, Integer> map = new HashMap<>();
        long result = (long)m*(m - 1)/2;

        //直線の傾きについて出現回数をマップで管理する。
        //調整次第では意外となんとかなる。
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            double theta1 = a * 2 * Math.PI / n;
            double theta2 = b * 2 * Math.PI / n;

            double x1 = Math.cos(theta1);
            double y1 = Math.sin(theta1);
            double x2 = Math.cos(theta2);
            double y2 = Math.sin(theta2);

            double dx = x1 - x2;
            double dy = y1 - y2;

            double angle = Math.atan(dy/dx);
            //y軸と平行な場合、dyの符号次第でキーが分かれてしまうのでプラスに統一する。
            if(Math.abs(dx) < 0.0000001) {
                angle = Math.abs(angle);
            }
            long angleKey = (long)(angle * 1_000_000_000L);

            map.merge(angleKey, 1, (n1, n2) -> n1 + 1);
            int tmp = map.get(angleKey);

            //重複が判明したら随時結果から引いていく
            result -= tmp - 1;

        }

        System.out.println(result);
    }
}