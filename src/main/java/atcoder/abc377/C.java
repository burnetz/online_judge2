package atcoder.abc377;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<String> set = new HashSet<>();

        int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        for(int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            set.add(x + "," + y);

            for(int j = 0; j < 8; j++) {
                int tmpX = x + dx[j];
                int tmpY = y + dy[j];

                if(tmpX >= 1 && tmpX <= n && tmpY >= 1 && tmpY <= n) {
                    set.add(tmpX + "," + tmpY);
                }

            }
        }

        System.out.println((long)n * n - set.size());
    }
}