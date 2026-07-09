package atcoder.abc455;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //ノードを自作してリンクのつなぎ方を考えれば解ける。
        //n番目以降は台座扱いの特別なノードにする。これがあることで後で数えやすくなる。
        Node[] nodes = new Node[n * 2];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[n + i] = new Node();
            nodes[i].prev = nodes[n + i];
            nodes[n + i].next = nodes[i];
        }

        for(int i = 0; i < q; i++) {
            int c = sc.nextInt() - 1;
            int p = sc.nextInt() - 1;

            nodes[p].next = nodes[c];
            nodes[c].prev.next = null;
            nodes[c].prev = nodes[p];
        }

        for(int i = 0; i < n; i++) {
            int count = 0;

            Node node = nodes[n + i];

            while(node.next != null) {
                node = node.next;
                count++;
            }

            System.out.print(count + " ");
        }
    }
}

class Node {
    Node prev = null;
    Node next = null;
}