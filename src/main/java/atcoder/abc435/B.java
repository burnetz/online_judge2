package atcoder.abc435;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;

                for(int k = i; k <= j; k++) {
                    sum += a[k];
                }

                boolean isOk = true;
                for(int k = i; k <= j; k++) {
                    if (sum % a[k] == 0) {
                        isOk = false;
                        break;
                    }
                }

                if(isOk) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}