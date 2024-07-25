package atcoder.abc363;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        used = new boolean[n];
        charArray = new char[n];

        int[] count = new int[26];
        for(int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int halfside = 0;
        for(int i = 0; i < 26; i++) {
            halfside += count[i] / 2;
        }
        //長さkの回分を作れないパターンはここで処理する。
        if(halfside < k / 2) {
            int result = fact(n);

            for(int i = 0; i < 26; i++) {
                result /= fact(count[i]);
            }

            System.out.println(result);
            return;
        }

        dfs(0, n, s, 0, k);
        System.out.println(set.size());
    }

    static boolean used[];
    static Set<Long> set = new HashSet<>();

    static char[] charArray;

    static void dfs(int currentDepth, int maxDepth, String originalStr, long currentHash, int palindLen) {
        if(currentDepth == maxDepth) {
            if(!isPalindrome(currentDepth - palindLen, palindLen)) {
                set.add(currentHash);
            }
            return;
        }

        if(currentDepth >= palindLen && isPalindrome(currentDepth - palindLen, palindLen)) {
            return;
        }

        for(int i = 0; i < originalStr.length(); i++) {
            if(!used[i]) {
                used[i] = true;
                charArray[currentDepth] = originalStr.charAt(i);
                long tmpHash = currentHash * 26 + (charArray[currentDepth] - 'a');
                dfs(currentDepth + 1, maxDepth, originalStr, tmpHash, palindLen);
                used[i] = false;
            }
        }
    }

    static boolean isPalindrome(int from, int palindLen) {
        for(int i = 0; i < palindLen / 2; i++) {
            if(charArray[i + from] != charArray[from + palindLen - i - 1]) {
                return false;
            }
        }

        return true;
    }

    static int fact(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return fact(n - 1) * n;
    }
}