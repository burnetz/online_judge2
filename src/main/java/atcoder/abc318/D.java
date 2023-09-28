package atcoder.abc318;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        matrix = new long[n][n];

        bigPrimes = new BigInteger[n];

        //各辺に対応する素数をかけ合わせる。
        //これにより辺を選ぶことが割り算をすることと対応し状態を管理できる。
        //なお16番目の素数は53でlongでもオーバーフローする。
        BigInteger key = BigInteger.ONE;
        for(int i = 0; i < n; i++) {
            bigPrimes[i] = new BigInteger(Integer.toString(primes[i]));
            key = key.multiply(bigPrimes[i]);
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(i == j) {
                    continue;
                }
                matrix[i][j] = sc.nextInt();
            }
        }

        //奇数の場合は必ず1点余る。キーが素数となるパターンが該当。
        if(n % 2 == 1) {
            for(int i = 0; i < n; i++) {
                map.put(Integer.toString(primes[i]), (long)0);
            }
        }
        //1辺だけ残った場合について予め値を保存しておく。
        //再帰の終了に必要。
        else {
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    map.put(Integer.toString(primes[i]*primes[j]), matrix[i][j]);
                }
            }
        }
        System.out.println(dfs(n, key, 0));

    }

    static long matrix[][];

    //まともに再帰をすると間に合わないのでメモ化を行う。
    static Map<String, Long> map = new HashMap();

    static int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
    //毎回生成すると時間がかかるので予めBigIntegerで各素数を用意しておく。
    static BigInteger bigPrimes[];

    static long dfs(int n, BigInteger key, int currentDepth) {
        long tmpResult = 0;
        for(int i = 0; i < n; i++) {
            //その頂点が使われているかどうかは素数で割った余りを見ればわかる。
            if(key.remainder(bigPrimes[i]).intValue() != 0){
                continue;
            }
            for(int j = i + 1; j < n; j++) {
                if(key.remainder(bigPrimes[j]).intValue() != 0) {
                    continue;
                }

                //新しいキーを作る。頂点を選ぶことは割り算と対応する。
                BigInteger tmpKey = key.divide(bigPrimes[i]).divide(bigPrimes[j]);
                //既にメモがある場合は再帰しない。
                if(map.containsKey(tmpKey.toString())) {
                    tmpResult = Math.max(tmpResult, map.get(tmpKey.toString()) + matrix[i][j]);
                }
                else {
                    tmpResult = Math.max(tmpResult, dfs(n, tmpKey, currentDepth + 1) + matrix[i][j]);
                }
            }
        }
        map.put(key.toString(), tmpResult);
        return tmpResult;
    }
}
