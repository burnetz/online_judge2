package atcoder.arc182;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            //K = 1のときはひたすら1を出すだけ。
            //後半の処理だとうまく行かないためここで片付ける。
            if(k == 1) {
                for(int j = 0; j < n; j++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
                continue;
            }

            //問題文を言い換えると「右シフトを許して最もバリエーションが豊かになる数列」とも言える。
            //2進数のまま考えるとわかりやすい。
            //バリエーションを増やすためにはなるべく上位のビットで色々なパターンを作ると良い（ただし最上位は1固定で良い）。
            //そのために普通に数字を数え上げて2進数にしてリバースしたものを順に使う。
            for(int j = 0; j < Math.min(n, Math.pow(2, k - 1)); j++) {
                StringBuffer sb = new StringBuffer(Integer.toBinaryString(j)).reverse();
                while(sb.length() < k - 1) {
                    sb.append(0);
                }

                System.out.print(Integer.parseInt(1 + sb.toString(), 2) + " ");
            }

            //上のループでバリエーションは出尽くしているため余りは適当な数字を出す。
            for(int j = 0; j < n - Math.pow(2, k - 1); j++) {
                System.out.print(1 + " ");
            }

            System.out.println();
        }
    }
}
