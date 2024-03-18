package atcoder.abc344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int m = sc.nextInt();
        int b[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();
        int l = sc.nextInt();
        int c[] = Arrays.stream(new int[l]).map(e -> sc.nextInt()).toArray();

        Set<Integer> set = new HashSet<>();
        Arrays.stream(a).forEach(e1 -> {
            Arrays.stream(b).forEach(e2 -> {
                Arrays.stream(c).forEach(e3 -> {
                    set.add(e1 + e2 + e3);
                });
            });
        });

        int q = sc.nextInt();
loop:        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();

            if(set.contains(x)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }

    }
}