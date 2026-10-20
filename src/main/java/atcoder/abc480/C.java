
package atcoder.abc480;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n + 2];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //ダミーを入れておくとやりやすい。
        //先頭は0ではなく-kにすること。
        a[n] = -k;
        a[n + 1] = t;
        Arrays.sort(a);

        int count = 0;
        for(int i = 1; i <= n + 1; i++) {
            //要素の間隔がkより大きいときは必要な回数ボタンを押す必要がある。
            if(a[i] - a[i - 1] > k) {
                count += (a[i] - a[i - 1] - 1) / k;
            }

            //入力にはt以後の操作も含まれているが計算上不要なので無視。
            if(a[i] == t) {
                break;
            }
        }

        System.out.println(count);
    }
}