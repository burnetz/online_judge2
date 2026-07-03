package atcoder.abc423;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Group[] groups = new Group[n];
        ArrayDeque<Group> groupArrayDeque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            groups[i] = new Group(sc.nextInt(), sc.nextInt(), sc.nextInt());
            groupArrayDeque.add(groups[i]);
        }

        int currentCustomers = 0;
        long currentTime = 0;
        PriorityQueue<Group> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.exitTime));
        while(!groupArrayDeque.isEmpty()) {
            long nextEventTime = Long.MAX_VALUE;

            //退店すべきグループを全て帰らせる
            while(!pq.isEmpty() && pq.peek().exitTime <= currentTime) {
                Group tmpGroup = pq.remove();
                currentCustomers -= tmpGroup.members;
            }


            while(!groupArrayDeque.isEmpty()) {
                Group waitingGroup = groupArrayDeque.getFirst();

                //店に十分な空きがある場合
                if(k - currentCustomers >= waitingGroup.members) {
                    //到着時刻以降の場合
                    if(waitingGroup.arrive <= currentTime) {
                        waitingGroup.enter(currentTime);
                        currentCustomers += waitingGroup.members;
                        pq.add(groupArrayDeque.removeFirst());
                    }
                    //まだ先頭グループが到着していない場合
                    else {
                        nextEventTime = Math.min(nextEventTime, waitingGroup.arrive);
                        break;
                    }
                }
                //店に十分な空きがない場合。このとき必ず中にグループがいるのでその退店時間まで時間を飛ばす。
                else {
                    nextEventTime = Math.min(nextEventTime, pq.peek().exitTime);
                    break;

                }
            }

            currentTime = nextEventTime;
        }


        for(int i = 0; i < n; i++) {
            System.out.println(groups[i].enterTime);
        }

    }
}

class Group {
    int arrive;
    int eat;
    long enterTime;
    long exitTime;
    int members;

    Group(int arrive, int eat, int members) {
        this.arrive = arrive;
        this.eat = eat;
        this.members = members;
    }

    void enter(long enterTime) {
        this.enterTime = enterTime;
        exitTime = enterTime + eat;
    }
}