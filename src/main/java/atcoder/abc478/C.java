
package atcoder.abc478;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] aCopy = Arrays.copyOf(a, n);

        Arrays.sort(aCopy);
        //前から見てどこまでソート前後で一致しているか
        boolean sameForward[] = new boolean[n + 1];
        //後ろから見てどこまでソート前後で一致しているか
        boolean sameBackward[] = new boolean[n + 1];

        sameForward[0] = true;
        for(int i = 0; i < n; i++) {
            if(a[i] == aCopy[i] && sameForward[i]) {
                sameForward[i + 1] = true;
            }
        }

        sameBackward[n] = true;
        for(int i = n - 1; i >= 0; i--) {
            if(a[i] == aCopy[i] && sameBackward[i + 1]) {
                sameBackward[i] = true;
            }
        }

        //選ばれた範囲の外側が既にソート済みであればOK
        for(int i = 0; i < n - k; i++) {
            if(sameForward[i] && sameBackward[i + k]) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}