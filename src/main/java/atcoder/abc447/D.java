package atcoder.abc447;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Deque<Integer> queA = new ArrayDeque<>();
        Deque<Integer> queB = new ArrayDeque<>();
        Deque<Integer> queC = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A' -> {
                    queA.add(i);
                }
                case 'B' -> {
                    queB.add(i);
                }
                case 'C' -> {
                    queC.add(i);
                }
            }
        }

        int count = 0;

        //貪欲法で解くことができる。
        while(!queA.isEmpty() && !queB.isEmpty() && !queC.isEmpty()) {
            int indexA = queA.removeFirst();

            int indexB = -1;
            while(!queB.isEmpty()) {
                if(queB.getFirst() > indexA) {
                    indexB = queB.removeFirst();
                    break;
                }
                queB.removeFirst();
            }

            if(indexB == -1) {
                break;
            }

            int indexC = -1;
            while(!queC.isEmpty()) {
                if(queC.getFirst() > indexB) {
                    indexC = queC.removeFirst();
                    break;
                }
                queC.removeFirst();
            }

            if(indexC == -1) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }
}