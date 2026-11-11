package atcoder.arc230;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

//解説をガン見しながら無理矢理通した。
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int mod = 998244353;
        //後でmod版combinationが必要になるので準備
        fact = new long[n + 1];
        factInv = new long[n + 1];

        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }

        factInv[n] = repeatablePow((int)fact[n], mod - 2, mod);
        for(int i = n - 1; i >= 0; i--) {
            factInv[i] = factInv[i + 1] * (i + 1) % mod;
        }

        //combinationの準備ここまで

        //ある辺を辿ったときに改善するコストの計算式については公式の解説を参照。
        //母関数の分子はcombinationで計算でき、分母は2回累積和を求めることで対応させることができる。
        //（東京科学大の競プロサークルの資料を見てやっと理解した）
        long dp[] = new long[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = combination(n, i, mod);
        }

        for(int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1];
            dp[i] %= mod;
        }

        for(int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1];
            dp[i] %= mod;
        }

        Vector<Integer>[] edges = new Vector[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[u].add(v);
            edges[v].add(u);

        }

        visited = new boolean[n];
        //頂点0を集合地点と決め打ちしたときのコスト合計を求める。
        long distSum = calcDist(0, 0, edges);
        distSum %= mod;

        long pattern = repeatablePow(2, n - 1, mod);

        long result = distSum * pattern % mod;

        //各頂点を根とする部分木に含まれる要素数をDFSで求める。
        count = new int[n];
        visited = new boolean[n];
        count(0, edges);

        //各辺を頂点0から遠ざかる方向に進むことで改善するコストの和をBFSで求める。
        //DFSでも多分行ける。
        visited = new boolean[n];
        Queue<Integer> que = new ArrayDeque<>();
        visited[0] = true;
        que.add(0);

        while(!que.isEmpty()) {
            int v = que.remove();

            for(int i = 0; i < edges[v].size(); i++) {
                int tmp = edges[v].get(i);

                if(!visited[tmp]) {
                    result += mod - dp[count[tmp] - 1];
                    result %= mod;
                    que.add(tmp);
                    visited[tmp] = true;
                }
            }
        }


        System.out.println(result);
    }

    static boolean visited[];
    static long calcDist(int currentPos, int currentDepth, Vector<Integer>[] edges) {
        visited[currentPos] = true;
        long result = currentDepth;

        for(int i = 0; i < edges[currentPos].size(); i++) {
            int next = edges[currentPos].get(i);

            if(!visited[next]) {
                result += calcDist(next, currentDepth + 1, edges);

            }
        }

        return result;
    }

    static int count[];
    static int count(int currentPos, Vector<Integer>[] edges) {
        visited[currentPos] = true;
        int result = 1;

        for(int i = 0; i < edges[currentPos].size(); i++) {
            int next = edges[currentPos].get(i);

            if(!visited[next]) {
                result += count(next, edges);

            }
        }

        count[currentPos] = result;
        return result;
    }

    static long[] fact;
    static long[] factInv;
    static long repeatablePow(int x, int n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }
    static long combination(int n, int k, int mod) {
        return fact[n] * factInv[k] % mod * factInv[n - k] % mod;
    }

}