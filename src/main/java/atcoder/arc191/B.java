package atcoder.arc191;

import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        //規則性を見つけること自体は極端な話NとXを1から100までループで回せば容易。
        //その結果Nの最上位ビットまでに存在する0の数だけX側では自由に設定できることが分かる。
        //それ以外のビットはNとXで等しくなる。
        int tmpN = n;
        Vector<Integer> zeroIndex = new Vector<>();
        int index = 0;
        while(tmpN > 0) {
            if(tmpN % 2 == 0) {
                zeroIndex.add(index);
            }

            tmpN /= 2;
            index++;
        }

        if(Math.pow(2, zeroIndex.size()) < k) {
            System.out.println(-1);
            return;
        }

        //0-originにしないと結果がずれる。
        k--;
        int i = 0;
        while(k > 0) {
            if(k % 2 == 1) {
                n += (int)Math.pow(2, zeroIndex.get(i));
            }
            k /= 2;
            i++;
        }

        System.out.println(n);
    }
}