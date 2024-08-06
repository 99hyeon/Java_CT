package Part3.BOJ21606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B21606_99hyeon {

    static List<List<Integer>> graph;
    static int[] inOut;
    static boolean[] visited;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        num = Integer.parseInt(br.readLine());

        inOut = new int[num+1];
        int count = 0;

        graph = new ArrayList<>();
        for(int i = 0; i <= num; i++){
            graph.add(new ArrayList<>());
        }

        String tmp = br.readLine();
        for(int i = 1; i <= num; i++){
            inOut[i] = Integer.parseInt(String.valueOf(tmp.charAt(i-1)));
        }

        for(int i = 0; i < num-1; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);

            if(inOut[from] == 1 && inOut[to] == 1){     //실내끼리 인접시 경로 갯수 2개 더함
                count += 2;
            }
        }
        br.close();

        visited = new boolean[num + 1];
        for(int i = 1; i <= num; i++){
            int in = 0;     //실내의 수
            if(inOut[i] == 0){
                if(!visited[i]){
                    visited[i] = true;
                    in = dfs(i);
                }
            }
            count += in*(in - 1);
        }

        System.out.println(count);

    }

    private static int dfs(int start){
        int in = 0;

        for(int v : graph.get(start)){
            if(inOut[v] == 0){
                if(!visited[v]){
                    visited[v] = true;
                    in += dfs(v);
                }
            }else{
                in++;
            }
        }
        return in;
    }

}


/**
 * 참고 : https://velog.io/@kimgunwooo/%EB%B0%B1%EC%A4%80-21606%EB%B2%88-%EC%95%84%EC%B9%A8-%EC%82%B0%EC%B1%85
 */
