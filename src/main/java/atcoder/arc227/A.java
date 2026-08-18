package atcoder.arc227;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String strA = sc.next();
        String strB = sc.next();
        String strC = sc.next();

        int oneIndexA[] = new int[n];
        int oneIndexB[] = new int[n];
        int oneIndexC[] = new int[n];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        for(int i = 0; i < 2 * n; i++) {
            if(strA.charAt(i) == '1') {
                oneIndexA[indexA++] = i;
            }
            if(strB.charAt(i) == '1') {
                oneIndexB[indexB++] = i;
            }
            if(strC.charAt(i) == '1') {
                oneIndexC[indexC++] = i;
            }
        }

        //i番目の1の場所はstrAとstrBとstrCにおけるi番目の1のインデックスの中央値を選ぶのが最適。
        //それ以外、例えば中央値から1ずらすと少なくとも合計コストが1以上増える。
        //この方法で選ばれた1のインデックスは重複しないので自動的に答えの文字列が定まる。
        int indexMedian[] = new int[n];
        for(int i = 0; i < n; i++) {
            int[] tmp = {oneIndexA[i], oneIndexB[i], oneIndexC[i]};
            Arrays.sort(tmp);
            indexMedian[i] = tmp[1];
        }

        long distA = dist(oneIndexA, indexMedian);
        long distB = dist(oneIndexB, indexMedian);
        long distC = dist(oneIndexC, indexMedian);

        long result = distA + distB + distC;

        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < 2 * n; i++) {
            if(index < n && i == indexMedian[index]) {
                sb.append(1);
                index++;
            }
            else {
                sb.append(0);
            }
        }

        System.out.println(sb);
    }

    static long dist(int[] indexA, int[] indexB) {
        long result = 0;

        for(int i = 0; i < indexA.length; i++) {
            result += Math.abs(indexA[i] - indexB[i]);
        }

        return result;
    }

}
