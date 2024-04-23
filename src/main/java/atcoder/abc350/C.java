package atcoder.abc350;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int index[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            index[a[i]] = i;
        }

//        Arrays.stream(index).forEach(System.out::println);

        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            if(a[i] != i + 1) {
//                System.out.println("i = " + i + " a[i] = " + a[i]);
                int from = i;
                int to = index[i + 1];

                sb.append((from + 1) + " " + (to + 1) + "\n");
                a[to] = a[from];
                index[a[from]] = to;
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}