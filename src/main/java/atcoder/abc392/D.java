package atcoder.abc392;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int numbers[][] = new int[n][];
        //あらかじめそのダイス内に各数字が何回出てくるかメモする
        int count[][] = new int[n][100001];

        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();
            numbers[i] = Arrays.stream(new int[k]).map(e -> sc.nextInt()).sorted().toArray();
            int finalI = i;
            Arrays.stream(numbers[i]).forEach(e -> {
                count[finalI][e]++;
            });
        }

        double result = 0;
        //3重ループだがnが小さいので間に合う。
        for(int i = 0; i < n; i++) {
            double tmpResult[] = new double[n];
            for(int j = 0; j < numbers[i].length; j++) {
                if(j > 0 && numbers[i][j] == numbers[i][j - 1]) {
                    continue;
                }

                int appear1 = count[i][numbers[i][j]];

                for(int k = i + 1; k < n; k++) {
                    int appear2 = count[k][numbers[i][j]];

                    double tmp = (long)appear1*appear2/(double)numbers[i].length/numbers[k].length;

                    tmpResult[k] += tmp;
                }
            }
            result = Math.max(Arrays.stream(tmpResult).max().getAsDouble(), result);

        }

        System.out.println(result);

    }
}