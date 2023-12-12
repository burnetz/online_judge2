package atcoder.abc332;

import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int a[][] = new int[h][w];
        int b[][] = new int[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                b[i][j] = sc.nextInt();
                sb.append(b[i][j] + ",");
            }
        }
        String goal = sb.toString();

        Deque<State> que = new ArrayDeque<>();

        //既に登場した状態を記録する
        Set<String> set = new HashSet<>();

        State start = new State(0, a);
        set.add(start.toString());
        que.add(start);

        //H, Wが小さいので全ての状態をBFSで調べることができる。
        while(!que.isEmpty()) {
            State tmpState = que.removeFirst();

            if(tmpState.toString().equals(goal)) {
                System.out.println(tmpState.time);
                return;
            }

            for(int i = 0; i < h - 1; i++) {
                State tmp = tmpState.swapRow(i);
                if(!set.contains(tmp.toString())) {
                    set.add(tmp.toString());
                    que.add(tmp);
                }
            }

            for(int i = 0; i < w - 1; i++) {
                State tmp = tmpState.swapColumn(i);
                if(!set.contains(tmp.toString())) {
                    set.add(tmp.toString());
                    que.add(tmp);
                }
            }
        }

        System.out.println(-1);

    }
}

class State {
    int time;
    int matrix[][];

    State(int time, int matrix[][]) {
        this.time = time;
        this.matrix = matrix;
    }

    //行を入れ替えた新しいStateを作る
    State swapRow(int rowIndex) {
        int h = matrix.length;
        int w = matrix[0].length;

        int tmp[][] = new int[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(i == rowIndex) {
                    tmp[i][j] = matrix[i + 1][j];
                }
                else if(i == rowIndex + 1) {
                    tmp[i][j] = matrix[i - 1][j];
                }
                else {
                    tmp[i][j] = matrix[i][j];
                }
            }
        }

        return new State(this.time + 1, tmp);
    }

    //列を入れ替えた新しいStateを作る
    State swapColumn(int colIndex) {
        int h = matrix.length;
        int w = matrix[0].length;

        int tmp[][] = new int[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(j == colIndex) {
                    tmp[i][j] = matrix[i][j + 1];
                }
                else if(j == colIndex + 1) {
                    tmp[i][j] = matrix[i][j - 1];
                }
                else {
                    tmp[i][j] = matrix[i][j];
                }
            }
        }

        return new State(this.time + 1, tmp);
    }

    //これによりSetでの管理が容易になる。
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + ",");
            }
        }
        return sb.toString();
    }
}