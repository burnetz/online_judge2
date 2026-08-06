package atcoder.abc427;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

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
        int m = sc.nextInt();
        int k = sc.nextInt();

        String s = sc.next();

        Vector<Integer>[] vectors = new Vector[n];
        for(int i = 0; i < n; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            vectors[u].add(v);
        }

        Map<Integer, Boolean>[] maps = new HashMap[2 * k + 1];
        for(int i = 0; i < maps.length ; i++) {
            maps[i] = new HashMap<>();
        }

        System.out.println(dfs(vectors, s, maps, 0,1, 2 * k) ? "Alice" : "Bob");


    }

    //Aliceが勝つ場合はtrue, Bobが勝つ場合はfalse
    static boolean dfs(Vector<Integer>[] vectors, String label, Map<Integer, Boolean>[] maps, int currentPos, int currentDepth, int maxDepth) {
        //適宜履歴を参照するようにしないとTLEになる。
        if(maps[currentDepth].containsKey(currentPos)) {
            return maps[currentDepth].get(currentPos);
        }

        //基本的な目標としては最後のターンにBobがAしか選べない状況に持ち込みたい。
        if(currentDepth == maxDepth) {
            for(int i = 0; i < vectors[currentPos].size(); i++) {
                int next = vectors[currentPos].get(i);

                if(label.charAt(next) == 'B') {
                    return false;
                }
            }

            return true;
        }

        //AliceはBobが詰む状況を作るのが目標で、Bobはそれを邪魔しようとする。
        for(int i = 0; i < vectors[currentPos].size(); i++) {
            int next = vectors[currentPos].get(i);

            boolean tmpResult = dfs(vectors, label, maps, next, currentDepth + 1, maxDepth);
            //AliceにとってもBobにとっても1つでも必勝の手があればOK。
            if(currentDepth % 2 == 1) {
                if(tmpResult) {
                    maps[currentDepth].put(currentPos, true);
                    return true;
                }
            }
            else {
                if(!tmpResult) {
                    maps[currentDepth].put(currentPos, false);
                    return false;
                }
            }
        }
        //ここまで来たということは必勝の手が無かった場合なので、上のループと返り値が逆になる。
        maps[currentDepth].put(currentPos, currentDepth % 2 != 1);
        return currentDepth % 2 != 1;

    }

}