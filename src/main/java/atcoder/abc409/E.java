package atcoder.abc409;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i, sc.nextInt());
        }

        //頂点間のコストを保存するためのマップ。
        //今回に関しては辺をリストで持つよりもこの方が使いやすい。
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int cost = sc.nextInt();

            map.put(u + "," + v, cost);
            map.put(v + "," + u, cost);

            nodes[u].addNeighbor(v);
            nodes[v].addNeighbor(u);
        }

        //このキューの中には度数1の頂点のみが入る。
        //木構造なので最後の1頂点になるまでキューが空になることはない。
        Deque<Node> que = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(nodes[i].degree == 1) {
                que.add(nodes[i]);
            }
        }

        long result = 0;

        //葉にある電荷はそこから移動させるかそこに他所から移動させるかの2択なので
        //常に葉の電荷を内側に移して葉を落としていけばよい。
        //最終的には1頂点だけが残り全ての打ち消しが完了する。
        while(que.size() > 1) {
            Node tmpNode = que.remove();

            int targetIndex = -1;
            for(int i = 0; i < tmpNode.neighbor.size(); i++) {
                int tmpIndex = tmpNode.neighbor.get(i);

                if(nodes[tmpIndex].isActive) {
                    targetIndex = tmpIndex;

                    break;
                }
            }

            Node targetNode = nodes[targetIndex];

            String key = tmpNode.id + "," + targetIndex;

            result += map.get(key) * Math.abs(tmpNode.value);

            targetNode.value += tmpNode.value;
            targetNode.degree--;

            if(targetNode.degree == 1) {
                que.addLast(targetNode);
            }

            tmpNode.isActive = false;

        }

        System.out.println(result);
    }
}

class Node {
    int id;
    long value;
    int degree;
    boolean isActive = true;
    Vector<Integer> neighbor = new Vector<>();

    Node(int id, long value) {
        this.id = id;
        this.value = value;
    }

    void addNeighbor(int id) {
        neighbor.add(id);
        degree++;
    }
}