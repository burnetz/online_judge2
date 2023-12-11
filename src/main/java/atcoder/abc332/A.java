package atcoder.abc332;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int k = sc.nextInt();

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += sc.nextInt()*sc.nextInt();
        }

        if(sum < s) {
            sum += k;
        }

        System.out.println(sum);
    }
}
