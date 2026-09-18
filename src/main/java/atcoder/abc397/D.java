package atcoder.abc397;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        //x^3-y^3=(x-y)(x^2+xy+y^2)と因数分解できることから、(x-y)はNを割り切らなければならない。
        //右側の因数からx,y<=sqrt(N)であることが分かるので、x-yも10^9まで考慮すれば十分であると分かる。
        //ただし1から10^9まで毎回割り切れるか試すと間に合わないのであらかじめ素因数分解し約数のセットを作っておく。
        //完全な一覧を作るのではなく大きすぎる因数は捨てるということを守ればそこまで時間はかからない。
        Vector<Pair> pFactors = primeFactorization(n);
        Set<Long> factors = new HashSet<>();
        generateFactor(1, 0, pFactors.size(), pFactors, factors, 1_000_000_000);

        for(long diff : factors) {
            if(n % diff != 0) {
                continue;
            }

            long l = 0;
            long r = 1_000_000_001;
            while(r - l > 1) {
                long y = (l + r) / 2;
                long x = y + diff;

                //オーバーフロー対策
                if(n / diff < x*x + x*y + y*y || x*x*x - y*y*y > n) {
                    r = y;
                }
                else if(x*x*x - y*y*y < n) {
                    l = y;
                }
                else {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    static Vector<Pair> primeFactorization(long n) {
        Map<Long, Integer> map = new HashMap<>();

        int divisor = 2;

        while(n > 1) {
            if(n % divisor == 0) {
                map.merge((long)divisor, 1, (e1, e2) -> e1 + 1);
                n /= divisor;
            }
            else {
                if((long)divisor * divisor >= n) {
                    map.put(n, 1);
                    break;
                }

                divisor++;

                if(divisor > 1_000_000) {
                    break;
                }
            }
        }

        Vector<Pair> pairs = new Vector<>();
        for (long key : map.keySet()) {
            pairs.add(new Pair(key, map.get(key)));
        }


        return pairs;
    }

    static void generateFactor(long currentValue, int currentDepth, int maxDepth, Vector<Pair> pFactors, Set<Long> result, long limit) {
        if(currentDepth == maxDepth) {
            result.add(currentValue);
            return;
        }

        generateFactor(currentValue, currentDepth + 1, maxDepth, pFactors, result, limit);
        Pair pFactor = pFactors.get(currentDepth);
        long key = pFactor.key();
        for(int i = 0; i < pFactor.value(); i++) {
            if(limit / key < currentValue || key * currentValue > limit) {
                break;
            }

            currentValue *= key;
            generateFactor(currentValue, currentDepth + 1, maxDepth, pFactors, result, limit);
        }
    }
}

record Pair(long key, int value) {}