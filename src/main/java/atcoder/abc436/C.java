package atcoder.abc436;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<String> set = new HashSet<>();

        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            boolean isOk = true;
            for(int j = 0; j < 4; j++) {
                int tmpR = r - dy[j];
                int tmpC = c - dx[j];

                if(set.contains(tmpR + "," + tmpC)) {
                    isOk = false;
                    break;
                }
            }

            if(isOk) {
                for(int j = 0; j < 4; j++) {
                    int tmpR = r - dy[j];
                    int tmpC = c - dx[j];

                    set.add(tmpR + "," + tmpC);
                }
            }
        }

        System.out.println(set.size() / 4);
    }
}