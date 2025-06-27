package atcoder.abc409;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();

            String result = s;
            int l = n;
            //「次の文字の方が小さい」箇所があるなら
            //そこを起点に操作すべき。
            for(int j = 0; j < n - 1; j++) {
                if (s.charAt(j) > s.charAt(j + 1)) {
                    l = j;
                    break;
                }
            }

            if(l != n) {
                //終点は「起点よりも大きい文字が最初に現れる場所」の直前とする。
                for (int j = l + 1; j < n; j++) {
                    if(s.charAt(l) < s.charAt(j)) {
                        result = s.substring(0, l) + s.substring(l + 1, j) + s.charAt(l) + s.substring(j);
                        break;
                    }
                    //そのような場所が見つからない場合は起点の文字を末尾に移動させる。
                    if (j == n - 1) {
                        result = s.substring(0, l) + s.substring(l + 1) + s.charAt(l);
                    }
                }
            }

            //なお、操作の必要がない場合はどこか適当な1文字に操作をしたものとみなす。

            System.out.println(result);
        }
    }
}