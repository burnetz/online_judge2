package atcoder.arc169;

import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sumPerDepth = new long[n];

        nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i, sc.nextInt());
        }

        for(int i = 1; i < n; i++) {
            int tmp = sc.nextInt() - 1;
            nodes[tmp].children.add(nodes[i]);
        }

        dfs(0, 0);

        //各階層ごとの深さが重要。最も深いところの係数が+か-かで値が決まる。
        for(int i = maxDepth; i >= 0; i--) {
            if(sumPerDepth[i] > 0) {
                System.out.println("+");
                return;
            }
            else if(sumPerDepth[i] < 0) {
                System.out.println("-");
                return;
            }
            else {
                //この分岐に入るのはA_1が0かつ値の増減が全て打ち消し合う場合。
                if(i == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }
    }

    static Node nodes[];

    static long sumPerDepth[];
    static int maxDepth = 0;

    //深さをごとの和を求めつつ最深部の深さを求める。
    static void dfs(int currentPos, int currentDepth) {
        sumPerDepth[currentDepth] += nodes[currentPos].value;
        maxDepth = Math.max(maxDepth, currentDepth);

        if(nodes[currentPos].children.size() == 0) {
            return;
        }

        long sum = 0;
        for(int i = 0; i < nodes[currentPos].children.size(); i++) {
            Node next = nodes[currentPos].children.get(i);
            dfs(next.id, currentDepth + 1);
        }
    }
}

class Node {
    Vector<Node> children = new Vector<>();
    int id;
    long value;

    Node (int id, int value) {
        this.id = id;
        this.value = value;
    }
}