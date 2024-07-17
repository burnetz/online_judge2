package atcoder.abc362;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x[] = new int[3];
        int y[] = new int[3];

        for(int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for(int i = 0; i < 3; i++) {
            int x1 = x[(i + 1) % 3] - x[i];
            int y1 = y[(i + 1) % 3] - y[i];
            int x2 = x[(i + 2) % 3] - x[i];
            int y2 = y[(i + 2) % 3] - y[i];

            if(x1*x2+ y1*y2 == 0) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}