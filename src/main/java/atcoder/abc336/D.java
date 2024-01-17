package atcoder.abc336;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //a[i]を頂上として作れる上り坂と下り坂の最大サイズを保存する。
        int dpUp[] = new int[n];
        int dpDown[] = new int[n + 1];

        dpUp[0] = a[0] == 0 ? 0 : 1;
        for(int i = 1; i < n; i++) {
            dpUp[i] = Math.min(dpUp[i - 1] + 1, a[i]);
        }
        for(int i = n - 1; i >= 0; i--) {
            dpDown[i] = Math.min(dpDown[i + 1] + 1, a[i]);
        }

        int result = 0;
        //上り坂と下り坂の高さのうち低い方に合わせてピラミッドを作れる。
        for(int i = 0; i < n; i++) {
            result = Math.max(result, Math.min(dpUp[i], dpDown[i]));
        }
        System.out.println(result);
    }
}
