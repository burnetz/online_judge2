package atcoder.abc306;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node nodes[] = new Node[n];

        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i + 1);
        }
        for(int i = 0; i < 3*n; i++){
            int tmp = sc.nextInt();
            nodes[tmp - 1].vec.add(i + 1);
        }

        Arrays.sort(nodes);

        for(int i = 0; i < n; i++){
            System.out.print(nodes[i].num + " ");
        }
    }
}

class Node implements Comparable<Node> {
    int num;
    Vector<Integer> vec = new Vector<Integer>();

    Node(int num){
        this.num = num;
    }
    @Override
    public int compareTo(Node node) {
        return this.vec.get(1) - node.vec.get(1);
    }
}