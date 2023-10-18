package atcoder.abc324;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        int count = 0;
        StringBuffer sb = new StringBuffer();

        loop:       for(int i = 0; i < n; i++) {
            String tmpStr = sc.next();
            //全く同じor１文字書き換わっただけのパターンはまとめられる。
            if(str.length() == tmpStr.length()) {
                int diff = 0;
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) != tmpStr.charAt(j)) {
                        diff++;
                    }
                }

                if(diff <= 1) {
                    count++;
                    sb.append((i + 1) + " ");
                }
            }
            //違う文字を見つけたら長い文字列の方に下駄を履かせる。
            //この方法で残り２パターンは処理できる。
            else if(str.length() + 1 == tmpStr.length()) {
                int offset = 0;
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) != tmpStr.charAt(j)) {
                        offset = 1;
                    }
                    if(str.charAt(j) != tmpStr.charAt(j + offset)) {
                        continue loop;
                    }

                }
                count++;
                sb.append((i + 1) + " ");
            }
            else if(str.length() == tmpStr.length() + 1) {
                int offset = 0;
                for(int j = 0; j < tmpStr.length(); j++) {
                    if(str.charAt(j) != tmpStr.charAt(j)) {
                        offset = 1;
                    }
                    if(str.charAt(j + offset) != tmpStr.charAt(j)) {
                        continue loop;
                    }

                }
                count++;
                sb.append((i + 1) + " ");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
