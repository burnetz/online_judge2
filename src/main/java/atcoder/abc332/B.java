package atcoder.abc332;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int g = sc.nextInt();
        int m = sc.nextInt();
        int currentG = 0;
        int currentM = 0;

        for(int i = 0; i < k; i++) {
            if(currentG == g) {
                currentG = 0;
            }
            else if(currentM == 0) {
                currentM = m;
            }
            else {
                int tmp = Math.min(currentM, g - currentG);
                currentM -= tmp;
                currentG += tmp;
            }

//            System.out.println(currentG + " " + currentM);
        }

        System.out.println(currentG + " " + currentM);
    }
}
