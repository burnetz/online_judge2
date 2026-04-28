package atcoder.abc453;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] l = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int result = 0;

        for(int i = 0; i < Math.pow(2, n); i++) {
//            System.out.println("i = " + i);
            int mask = 1;

            long pos = 0;
            int tmpCount = 0;
            for(int j = 0; j < n; j++, mask *= 2) {
                if((mask & i) != 0) {
                    long tmpPos = pos + l[j];
                    if(pos < 0 && tmpPos >= 0) {
                        tmpCount++;
                    }
                    pos = tmpPos;
                }
                else {
                    long tmpPos = pos - l[j];
                    if(pos >= 0 && tmpPos < 0) {
                        tmpCount++;
                    }
                    pos = tmpPos;
                }
//                System.out.println("pos = " + pos);
            }
            result = Math.max(result, tmpCount);
        }

        System.out.println(result);
    }
}