package atcoder.abc371;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean boyExist[] = new boolean[n];

        for(int i = 0; i < m; i++) {
            int index = sc.nextInt() - 1;
            String sex = sc.next();

            if(sex.equals("M")) {
                if(!boyExist[index]) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }

                boyExist[index] = true;
            }
            else {
                System.out.println("No");
            }
        }
    }
}