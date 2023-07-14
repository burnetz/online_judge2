package atcoder.abc308;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Player[] players = new Player[n];
        for(int i = 0; i < n; i++){
            players[i] = new Player(i + 1, sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(players);

        Arrays.stream(players).forEach(p -> {
            System.out.print(p.id + " ");
        });
        System.out.println();
    }
}

class Player implements Comparable<Player> {
    int id;
    long win;
    long lose;

    Player(int id, int win, int lose){
        this.id = id;
        this.win = win;
        this.lose = lose;
    }

    double calcRate() {
        return (double)win/(win + lose);
    }
    @Override
    public int compareTo(Player player) {
        //普通に勝率をdoubleで計算しようとすると誤差が出るので
        //不等式に分母を掛けた式で比較（Longに収まる）
        long tmp1 = this.win*(player.win + player.lose);
        long tmp2 = player.win*(this.win + this.lose);

        return Long.compare(tmp2, tmp1) != 0 ? Long.compare(tmp2, tmp1) : Integer.compare(this.id, player.id);
    }
}