package atcoder.abc405;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(a[i] <= m) {
                set.add(a[i]);
                if(set.size() == m) {
                    System.out.println(n - i);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}