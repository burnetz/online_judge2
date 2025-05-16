package atcoder.abc399;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Player[] players = new Player[n];
        for(int i = 0; i < n;i++) {
            players[i] = new Player(i, p[i]);
        }

        Arrays.sort(players, (p1, p2) -> Integer.compare(p2.point, p1.point));

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                players[i].rank = 1;
            }
            else if(players[i - 1].point == players[i].point){
                players[i].rank = players[i - 1].rank;
            }
            else {
                players[i].rank = i + 1;
            }
        }

        Arrays.sort(players, (p1, p2) -> Integer.compare(p1.id, p2.id));

        for(int i = 0; i < n; i++) {
            System.out.println(players[i].rank);
        }
    }
}

class Player {
    int id;
    int rank;
    int point;

    Player (int id, int point) {
        this.id = id;
        this.point = point;
    }
}