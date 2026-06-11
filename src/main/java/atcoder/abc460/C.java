package atcoder.abc460;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();
        int b[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).sorted().toArray();

        int count = 0;
        int indexB = 0;
        for(int i = 0; i < n; i++) {
            if(b[indexB] <= a[i] * 2) {
                count++;
                indexB++;

                if(indexB == m) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}