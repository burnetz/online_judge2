package atcoder.arc168;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        long result = 0;

        String array[] = str.split("<");
        for(int i = 0; i < array.length; i++) {
            long tmp = array[i].length();
            result += tmp*(tmp + 1)/2;
        }
        System.out.println(result);

    }
}
