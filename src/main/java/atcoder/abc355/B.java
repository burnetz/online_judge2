package atcoder.abc355;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Vector<Node> vec = new Vector<>();
        for(int i = 0; i < n; i++) {
            vec.add(new Node("A", sc.nextInt()));
        }

        for(int i = 0; i < m; i++) {
            vec.add(new Node("B", sc.nextInt()));
        }

        vec.sort(Comparator.comparingInt(e -> e.value));

        for(int i = 0; i < vec.size() - 1; i++) {
            if(vec.get(i).from.equals("A") && vec.get(i + 1).from.equals("A")) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}

class Node {
    String from;
    int value;

    Node (String from, int value) {
        this.from = from;
        this.value = value;
    }
}