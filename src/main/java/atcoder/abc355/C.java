package atcoder.abc355;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int row[] = new int[n];
        int col[] = new int[n];
        int diaPos = 0;
        int diaNeg = 0;

        for(int i = 1; i <= t; i++) {
            int num = sc.nextInt() - 1;

            row[num/n]++;

            col[num%n]++;

            if(num/n == num%n) {
                diaPos++;
            }

            if(num/n == n - num%n - 1) {
                diaNeg++;
            }
            if(row[num/n] == n || col[num%n] == n || diaPos == n || diaNeg == n) {
                System.out.println(i);
                return;
            }

        }

        System.out.println(-1);
    }
}