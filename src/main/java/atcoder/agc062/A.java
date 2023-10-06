package atcoder.agc062;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String str = sc.next();
            //末尾がAで終わっている場合次も必ず末尾がAになるので答えがAに確定する。
            if(str.charAt(len - 1) == 'A') {
                System.out.println("A");
                continue;
            }

            //以下末尾はBであるとする。
            //途中にBAとなっている箇所があると必ず次も途中にAが残り最終的な答えがAになる。
            //BになるのはA....AB....Bのパターンのみ。
            boolean containA = false;
            for(int j = str.length() - 2; j >= 1; j--) {
                if(str.charAt(j) == 'A' && str.charAt(j - 1) == 'B') {
                    containA = true;
                    break;
                }
            }

            if(containA) {
                System.out.println("A");
            }
            else {
                System.out.println("B");
            }
        }
    }
}
