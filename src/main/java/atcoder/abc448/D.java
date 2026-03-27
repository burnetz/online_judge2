package atcoder.abc448;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        numbers = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        edges = new Vector[n];

        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[u].add(v);
            edges[v].add(u);
        }

        visited = new boolean[n];
        isOk = new boolean[n];

        dfs(0, false);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(isOk[i] ? "Yes": "No").append("\n");
        }
        System.out.println(sb);

    }

    static int[] numbers;
    static Vector<Integer>[] edges;
    static boolean[] visited;
    static boolean[] isOk;
    //最大値が大きいので配列では管理できない。
    static Map<Integer, Integer> map = new HashMap<>();

    //木構造なのでルートが1パターンしかなく、一度条件に該当すればその先もずっと該当する。
    static void dfs(int index, boolean duplicated) {
        visited[index] = true;

        map.merge(numbers[index], 1, (e1, e2) -> e1 + 1);

        int times = map.get(numbers[index]);
        if(times > 1 || duplicated) {
            isOk[index] = true;
        }

        for(int i = 0; i < edges[index].size(); i++) {
            int tmp = edges[index].elementAt(i);
            if(!visited[tmp]) {
                dfs(tmp, isOk[index]);
            }
        }

        if(times == 1) {
            map.remove(numbers[index]);
        }
        else {
            map.put(numbers[index], times - 1);
        }
    }
}