
package atcoder.abc346;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n - 1; i++) {
            System.out.print(a[i] * a[i + 1] + " ");
        }

    }
}