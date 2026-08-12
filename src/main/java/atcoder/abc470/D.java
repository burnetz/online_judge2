
package atcoder.abc470;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();
        boolean reverse = false;

        //各数字のインデックスを管理しておく
        int index[] = new int[n];
        for(int i = 0; i < n; i++) {
            index[a[i]] = i;
        }

        //操作2で本当に配列の中身を全て書き換えると間に合わないのでフラグの管理のみを行う。
        //a[]を操作2で編集しない場合、操作1でやることは「i番目とj番目を入れ替える」「iとjを入れ替える」のいずれかになる。
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int x = sc.nextInt() - 1;
                    int y = sc.nextInt() - 1;

                    if(reverse) {
                        a[index[x]] = y;
                        a[index[y]] = x;

                        int tmp = index[x];
                        index[x] = index[y];
                        index[y] = tmp;

                    }
                    else {
                        index[a[x]] = y;
                        index[a[y]] = x;

                        int tmp = a[x];
                        a[x] = a[y];
                        a[y] = tmp;
                    }
                }
                case 2 -> {
                    reverse = !reverse;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(reverse) {
                System.out.print(index[i] + 1 + " ");
            }
            else {
                System.out.print(a[i] + 1 + " ");
            }
        }
    }
}