package atcoder.abc319;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 8; i++) {
            que[i] = new ArrayDeque();
        }

        dfs(0, 0, "");

        //全部で362880パターンであることは確定しているので割合を計算する。
        System.out.println((double)count / 362880);

    }

    static boolean used[] = new boolean[9];

    static int matrix[][] = new int[3][3];

    static int count = 0;

    static ArrayDeque<Integer>[] que = new ArrayDeque[8];
    static boolean excite[] = new boolean[9];

    //全部で40万パターン程度なのでそれぞれについて条件を確認しても間に合う。
    static void dfs(int currentDepth, int index, String log) {
        if(currentDepth == 9) {
            count++;
            return;
        }


        for(int i = 0; i < 9; i++) {
            if(!used[i]) {
                int col = i / 3;
                int row = i % 3;

                //行列斜めについてがっかりの判定を行う。
                //該当したら即continue
                int queIndex1 = col;
                if(excite[queIndex1] && que[queIndex1].getFirst() != matrix[col][row]) {
                    continue;
                }

                int queIndex2 = row + 3;
                if(excite[queIndex2] && que[queIndex2].getFirst() != matrix[col][row]) {
                    continue;
                }

                int queIndex3 = -1;
                if(i == 0 || i == 4 || i == 8) {
                    queIndex3 = 6;
                }
                int queIndex4 = -1;
                if(i == 2 || i == 4 || i == 6) {
                    queIndex4 = 7;
                }

                if(queIndex3 > 0 && excite[queIndex3] && que[queIndex3].getFirst() != matrix[col][row]) {
                    continue;
                }
                if(queIndex4 > 0 && excite[queIndex4] && que[queIndex4].getFirst() != matrix[col][row]) {
                    continue;
                }

                //ある方向の2つ目の要素を選ぶ際はリーチの確認をする。
                //3つ目の要素を選ぶときは特に気にしない。
                if(que[queIndex1].size() == 1 && que[queIndex1].getFirst() == matrix[col][row]) {
                    excite[queIndex1] = true;
                }

                if(que[queIndex2].size() == 1 && que[queIndex2].getFirst() == matrix[col][row]) {
                    excite[queIndex2] = true;
                }

                if(queIndex3 > 0 && que[queIndex3].size() == 1 && que[queIndex3].getFirst() == matrix[col][row]) {
                    excite[queIndex3] = true;
                }

                if(queIndex4 > 0 && que[queIndex4].size() == 1 && que[queIndex4].getFirst() == matrix[col][row]) {
                    excite[queIndex4] = true;
                }

                //ここまでの確認を経て初めてキューに値を追加する。
                que[queIndex1].add(matrix[col][row]);
                que[queIndex2].add(matrix[col][row]);
                if(queIndex3 > 0) {
                    que[queIndex3].add(matrix[col][row]);
                }
                if(queIndex4 > 0) {
                    que[queIndex4].add(matrix[col][row]);
                }

                used[i] = true;

                //for debug
                String tmpLog = "";

                dfs(currentDepth + 1, i, tmpLog);
                used[i] = false;

                //ここからはdfsまでにおこなった作業の逆を行う。
                que[queIndex1].removeLast();
                que[queIndex2].removeLast();
                if(queIndex3 > 0) {
                    que[queIndex3].removeLast();
                }
                if(queIndex4 > 0) {
                    que[queIndex4].removeLast();
                }

                if(que[queIndex1].size() <= 1) {
                    excite[queIndex1] = false;
                }

                if(que[queIndex2].size() <= 1) {
                    excite[queIndex2] = false;
                }

                if(queIndex3 > 0 && que[queIndex3].size() <= 1) {
                    excite[queIndex3] = false;
                }

                if(queIndex4 > 0 && que[queIndex4].size() <= 1) {
                    excite[queIndex4] = false;
                }
            }
        }
    }
}
