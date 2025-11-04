package atcoder.abc430;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][n];

        for(int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        Set<String> set = new HashSet<>();

        for(int i = 0; i < n - m + 1; i++) {
            for(int j = 0; j < n - m + 1; j++) {
                String s = "";
                for(int k = i; k < m + i; k++) {
                    for(int l = j; l < m + j; l++) {
                        s += matrix[k][l];
                    }
                }
                set.add(s);
            }
        }

        System.out.println(set.size());
    }
}