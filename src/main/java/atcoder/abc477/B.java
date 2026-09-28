
package atcoder.abc477;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int x[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        Vector<Integer> result = new Vector<>();

        for(int i = 0; i < n ; i++) {
            boolean isOk = true;
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }

                if(Math.abs(x[i] - x[j]) < d) {
                    isOk = false;
                    break;
                }

            }

            if(isOk) {
                result.add(i + 1);
            }
        }

        System.out.println(result.size());
        result.forEach(e -> System.out.print(e + " "));

    }
}