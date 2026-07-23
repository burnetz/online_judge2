package atcoder.abc429;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong();
        int c = sc.nextInt();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();

        Vector<Long> vec = new Vector<>();

        for(int i = 0; i < n; i++) {
            vec.add(a[i]);
        }

        //2周分を一直線として考えると解きやすい。
        for(int i = 0; i < n; i++) {
            vec.add(a[i] + m);
        }
        //番兵用
        vec.add(2L*c);

        int l = 0;
        int r = 1;

        long result = 0;
        //問題通りに座標ごとに計算すると間に合わない。
        //Mに比べるとNは遥かに小さいので人を基準に区間を決める。
        while(l < n) {
            while(r - l < c) {
                r++;
            }
            //r番目の次は必ずもっと大きな座標になるように調整
            while(Objects.equals(vec.get(r), vec.get(r - 1))) {
                r++;
            }

            //区間内の人数
            int x = r - l;

            //l - 1番目は必ずl番目より座標が小さくなるよう調整済み。
            //この場合、区間の下端が(l - 1番目の座標) + 1からl番目の座標までは含まれる人数が変わらない。
            if(l == 0) {
                result += (vec.get(l) - (vec.get(n - 1) - m)) * x;
            }
            else {
                result += (vec.get(l) - vec.get(l - 1)) * x;
            }

            int currentL = l;
            while(Objects.equals(vec.get(l), vec.get(currentL))) {
                l++;
            }
        }

        System.out.println(result);

    }
}