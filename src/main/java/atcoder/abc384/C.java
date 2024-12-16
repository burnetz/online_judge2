package atcoder.abc384;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = Arrays.stream(new int[5]).map(e -> sc.nextInt()).toArray();


        PriorityQueue<Player> pq = new PriorityQueue<>();
        for(int i = 1; i <= 32; i++) {
            pq.add(new Player(i, a));
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.remove().name);
        }
    }
}

class Player implements Comparable<Player> {
    String name = "";
    int score;

    Player(int key, int scores[]) {
        for(int i = 0; i < 5; i++) {
            if(key % 2 == 1) {
                name += (char)('A' + i);
                score += scores[i];
            }

            key /= 2;
        }
    }


    @Override
    public int compareTo(Player p) {
        return this.score != p.score ? Integer.compare(p.score, this.score) : this.name.compareTo(p.name);
    }
}