
package atcoder.abc466;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int l = 0;
        int r = 1;

        int result = 0;
        //尺取り法でクエリを投げることで高々2N回で解くことができる。
        while(true) {
            //lとrが一致するクエリを投げると不正解になるので注意
            if(l == r) {
                r++;
                continue;
            }
            System.out.println("? " + (l + 1) + " " + (r + 1));
            String answer = sc.next();

            if(answer.equals("Yes")) {
                int tmp = r - l + 1;
                if(r == n - 1) {
                    result += tmp - 1;
                    break;

                }
                else {
                    result += tmp - 1;
                    r++;
                }

            }
            else {
                if(l == n - 2) {
                    break;
                }
                else {
                    l++;
                }

            }
        }

        System.out.println("! " + result);
    }
}