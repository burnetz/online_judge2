package atcoder.abc373;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strings = new String[12];

        int count = 0;
        for(int i = 0; i < 12; i++) {
            strings[i] = sc.next();

            if(strings[i].length() == i + 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}