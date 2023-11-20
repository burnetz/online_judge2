package atcoder.abc329;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count[] = new int[n + 1];
        int currentTop = 0;

        for(int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            count[tmp]++;
            if(count[tmp] > count[currentTop] || (count[tmp] == count[currentTop] && tmp < currentTop)) {
                currentTop = tmp;
            }
            System.out.println(currentTop);

        };
    }
}
