package atcoder.abc391;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        Block blocks[] = new Block[n];
        //各ブロックがいつ消えるかはすぐにはわからないが
        //何ライン目として消えるかは調べられるのでそのための準備をする。
        PriorityQueue<Block>[] ques = new PriorityQueue[n + 1];
        for(int i = 0; i < n + 1; i++) {
            ques[i] = new PriorityQueue<>();
        }

        for(int i = 0; i < n; i++) {
            blocks[i] = new Block(i, sc.nextInt(), sc.nextInt());
            ques[blocks[i].x].add(blocks[i]);
        }

        //同時に消滅するブロックを同じグループとして管理する。
        Vector<Block>[] vectors = new Vector[n];
        for(int i = 0; i < n; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < n; i++) {
            int level = 0;
            while(!ques[i].isEmpty()) {
                Block tmpBlock = ques[i].remove();
                tmpBlock.lineLevel = level;
                vectors[level].add(tmpBlock);
                level++;
            }
        }

        //同一タイミングで消滅するラインごとにその時刻を調べる。
        int lineRemoveTime[] = new int[n];
        Arrays.fill(lineRemoveTime, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            //そもそも横一列を充足しないなら以後確認不要
            if(vectors[i].size() < w) {
                break;
            }
            int maxY = 0;

            for(int j = 0; j < vectors[i].size(); j++) {
                //一番下が0ではなく1なので補正
                maxY = Math.max(maxY, vectors[i].get(j).y - 1);
            }

            //同一グループ内の最大のy座標でおおよそ決まるが
            //少なくともその前のグループが消えた1秒後以降でなければならない。
            if(i == 0) {
                lineRemoveTime[i] = maxY;
            }
            else {
                lineRemoveTime[i] = Math.max(maxY, lineRemoveTime[i - 1] + 1);
            }
        }

        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt() - 1;

            if(lineRemoveTime[blocks[a].lineLevel] >= t) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }


    }
}

class Block implements Comparable<Block> {
    int id;
    int x;
    int y;
    int lineLevel = 0;

    Block(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Block b) {
        return Integer.compare(this.y, b.y);
    }

    @Override
    public String toString() {
        return "id " + id + "x " + x + " y " + y + " line level " + lineLevel;
    }
}