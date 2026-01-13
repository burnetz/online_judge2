package atcoder.abc440;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Horse[] horses = new Horse[n];
        for(int i = 0; i < n; i++) {
            horses[i] = new Horse(i + 1, sc.nextInt());
        }

        Arrays.sort(horses, Comparator.comparingInt(e -> e.time));

        for(int i = 0; i < 3; i++) {
            System.out.println(horses[i].id);
        }
    }
}

class Horse {
    int time;
    int id;


    public Horse(int id, int time) {
        this.time = time;
        this.id = id;
    }
}