package atcoder.abc348;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int maxHP[][] = new int[h][w];

        char[][] matrix = new char[h][w];
        int startR = 0;
        int startC = 0;
        int goalR = 0;
        int goalC = 0;
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
            Arrays.fill(maxHP[i], -1);

            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
                else if(matrix[i][j] == 'T') {
                    goalR = i;
                    goalC = j;
                }
            }
        }

        int n = sc.nextInt();

        int [][] medicine = new int[h][w];
        for(int i = 0; i < n; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int e = sc.nextInt();

            medicine[r][c] = e;
        }

        ArrayDeque<State> que = new ArrayDeque<>();
        maxHP[startR][startC] = medicine[startR][startC];
        que.addLast(new State(startR, startC, maxHP[startR][startC]));

        int[] dc = {0, 1, 0, -1};
        int[] dr = {-1, 0, 1, 0};
        //BFSで解く。
        while(!que.isEmpty()) {
            State state = que.removeFirst();

            //薬を使うかどうかを選べる。
            //既に使ってしまったかどうかは気にする必要はない。
            //（最適なルートであれば一度薬を取った場所に戻ることはないため）
            int tmpHP = Math.max(state.maxHP, medicine[state.r][state.c]);

            for(int i = 0; i < 4; i++) {
                int tmpR = state.r + dr[i];
                int tmpC = state.c + dc[i];

                if(tmpR >= 0 && tmpR < h && tmpC >= 0 && tmpC < w && matrix[tmpR][tmpC] != '#') {
                    if(maxHP[tmpR][tmpC] >= tmpHP - 1) {
                        continue;
                    }

                    //HPの更新が発生したときだけqueに追加する。
                    que.addLast(new State(tmpR, tmpC, tmpHP - 1));
                    maxHP[tmpR][tmpC] = tmpHP - 1;
                }
            }
        }

        //ゴールのマスでHPが0以上ならOK
        if(maxHP[goalR][goalC] >= 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }

}

class State {
    int r;
    int c;
    int maxHP;

    State (int r, int c, int maxHP) {
        this.r = r;
        this.c = c;
        this.maxHP = maxHP;
    }
}