package atcoder.abc353;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int current = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(k - current >= a[i]) {
                current += a[i];
            }
            else {
                result++;
                current = a[i];
            }
        }

        if(current > 0) {
            result++;
        }

        System.out.println(result);
    }
}