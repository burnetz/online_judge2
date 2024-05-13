package atcoder.abc352;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int index[] = new int[n + 1];
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i, a[i]);
            index[a[i]] = i;
        }

        PriorityQueue<Node> p1 = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.index));
        PriorityQueue<Node> p2 = new PriorityQueue<>((n1, n2) -> Integer.compare(n2.index, n1.index));
        for(int i = 0; i < n; i++) {
            if(a[i] >= 1 && a[i] <= k) {
                p1.add(nodes[i]);
                p2.add(nodes[i]);
            }
        }

        int result = p2.peek().index - p1.peek().index;

        //i, i + 1, ... i + k - 1を含む数列の直径を順次計算する。
        //左端、右端をそれぞれPriorityQueueが管理しているのでO(NlogN)で解ける。
        for(int i = 2; i <= n - k + 1; i++) {
            p1.add(nodes[index[i + k - 1]]);
            p2.add(nodes[index[i + k - 1]]);

            while(p1.peek().value < i || p1.peek().value >= i + k) {
                p1.poll();
            }
            while(p2.peek().value < i || p2.peek().value >= i + k) {
                p2.poll();
            }

            result = Math.min(result, p2.peek().index - p1.peek().index);
        }

        System.out.println(result);
    }
}

class Node {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}