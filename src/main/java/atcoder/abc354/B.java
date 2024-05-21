package atcoder.abc354;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int rateSum = 0;
        String[] names = new String[n];

        for(int i = 0; i < n; i++) {
            names[i] = sc.next();
            rateSum += sc.nextInt();
        }

        Arrays.sort(names);

        System.out.println(names[rateSum % n]);

    }
}