package atcoder.abc311;

import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        next = new int[n];
        group = new int[n];
        Arrays.fill(group, -1);

        for(int i = 0; i < n; i++){
            next[i] = sc.nextInt() - 1;
        }

        for(int i = 0; i < n; i++){
            if(group[i] == -1){
                int result = dfs(i, i);

                if(result != -1){
                    int current = result;
                    int count = 0;
                    StringBuffer sb = new StringBuffer();
                    while(true){
                        sb.append(current + 1 + " ");
                        count++;
                        current = next[current];
                        if(current == result){
                            System.out.println(count);
                            System.out.println(sb);
                            return;
                        }
                    }
                }
            }
        }

    }

    static int group[];
    static int next[];

    /**
     * サイクル検出用のDFS
     * @param pos 現在のポジション
     * @param groupId グループID。通常はDFSの起点のインデックス番号
     * @return サイクルに属するある頂点のID
     */
    static int dfs(int pos, int groupId) {
        group[pos] = groupId;

        if(group[next[pos]] < 0){
            return dfs(next[pos], groupId);
        }
        else if(group[next[pos]] != groupId){
            return -1;
        }
        else {
            return next[pos];
        }


    }
}
