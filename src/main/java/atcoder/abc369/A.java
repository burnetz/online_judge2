package atcoder.abc369;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        set.add(b + (b - a));
        set.add(a - (b - a));
        if((b - a) % 2 == 0) {
            set.add((b - a) / 2 + a);
        }

        System.out.println(set.size());
    }
}