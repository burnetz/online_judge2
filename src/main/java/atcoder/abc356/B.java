package atcoder.abc356;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[j] -= sc.nextInt();
            }
        }

        System.out.println(Arrays.stream(a).max().getAsInt() <= 0 ? "Yes" : "No");
    }
}