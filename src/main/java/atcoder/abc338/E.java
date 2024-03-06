package atcoder.abc338;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Chord[] chords = new Chord[n];

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            chords[i] = new Chord(Math.min(a, b), Math.max(a, b));
        }

        //あらかじめ弦が始点についてソートされていればこの後容易に交差の有無を判定できる。
        Arrays.sort(chords);

        //弦の終点を格納する。
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            //現在の弦の始点よりも前に終点があったものはこの後どことも交差しないので削除する。
            while(!pq.isEmpty() && pq.peek() < chords[i].from) {
                pq.poll();
            }
            //現在の始点と終点の間に既に終点が存在する場合は交差
            if(!pq.isEmpty() && pq.peek() < chords[i].to) {
                System.out.println("Yes");
                return;
            }

            pq.add(chords[i].to);
        }

        System.out.println("No");

    }
}

class Chord implements Comparable<Chord> {
    int from;
    int to;

    Chord(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Chord o) {
        return this.from - o.from;
    }
}