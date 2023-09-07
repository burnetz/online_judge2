package atcoder.agc063;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> alice = new ArrayDeque<>();
        ArrayDeque<Integer> bob = new ArrayDeque<>();

        String str = sc.next();

        for(int i = 0; i < n + 1; i++) {
            if(str.charAt(i) == 'A') {
                alice.add(i);
            }
            else {
                bob.add(i);
            }
        }

        //お互いの最適な戦略は相手を表す文字をインデックスの小さい順にマークしていくこと。
        //もし片方の文字しか無くなればその時点で残ったほうが勝ち続けることが確定。
        for(int i = 0; i < n; i++) {
            //Aliceのターン
            if(i % 2 == 0) {
                if(bob.isEmpty()) {
                    System.out.println("Alice");
                }
                else if(alice.isEmpty()) {
                    System.out.println("Bob");
                }
                else {
                    bob.removeFirst();

                    if(bob.isEmpty() || alice.getFirst() < bob.getFirst()) {
                        System.out.println("Alice");
                    }
                    else {
                        System.out.println("Bob");
                    }
                }
            }
            //Bobのターン
            else {
                if(alice.isEmpty()) {
                    System.out.println("Bob");
                }
                else if(bob.isEmpty()) {
                    System.out.println("Alice");
                }
                else {
                    alice.removeFirst();

                    if(alice.isEmpty() || alice.getFirst() > bob.getFirst()) {
                        System.out.println("Bob");
                    }
                    else {
                        System.out.println("Alice");
                    }
                }
            }
        }

    }
}
