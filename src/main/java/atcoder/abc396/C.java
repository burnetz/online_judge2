package atcoder.abc396;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int black[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int white[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        Arrays.sort(black);
        Arrays.sort(white);

        long blackSum = 0;
        long whiteSum = 0;
        long result = 0;

        for(int i = 0; i < n ; i++ ) {
            blackSum += black[n - 1 - i];
            if(m - 1 - i >= 0 && white[m - 1 - i] > 0) {
                whiteSum += white[m - 1 - i];
            }

            result = Math.max(result, blackSum + whiteSum);
        }

        System.out.println(result);
    }
}