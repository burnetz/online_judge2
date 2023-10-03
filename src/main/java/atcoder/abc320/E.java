package atcoder.abc320;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        //ID基準のものと食べ終わる時間基準のものの2種類のPriorityQueueがあれば解ける。
        PriorityQueue<Person> bamboo = new PriorityQueue<Person>(Person::compareById);
        PriorityQueue<Person> table = new PriorityQueue<Person>(Person::compareByTime);

        Person[] people = new Person[n];
        for(int i = 0; i < n; i++){
            people[i] = new Person(i);
            bamboo.add(people[i]);
        }

        for(int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();

            //そうめんが流れるタイミングで一気にテーブルからラインへの移動を処理する。
            while(!table.isEmpty()) {
                Person tmp = table.peek();
                if(tmp.eatUntil <= t) {
                    table.remove();
                    bamboo.add(tmp);
                }
                else {
                    break;
                }
            }

            if(!bamboo.isEmpty()) {
                Person tmp = bamboo.remove();
                tmp.eatUntil = t + s;
                tmp.sum += w;
                table.add(tmp);
            }
        }

        StringBuffer sb = new StringBuffer();
        Arrays.stream(people).forEach(e -> sb.append(e.toString()));
        System.out.print(sb);

    }
}

class Person {
    int id;
    long sum = 0;
    long eatUntil = 0;

    Person(int id) {
        this.id = id;
    }

    int compareById(Person another) {
        return this.id - another.id;
    }

    int compareByTime(Person another) {
        return Long.compare(this.eatUntil, another.eatUntil);
    }

    public String toString() {
        return this.sum + "\n";
    }
}