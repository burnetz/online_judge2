package atcoder.abc353;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strArray = new String[n];
        for(int i = 0; i < n; i++) {
            strArray[i] = sc.next();
        }

        Arrays.sort(strArray);

        char[][] matrix = new char[n][];
        for(int i = 0; i < n; i++) {
            matrix[i] = strArray[i].toCharArray();
        }

        long result = calc(matrix, 0, 0, n - 1);

        System.out.println(result);

    }

    //i文字目についてグループ化した結果をもとにi+i文字についてグループ化といった処理を再帰で行う。
    //各iについてグループごとに結果を計算して足し合わせれば良い。
    //元々の文字数が合計3*10^5しかないので2分探索を使わなくても普通のループで探索できる。
    static long calc(char[][] matrix, int depth, int from, int to) {
        //そもそも文字数が一致していない場合の処理。
        //十分な長さがない場合はスキップ。
        int start = 400_000;
        for(int i = from; i <= to; i++) {
            if(matrix[i].length > depth) {
                start = i;
                break;
            }
        }

        long result = 0;
        for(int i = start + 1; i <= to; i++) {
            if(matrix[i][depth] != matrix[start][depth]) {
                //同じ文字が2回以上続いたときだけ再帰・計算する。
                if(i - start >= 2) {
                    result += calc(matrix, depth + 1, start, i - 1);
                    //深さdepthにおけるこのグループの計算結果
                    result += ((long)i - start)*(i - start - 1)/2;
                }
                start = i;
            }
        }
        if(to - start >= 1) {
            result += calc(matrix, depth + 1, start, to);
            result += ((long)to - start + 1)*(to - start)/2;
        }

        return result;
    }
}