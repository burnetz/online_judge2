package atcoder.abc346;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int m = sc.nextInt();

        int colorCol[] = new int[w];
        int colorRow[] = new int[h];
        int timeCol[] = new int[w];
        int timeRow[] = new int[h];
        long count[] = new long[200001];

        //逆向きに処理した方が楽なので一旦全ての操作を保存しておく。
        Vector<Command> vec = new Vector<>();

        for(int i = 1; i <= m; i++) {
            int mode = sc.nextInt();
            int pos = sc.nextInt() - 1;
            int color = sc.nextInt();

            vec.add(new Command(mode, pos, color));
        }

        int paintedRow = 0;
        int paintedCol = 0;
        for(int i = vec.size() - 1; i >= 0; i--) {
            Command com = vec.get(i);

            switch (com.mode) {
                case 1 -> {
                    //既にその列や行が処理されている場合は何もしない。
                    if(timeRow[com.pos] > 0) {
                        continue;
                    }
                    colorRow[com.pos] = com.color;
                    timeRow[com.pos] = i + 1;
                    //その行で塗ることができるのは未処理の列のマスだけ。
                    count[com.color] += w - paintedCol;
                    paintedRow++;
                }
                case 2 -> {
                    if(timeCol[com.pos] > 0) {
                        continue;
                    }
                    colorCol[com.pos] = com.color;
                    timeCol[com.pos] = i + 1;
                    count[com.color] += h - paintedRow;
                    paintedCol++;
                }
            }
        }

        //上のループでは一度も塗られずに色が0のマスが考慮されていない。
        //ただし途中で0に塗った可能性があるので代入ではなく加算。
        long countSum = Arrays.stream(count).sum();
        count[0] += (long)h*w - countSum;

        int resultCount = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                resultCount++;
                sb.append(i + " " + count[i] + "\n");
            }
        }

        System.out.println(resultCount);
        System.out.print(sb);
    }
}

class Command {
    int mode;
    int pos;
    int color;

    Command (int mode, int pos, int color) {
        this.mode = mode;
        this.pos = pos;
        this.color = color;
    }
}