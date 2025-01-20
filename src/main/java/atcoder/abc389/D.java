package atcoder.abc389;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        long result = 0;

        //-r + 1 <= y <= r - 1の区間では円の内側の正方形が最低1つは存在する。
        //2分探索を用いて条件を満たす正方形のx座標の最大値を求める。
        for(int i = -r + 1; i <= r - 1; i++) {
            int min = -1;
            int max = Integer.MAX_VALUE / 2;

            while (max - min > 1) {
                int mid = (min + max) / 2;

                if(isInCircle(mid, i, r)) {
                    min = mid;
                }
                else {
                    max = mid;
                }
            }

            //左右対称を考慮して加算する。
            result += min * 2 + 1;
        }

        System.out.println(result);
    }

    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    static boolean isInCircle(double centerX, double centerY, int r) {
        return distance(0, 0, centerX + 0.5, centerY + 0.5) <= r &&
                distance(0, 0, centerX + 0.5, centerY - 0.5) <= r &&
                distance(0, 0, centerX - 0.5, centerY + 0.5) <= r &&
                distance(0, 0, centerX - 0.5, centerY - 0.5) <= r;
    }
}