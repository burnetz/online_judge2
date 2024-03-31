
package atcoder.abc347;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Arrays.stream(new int[n]).map(e -> sc.nextInt()).
                forEach(e -> {
                    if(e % k == 0) {
                        System.out.print(e/k + " ");
                    }
                });

    }
}