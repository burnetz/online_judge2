package atcoder.abc313;

import java.util.*;
import java.util.stream.IntStream;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int next[] = new int[n];
        Arrays.fill(next, -1);
        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            next[b] = a;
        }

        int count = 0;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(next[i] == -1) {
                count++;
                index = i + 1;
            }
        }

        if(count == 1) {
            System.out.println(index);
        }
        else {
            System.out.println(-1);
        }
    }
}
