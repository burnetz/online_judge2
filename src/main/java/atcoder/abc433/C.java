package atcoder.abc433;

import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long count = 0;
        Vector<CharCount> vector = new Vector<>();

        CharCount charCount = null;
        for(int i = 0; i < s.length(); i++) {
            if(charCount == null) {
                charCount = new CharCount(s.charAt(i), 1);
            }
            else {
                charCount.count++;
            }

            if(i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                vector.add(charCount);
                charCount = null;
            }
        }

        for(int i = 0; i < vector.size() - 1; i++) {
            CharCount tmpCharCount1 = vector.elementAt(i);
            CharCount tmpCharCount2 = vector.elementAt(i + 1);

            if(tmpCharCount1.c + 1 == tmpCharCount2.c) {
                count += Math.min(tmpCharCount1.count, tmpCharCount2.count);
            }
        }

        System.out.println(count);
    }
}

class CharCount {
    char c;
    int count = 0;

    CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}