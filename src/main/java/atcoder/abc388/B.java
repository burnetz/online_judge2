package atcoder.abc388;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        int width[] = new int[n];
        int length[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            width[i] = sc.nextInt();
            length[i] = sc.nextInt();
        }


        for(int i = 1; i <= d; i++) {
            int result = 0;
            for(int j = 0; j < n; j++) {
                result = Math.max(result, width[j] * (length[j] + i));
            }

            System.out.println(result);
        }
    }
}