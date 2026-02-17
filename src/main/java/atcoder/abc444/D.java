package atcoder.abc444;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int MAX_LEN = 200_000;
        int[] numByLength = new int[MAX_LEN + 1];
        for(int i = 0; i < n; i++) {
            numByLength[a[i]]++;
        }

        //a[]に含まれるi桁以上の数の個数
        int[] numByLengthSum = new int[MAX_LEN + 2];
        for(int i = MAX_LEN ; i >= 1; i--) {
            numByLengthSum[i] = numByLengthSum[i + 1] + numByLength[i];
        }

        StringBuffer sb = new StringBuffer();
        //文字列のまま各桁ごとに数字を確定させる。繰り上がりに注意
        long up = 0;
        for(int i = 1; i <= MAX_LEN; i++) {
            long tmp = numByLengthSum[i] + up;
            sb.append(tmp % 10);
            up = tmp / 10;
        }

        sb.reverse();

        if(up != 0) {
            sb.insert(0, up);
        }

        String str = sb.toString();
        //大体の場合0から始まるので余計な0を出さないようにする。
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0') {
                System.out.println(str.substring(i));
                return;
            }
        }
    }
}