package atcoder.abc364;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        double[] a = Arrays.stream(new double[n]).map(e -> sc.nextInt()).sorted().toArray();

        for(int i = 0; i < q; i++) {
            int b = sc.nextInt();
            int k = sc.nextInt();

            int l = -1;
            int r = 200_000_001;

            //bを中心にaの要素をギリギリk個以上含む距離を二分探索で求める。
            //upper_boundとlower_boundを両方行えば可能。
            while(r - l > 1) {
                int mid = (l + r) / 2;

                int lowerIndex = Arrays.binarySearch(a, b - mid - 0.5);
                lowerIndex++;
                lowerIndex *= -1;

                int higherIndex = Arrays.binarySearch(a, b + mid + 0.5);
                higherIndex++;
                higherIndex *= -1;

                if(higherIndex - lowerIndex >= k) {
                    r = mid;
                }
                else {
                    l = mid;
                }
            }

            System.out.println(r);
        }
    }
}