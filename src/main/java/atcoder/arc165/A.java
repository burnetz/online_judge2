package atcoder.arc165;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        PrimeNumberGenerator pg = new PrimeNumberGenerator();

        Vector<Integer> primes = new Vector<>();

        for(int i = 0; i <= 100_000 ; i++) {
            if(pg.isPrime(i)) {
                primes.add(i);
            }
        }

loop:        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            boolean isPrime = true;
            for(int j = 0; j < primes.size() && n > primes.get(j); j++) {
                if(n % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                System.out.println("No");
                continue;
            }

            int primeIndex = 0;

            boolean divided = false;

            while(n > 1) {
                int divisor = primes.get(primeIndex);
                if(n % divisor == 0) {
                    n /= divisor;
                    divided = true;
                }
                else {

                    if(divided) {
                        System.out.println("Yes");
                        continue loop;
                    }
                    primeIndex++;
                }
            }

            System.out.println("No");

        }
    }

}

class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[100001];

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