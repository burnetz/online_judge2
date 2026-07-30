package atcoder.abc422;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int length = (1 << n);
        int result[] = new int[length];

        Arrays.fill(result, k / length);
        int remain = k % length;

        //全ての要素を等しくできるパターン。当然アンバランス度は0になる。
        if(remain == 0) {
            System.out.println(0);
            for(int i = 0; i < length; i++) {
                System.out.print(result[i] + " ");
            }
            return;
        }

        //それ以外のパターンは適切に値を割り振ればアンバランス度は必ず1になる。
        System.out.println(1);
        assign(remain, 0, length, result);

        for(int i = 0; i < length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    //配列の左右に適切に値を散らす。再帰を使うとやりやすい。
    static void assign (int remain, int l, int r, int a[]) {
        if(r - l == 1) {
            a[l] += remain;
            return;
        }

        int mid = (l + r) / 2;
        assign(remain / 2, l, mid, a);
        assign(remain - (remain / 2), mid, r, a);
    }
}