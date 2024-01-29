package atcoder.abc338;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int q[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int b[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int result = 0;
        //料理Aをi人分作る
        for(int i = 0; ; i++) {
            int bMax = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                //Aをi人分作る材料が足りないならこのあと更新されることはないので終了。
                if(q[j] < a[j] * i) {
                    System.out.println(result);
                    return;
                }

                //各材料の必要数が0も有り得るので注意
                if(b[j] != 0 ) {
                    bMax = Math.min(bMax, (q[j] - a[j]*i) / b[j]);
                }
            }

            result = Math.max(result, i + bMax);
        }
    }
}
