package atcoder.abc449;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        String s = sc.next();

        int[][] count = new int[26][n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 26; j++) {
                count[j][i + 1] = count[j][i];
            }

            count[s.charAt(i) - 'a'][i + 1]++;
        }

        long sum = 0;
        for(int i = 0; i < n; i++) {
            int cIndex = s.charAt(i) - 'a';

            int tmp = count[cIndex][Math.max(i + 1 - l, 0)] - count[cIndex][Math.max(i - r, 0)];

            sum += tmp;
        }

        System.out.println(sum);
    }
}