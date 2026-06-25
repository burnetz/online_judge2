package atcoder.abc459;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        String str = sc.next();
        int n = str.length();
        CharCount[] charCounts = new CharCount[256];
        for(int i = 0; i < 256; i++) {
            charCounts[i] = new CharCount((char)i);
        }

        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);

            charCounts[c].count++;
        }

        Arrays.sort(charCounts, (e1, e2) -> Integer.compare(e2.count, e1.count));

        //先に偶数インデックスの文字を埋めてから奇数インデックスにそれらと異なる文字を入れれば題意を満たせるが
        //一番多い文字の出現回数が過半数の場合この方法が使えない。
        if(charCounts[0].count > (n + 1) / 2) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");

            StringBuffer sb = new StringBuffer();
            for (CharCount charCount : charCounts) {
                if (charCount.count == 0) {
                    break;
                }

                sb.append(String.valueOf(charCount.c).repeat(Math.max(0, charCount.count)));
            }

            char[] result = new char[n];
            for(int i = 0; i < n; i++) {
                int index = (2 * i) % n;
                if(n % 2 == 0 && i >= n / 2) {
                    index++;
                }
                result[index] = sb.charAt(i);
            }

            System.out.println(result);
        }
    }
}

class CharCount {
    char c;
    int count;

    CharCount(char c) {
        this.c = c;
    }
}