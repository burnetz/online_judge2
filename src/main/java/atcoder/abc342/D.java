package atcoder.abc342;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        PrimeNumberGenerator pg = new PrimeNumberGenerator();

        Map<Integer, Integer> map = new HashMap<>();

        long result = 0;
        int zero = 0;
        for(int i = 0; i < n; i++) {
            //0はそれまでのどの値とも組み合わせられる。
            if(a[i] == 0) {
                result += i;
                zero++;
            }
            //a[i]をそれ以前の要素と掛け合わせて平方数を作るためには
            //素因数分解したときに指数が奇数である素数の積が一致している必要がある。
            //逆に言えばその半端な部分が何回出現したかをmapで管理すれば以後O(1)で判定できる。
            else if(pg.isPrime(a[i])) {
                if(map.containsKey(a[i])) {
                    result += map.get(a[i]) + zero;
                }
                else {
                    result += zero;
                }
                map.merge(a[i], 1, (n1, n2) -> n1 + 1);
            }
            else {
                int divisor = 2;
                int counter = 0;
                //半端な素数の積
                int oddPrimeProd = 1;
                //素因数分解
                while (a[i] > 1) {
                    //素因数分解の途中で素数になったときは適宜切り上げることで高速化
                    if(counter == 0 &&  pg.isPrime(a[i])) {
                        oddPrimeProd *= a[i];
                        break;
                    }
                    else if(a[i] % divisor == 0) {
                        counter++;
                        a[i] /= divisor;

                        if(a[i] % divisor != 0) {
                            if(counter % 2 == 1) {
                                oddPrimeProd *= divisor;
                            }
                            divisor++;
                            counter = 0;
                        }
                    }
                    else {
                        divisor++;
                    }
                }

                if(map.containsKey(oddPrimeProd)) {
                    result += map.get(oddPrimeProd) + zero;
                }
                else {
                    result += zero;
                }
                map.merge(oddPrimeProd, 1, (n1, n2) -> n1 + 1);
            }
        }

        System.out.println(result);
    }

}

class PrimeNumberGenerator {
    private boolean[] isPrime = new boolean[200001];

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