package atcoder.abc417;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int baseCount[] = new int[400_001];

        for(int i = 0; i < n; i++) {
            baseCount[a[i] + i]++;
        }

        long result = 0;
        for(int i = 1; i < n; i++) {

            if(i - a[i] >= 0) {
                result += baseCount[i - a[i]];
            }
        }

        System.out.println(result);
    }
}