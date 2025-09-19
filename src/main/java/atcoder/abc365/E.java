package atcoder.abc365;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //a[0]からa[i - 1]までのxorの値
        int[] xorSum = new int[n + 1];
        //上記のxorSumの部分和
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            xorSum[i + 1] = xorSum[i] ^ a[i];
            sum[i + 1] = sum[i] + xorSum[i + 1];
        }

        //xorSumに現れる1の個数の部分和をビットごとに保存する。
        int[][] bitCount = new int[n + 1][32];
        for(int i = 1; i <= n; i++) {
            int mask = 1;
            for(int j = 0; j < 32; j++) {
                bitCount[i][j] = bitCount[i - 1][j];

                if((xorSum[i] & mask) != 0) {
                    bitCount[i][j]++;
                }

                mask *= 2;
            }
        }

        long result = 0;
        int tmpXor = 0;

        for(int i = 1; i < n; i++) {
            result += sum[n] - sum[i];
            int mask = 1;
            for(int j = 0; j < 32; j++) {
                int bitOn = bitCount[n][j] - bitCount[i][j];
                int bitOff = n - i - bitOn;

                //a[0] ~ a[i - 1]までのxorの結果、ビットjが立っているなら補正を行う。
                //「その1がなければ合計はいくらになるべきか」を考えれば計算が可能。
                if((tmpXor & mask) != 0) {
                    long tmp = (long)mask * bitOn;

                    result -= tmp;

                    long tmp2 = (long)mask * bitOff;

                    result += tmp2;

                }

                mask *= 2;
            }
            tmpXor ^= a[i - 1];

        }

        System.out.println(result);
    }
}