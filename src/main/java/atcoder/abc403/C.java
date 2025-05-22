package atcoder.abc403;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        boolean hasMasterKey[] = new boolean[n];
        Set[] permissions = new Set[n];
        for(int i = 0; i < n; i++) {
            permissions[i] = new HashSet();
        }

        for(int i = 0; i < q; i++) {
            int query = sc.nextInt();

            switch (query) {
                case 1 -> {
                    int x = sc.nextInt() - 1;
                    int y = sc.nextInt() - 1;

                    permissions[x].add(y);
                }
                case 2 -> {
                    int x = sc.nextInt() - 1;

                    hasMasterKey[x] = true;
                }
                case 3 -> {
                    int x = sc.nextInt() - 1;
                    int y = sc.nextInt() - 1;

                    if(hasMasterKey[x] || permissions[x].contains(y)) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }

                }
            }
        }
    }
}