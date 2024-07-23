package atcoder.abc363;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();

        int l[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int count[] = new int[101];
        for(int i = 0; i < n; i++) {
            count[l[i]]++;
        }

        int sum = 0;
        for(int i = 100; i >= 1; i--) {
            sum += count[i];

            if(sum >= p) {
                System.out.println(Math.max(0, t - i));
                return;
            }
        }
    }
}