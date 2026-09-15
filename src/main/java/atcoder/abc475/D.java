
package atcoder.abc475;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();

        int n = str.length();
        digits = new int[n];
        Arrays.fill(mapping, -1);

        System.out.println(dfs(0, n));

    }

    static int[] digits;
    static int[] mapping = new int[256];
    static boolean[] used = new boolean[10];
    static String str;
    static PrimeNumberGenerator pg = new PrimeNumberGenerator();

    //素数の判定さえO(1)でできればDFSで十分間に合う。
    static int dfs(int currentDepth, int maxDepth) {
        if(currentDepth == maxDepth) {
            int tmp = 0;
            for(int i = 0; i < maxDepth; i++) {
                tmp *= 10;
                tmp += digits[i];
            }

            if(pg.isPrime(tmp)) {
                return tmp;
            }
            else {
                return -1;
            }

        }

        char c = str.charAt(currentDepth);
        if(mapping[c] != -1) {
            digits[currentDepth] = mapping[c];
            return dfs(currentDepth + 1, maxDepth);
        }
        else {
            for(int i = 0; i < 10; i++) {
                if(used[i]) {
                    continue;
                }
                if(currentDepth == 0 && i == 0) {
                    continue;
                }
                mapping[c] = i;
                digits[currentDepth] = i;
                used[i] = true;
                int result = dfs(currentDepth + 1, maxDepth);
                mapping[c] = -1;
                used[i] = false;
                if(result != -1) {
                    return result;
                }
            }
        }
        return -1;
    }
}

class PrimeNumberGenerator {
    private boolean[] isPrime = new boolean[10000001];

    public PrimeNumberGenerator() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        int limit = (int) Math.sqrt(isPrime.length);
        for (int i = 3; i <= limit; i += 2) {
            if (isPrime[i] == false) {
                continue;
            }

            for (int j = i * 2; j <= isPrime.length - 1; j += i) {
                isPrime[j] = false;
            }
        }
    }

    public boolean isPrime(int index) {
        if (index % 2 == 0 && index != 2) {
            return false;
        }
        return isPrime[index];
    }
}