package atcoder.abc398;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count[] = new int[14];

        for(int i = 0; i < 7; i++) {
            count[sc.nextInt()]++;
        }

        Arrays.sort(count);

        if(count[13] >= 3 && count[12] >= 2) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}