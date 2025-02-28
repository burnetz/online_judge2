package atcoder.abc394;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] strings = new String[n];
        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        Arrays.sort(strings, Comparator.comparingInt(String::length));

        Arrays.stream(strings).forEach(System.out::print);
    }
}