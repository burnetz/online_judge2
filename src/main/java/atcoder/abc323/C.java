package atcoder.abc323;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Problem problems[] = new Problem[m];
        for(int i = 0; i < m; i++) {
            problems[i] = new Problem(i, sc.nextInt());
        }

        boolean solved[][] = new boolean[n][m];
        int score[] = new int[n];
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < m; j++) {
                if(str.charAt(j) == 'o') {
                    solved[i][j] = true;
                    score[i] += problems[j].point;
                }
            }
            score[i] += i + 1;
        }

        int currentMax = Arrays.stream(score).max().getAsInt();

        Arrays.sort(problems, (e1, e2) -> e2.point - e1.point);

        for(int i = 0; i < n; i++) {
            int count = 0;

            int j = 0;
            while(score[i] < currentMax) {
                if(!solved[i][problems[j].id]) {
                    score[i] += problems[j].point;
                    count++;
                }
                j++;
            }

            System.out.println(count);
        }
    }
}

class Problem {
    int id;
    int point;

    Problem (int id, int point) {
        this.id = id;
        this.point = point;
    }
}