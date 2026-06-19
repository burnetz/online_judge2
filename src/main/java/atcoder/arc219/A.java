package atcoder.arc219;

import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        digits = new int[m];

        Vector<String> binaries = new Vector();

        for(int i = 0; i < n; i++) {
            binaries.add(sc.next());
        }

        solve(binaries, 0, m);

        System.out.println("No");
    }

    static int digits[];

    //ある桁について0か1を選んだときに、条件が満たされなかったグループについて再帰処理を行う。
    //見た目上の計算量はO(2^M N)だが、Nが比較的小さく再帰中に割と早く枯渇するため問題なく動く。
    static void solve(Vector<String> binaries, int depth, int maxLen) {
        if(depth == maxLen) {
            if(binaries.isEmpty()) {
                System.out.println("Yes");
                for (int i = 0; i < maxLen; i++) {
                    System.out.print(digits[i]);
                }
                System.out.println();
                System.exit(0);
            }
            else {
                return;
            }
        }

        Vector<String> binaries0 = new Vector<>();
        Vector<String> binaries1 = new Vector<>();

        for(int i = 0; i < binaries.size(); i++) {
            String str = binaries.elementAt(i);

            if(str.charAt(depth) == '0') {
                binaries0.add(str);
            }
            else {
                binaries1.add(str);
            }
        }

        //それぞれ条件を満たせなかった方のグループを引数に渡す。
        //なお、一方もしくは両方のグループが空になった（既に全ての文字列について条件を満たした）場合でも
        //この処理で矛盾なく動く。
        digits[depth] = 0;
        solve(binaries1, depth + 1, maxLen);
        digits[depth] = 1;
        solve(binaries0, depth + 1, maxLen);
    }
}
