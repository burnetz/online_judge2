package atcoder.abc393;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == b) {
                count++;
                continue;
            }
            if(a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            String tmpStr = a + " " + b;

            if (set.contains(tmpStr)) {
                count++;
            }
            else {
                set.add(tmpStr);
            }
        }
        System.out.println(count);
    }
}