package atcoder.abc390;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = Arrays.stream(new int[5]).map(e -> sc.nextInt()).toArray();

        int count = 0;
        for(int i = 0; i < 4; i++) {
            if(a[i] != i + 1) {
                if (a[i] == i + 2 && a[i + 1] == i + 1) {
                    count++;
                    i++;
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println(count == 1 ? "Yes" : "No");
    }
}