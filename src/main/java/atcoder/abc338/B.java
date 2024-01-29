package atcoder.abc338;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count[] = new int[26];
        String str = sc.next();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            count[c - 'a']++;
        }

        int maxIndex = 0;
        for(int i = 1; i < 26; i++) {
            if(count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        System.out.println((char)(maxIndex + 'a'));
    }
}
