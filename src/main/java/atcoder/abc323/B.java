package atcoder.abc323;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] input = new char[n][n];
        for(int i = 0; i < n; i++) {
            input[i] = sc.next().toCharArray();
        }

        Player players[] = new Player[n];
        for(int i = 0; i < n; i++) {
            players[i] = new Player(i + 1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                switch (input[i][j]) {
                    case 'o' -> {
                        players[i].win++;
                    }
                    case 'x' -> {
                        players[j].win++;
                    }
                }
            }
        }

        Arrays.sort(players, (e1, e2) -> e2.win - e1.win);

        Arrays.stream(players).forEach(e -> System.out.print(e.id + " "));
    }
}

class Player {
    int win;
    int id;

    Player (int id) {
        this.id = id;
    }
}