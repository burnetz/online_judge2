package atcoder.abc309;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Event events[] = new Event[n];
        long total = 0;
        for(int i = 0; i < n; i++){
            events[i] = new Event(sc.nextInt(), sc.nextInt());
            total += events[i].amount;
        }

        if(total <= k) {
            System.out.println(1);
            return;
        }

        Arrays.sort(events);

        for(int i = 0; i < n; i++){
            total -= events[i].amount;

            if(total <= k){
                System.out.println(events[i].time + 1);
                return;
            }
        }
    }
}

class Event implements Comparable<Event> {
    int time;
    int amount;

    Event(int time, int amount){
        this.time = time;
        this.amount = amount;
    }

    @Override
    public int compareTo(Event event) {
        return this.time - event.time;
    }
}