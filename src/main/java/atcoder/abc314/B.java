package atcoder.abc314;

import java.util.*;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Player[] players = new Player[n];
        for(int i = 0; i < n; i++){
            players[i] = new Player(i + 1);
            int c = sc.nextInt();
            for(int j = 0; j < c; j++){
                players[i].targets.add(sc.nextInt());
            }
        }

        int x = sc.nextInt();
        List<Player> results = Arrays.stream(players).filter(l -> l.has(x)).sorted().toList();
        if(results.size() == 0){
            System.out.println(0);
            return;
        }

        int min = results.get(0).targets.size();
        results = results.stream().filter(l -> l.targets.size() == min).toList();
        System.out.println(results.size());
        results.forEach(p -> {
            System.out.print(p.id + " ");
        });

    }
}

class Player implements Comparable<Player> {
    List<Integer> targets = new ArrayList<Integer>();
    int id;

    Player(int id){
        this.id = id;
    }

    @Override
    public int compareTo(Player player) {
        return this.targets.size() == player.targets.size() ? this.id - player.id : this.targets.size() - player.targets.size();
    }

    public boolean has(int x){
        return targets.contains(x);
    }
}
