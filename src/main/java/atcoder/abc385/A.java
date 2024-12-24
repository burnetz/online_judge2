package atcoder.abc385;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(new int[3]).map(e -> sc.nextInt()).sorted().toArray();

        if(a[0] + a[1] == a[2] || (a[0] == a[1] && a[1] == a[2])) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}