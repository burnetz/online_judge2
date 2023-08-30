package atcoder.abc300;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        PrimeNumberGenerator pg = new PrimeNumberGenerator();

        //N<=10^12なので使う可能性のある素数は最大でも10^6
        //高速化のためリストではなく配列を使う。
        long primes[] = new long[1_000_000];
        Arrays.fill(primes, 1_000_000);
        int pIndex = 0;
        for(int i = 2; i < 1_000_000; i++) {
            if(pg.isPrime(i)){
                primes[pIndex] = i;
                pIndex++;
            }
        }

        int count = 0;
        //外側のループ2つはa, cについて。
        //どちらも2乗するのでa^2 c^2 <= Nを満たすペアの時点である程度絞れる。
        for(int i = 0; i < pIndex; i++) {
            if(primes[i]*primes[i] > n) {
                break;
            }
            for(int j = i + 2; j < pIndex; j++) {
                //特にオーバーフローに注意する。
                //一気にprimes[j]^2を掛けるとオーバーフローする。
                long tmp = primes[i]*primes[i]*primes[j];
                if(tmp > n){
                    break;
                }
                tmp *= primes[j];
                if(tmp > n){
                    break;
                }

                //本来であれば3重ループを避け2分探索などで高速化を図るべきだが
                //今回の問題はこれでも間に合う。
                for(int k = i + 1; k < j; k++){
                    if(tmp * primes[k] <= n) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}

class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[1000001];

    public PrimeNumberGenerator() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        int limit = (int)Math.sqrt(isPrime.length);
        for(int i = 3; i <= limit; i+=2){
            if(isPrime[i] == false){
                continue;
            }

            for(int j = i * 2; j <= isPrime.length - 1; j += i){
                isPrime[j] = false;
            }
        }
    }

    public boolean isPrime(int index){
        if(index % 2 == 0 && index != 2){
            return false;
        }
        return isPrime[index];
    }
}