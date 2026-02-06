package atcoder.abc443;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] r = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        boolean[] checked = new boolean[n];
        Pawn[] pawns = new Pawn[n];
        PriorityQueue<Pawn> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.y));
        for(int i = 0; i < n; i++) {

            pawns[i] = new Pawn(i, r[i]);
            pq.add(pawns[i]);
        }

        long result = 0;
        //上にしか移動できないことから、元々一番上にあるものは固定したままで
        //隣接するものを順次調整するのが最適。
        while(!pq.isEmpty()) {
            Pawn tmp = pq.remove();
            if(checked[tmp.x]) {
                continue;
            }
            int index = tmp.x;
            checked[index] = true;

            if(index >= 1) {
                if(r[index - 1] - tmp.y > 1) {
                    result += r[index - 1] - tmp.y - 1;
                    r[index - 1] = tmp.y + 1;
                    pq.add(new Pawn(index - 1, r[index - 1]));
                }
            }

            if(index < n - 1) {
                if(r[index + 1] - tmp.y > 1) {
                    result += r[index + 1] - tmp.y - 1;
                    r[index + 1] = tmp.y + 1;
                    pq.add(new Pawn(index + 1, r[index + 1]));
                }
            }
        }

        System.out.println(result);
    }
}

class Pawn {
    int x;
    int y;

    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }
}