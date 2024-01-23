package atcoder.abc337;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int next[] = new int[n];
        Arrays.fill(next, -1);

        int first = -1;
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt() - 1;

            if(tmp < 0) {
                first = i;
            }
            else {
                next[tmp] = i;
            }
        }

        int current = first;
        for(int i = 0; i < n; i++) {
            System.out.print(current + 1 + " ");
            current = next[current];
        }

        for(int i = 0; i < n; i++) {
        }
    }
}
