package atcoder.abc339;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long initial = 0;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];

            if(sum + initial < 0) {
                initial = -sum;
            }
        }

        System.out.println(initial + sum);
    }
}
