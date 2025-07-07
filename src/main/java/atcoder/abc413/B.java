package atcoder.abc413;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strings = new String[n];

        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                set.add(strings[i] + strings[j]);
            }
        }

        System.out.println(set.size());
    }
}