package atcoder.abc427;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = new int[n + 1];
        result[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String tmpStr = Integer.toString(result[j]);
                int tmpSum = 0;
                for(int k = 0; k < tmpStr.length(); k++) {
                    tmpSum += tmpStr.charAt(k) - '0';
                }
                result[i] += tmpSum;
            }
        }

        System.out.println(result[n]);
    }
}