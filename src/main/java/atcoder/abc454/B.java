package atcoder.abc454;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt() - 1;

            set.add(tmp);
        }

        System.out.println(set.size() == n ? "Yes" : "No");
        System.out.println(set.size() == m ? "Yes" : "No");

    }
}