package atcoder.abc344;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //途中への挿入・削除はたとえばLinkedListが比較的強いが
        //特定の要素の探索にはO(N)かかってしまう。
        //そのため常に要素の場所を把握できるようリストを自力実装する必要がある。
        Node head = new Node(-1);
        Map<Integer, Node> map = new HashMap<>();
        Node tail = new Node(-2);
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;

        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tail.prev.insert(new Node(value));
            map.put(value, tail.prev);
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if(type == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                Node target = map.get(x);
                Node newNode = new Node(y);
                target.insert(newNode);
                map.put(y, newNode);
            }
            else {
                int x = sc.nextInt();

                Node target = map.get(x);
                target.delete();
                map.remove(x);
            }
        }

        Node tmpNode = head.next;
        while(tmpNode != tail) {
            System.out.print(tmpNode.value + " ");
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }

    void insert(Node newNode) {
        newNode.next = this.next;
        newNode.prev = this;
        newNode.next.prev = newNode;
        this.next = newNode;
    }

    void delete() {
        this.next.prev = this.prev;
        this.prev.next = this.next;
    }
}