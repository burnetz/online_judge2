package atcoder.abc383;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrimeNumberGenerator pg = new PrimeNumberGenerator();
        long n = sc.nextLong();

        int result = 0;

        //題意を満たすのはp^8もしくはp_1^2 * p_2^8の形をしている場合のみ。
        //オーバーフローに気をつけながらチェックする。
        for(int i = 2; ; i++) {
            if((long)i*i*i*i*i*i*i*i > n) {
                break;
            }
            if(pg.isPrime(i)) {
                result++;
            }
        }

        Vector<Long> primePowers = new Vector<>();
        for(int i = 2; i <=5_000_000; i++) {
            if(pg.isPrime(i)) {
                if((long)i * i > 4_000_000_000_000L) {
                    break;
                }
                primePowers.add((long)i * i);
            }
        }

        //見た目上はO(N^2)だが、最大でも407000回程度と分かっているので十分間に合う。
        for(int i = 0; i < primePowers.size(); i++) {
            for(int j = i + 1; j < primePowers.size(); j++) {
                long value1 = primePowers.get(i);
                long value2 = primePowers.get(j);

                if(value1 > 2_000_000) {
                    break;
                }
                if(value1 * value2 > n) {
                    break;
                }

                result++;
            }
        }


        System.out.println(result);
    }
}

class PrimeNumberGenerator {
    private boolean[] isPrime = new boolean[5000001];

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