package atcoder.abc361;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        int result = Integer.MAX_VALUE;
        for(int i = 0; i + (n - k - 1) < n ; i++) {
            result = Math.min(result, a[i + (n - k - 1)] - a[i]);
        }

        System.out.println(result);
    }
}