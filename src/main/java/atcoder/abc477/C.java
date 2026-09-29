
package atcoder.abc477;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        String s = sc.next();
        String t = sc.next();

        int[] count = new int[s.length() + 1];
        for(int i = 0; i < s.length() ; i++) {
            count[i + 1] = count[i];

            if(i <= s.length() - t.length() && s.startsWith(t, i)) {
                count[i + 1]++;
            }
        }

        for(int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            //対象の区間とそれ以前の区間で文字列tが開始された回数を比較する。
            //増えているなら対象の区間内で新たに発生したということ。
            if(r - t.length() + 1 >= 0 && count[l - 1] < count[r - t.length() + 1]) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }

    }
}