package atcoder.abc434;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();

        for(int i = 0; i < caseNum; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int h = sc.nextInt();
        int lowerLimit = h;
        int upperLimit = h;

        int t[] = new int[n + 1];
        int l[] = new int[n];
        int u[] = new int[n];
        for(int i = 0; i < n; i++) {
            t[i + 1] = sc.nextInt();
            l[i] = sc.nextInt();
            u[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int dt = t[i + 1] - t[i];
            int tmpLower = Math.max(0, lowerLimit - dt);
            int tmpUpper = upperLimit + dt;
            if(tmpLower > u[i] || tmpUpper < l[i]) {
                System.out.println("No");
                return;
            }
            else {
                lowerLimit = Math.max(l[i], lowerLimit - dt);
                upperLimit = Math.min(u[i], upperLimit + dt);
            }
        }
        System.out.println("Yes");
    }
}