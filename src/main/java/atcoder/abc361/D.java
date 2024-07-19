package atcoder.abc361;

import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String start = sc.next() + "..";
        String goal = sc.next() + "..";

        //生成しうる状態が10万程度しか無いため全部の状態を管理できる。
        Set<String> set = new HashSet<>();
        set.add(start);
        Deque<State> que = new ArrayDeque<>();
        que.add(new State(start, 0));

        while(!que.isEmpty()) {
            State tmpState = que.removeFirst();

            if(tmpState.stateStr.equals(goal)) {
                System.out.println(tmpState.time);
                return;
            }

            for(int i = 0; i < n + 1; i++) {
                if(tmpState.stateStr.substring(i, i + 2).equals("..")) {
                    for(int j = 0; j < n + 1; j++) {
                        if(!tmpState.stateStr.substring(j, j + 2).contains(".")) {
                            char[] tmpCharArray = tmpState.stateStr.toCharArray();

                            for(int k = 0; k < 2; k++) {
                                char tmp = tmpCharArray[i + k];
                                tmpCharArray[i + k] = tmpCharArray[j + k];
                                tmpCharArray[j + k] = tmp;
                            }

                            String str = new String(tmpCharArray);
                            if(!set.contains(str)) {
                                set.add(str);
                                que.addLast(new State(str, tmpState.time + 1));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class State {
    String stateStr;
    int time;

    State (String stateStr, int time) {
        this.stateStr = stateStr;
        this.time = time;
    }
}