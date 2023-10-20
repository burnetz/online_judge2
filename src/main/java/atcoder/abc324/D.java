package atcoder.abc324;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String numStr = sc.next();
        int count[] = new int[10];
        for(int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            count[digit]++;
        }

        int tmpCount[] = new int[10];
        long result = 0;
        //試しに平方数を作り、それを構成する数字の個数が一致していればOK。
        //平方根の上限がせいぜい4000000程度なので十分間に合う。
loop:        for(long i = 0; i <= 4000000; i++){
            Arrays.fill(tmpCount, 0);
            long sq = i*i;

            //平方数の桁数がもともとの入力よりも大きい場合は作れないので終了
            if(Math.log10(sq) > numStr.length()) {
                break;
            }

            long sqCopy = sq;

            while(sqCopy > 0) {
                tmpCount[(int)(sqCopy%10)]++;
                sqCopy /= 10;
            }

            for(int j = 1 ; j <= 9; j++) {
                if(count[j] != tmpCount[j]) {
                    continue loop;
                }
            }

            result++;
        }

        System.out.println(result);

    }
}
