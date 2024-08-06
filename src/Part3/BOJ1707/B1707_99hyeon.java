package Part3.BOJ1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1707_99hyeon {
    static int[] checkList;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(st.nextToken()); // test case 개수

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v + 1];
            checkList = new int[v+1];

            for(int x = 0; x <= v; x++){
                list[x] = new ArrayList<>();
            }

            for(int j = 0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            if(!DFS(list, checkList, 1, 1)){
                sb.append("NO").append("\n");
            }else{
                Boolean check = true;
                loop1 :
                for(int j = 1; j <= e; j++){
                    for(int x : list[j]){
                        if(checkList[j] == checkList[x]){
                            check = false;
                            sb.append("NO").append("\n");
                            break loop1;
                        }
                    }
                }
                if(check){
                    sb.append("YES").append("\n");
                }
            }
        }
        br.close();
        System.out.println(sb);
    }

    static boolean DFS(ArrayList<Integer>[] list, int[] check,int a, int b){
        check[a] = b;
        for(int i : list[a]){
            if(check[i] == 0){
                DFS(list, check, i, 3-b);
            }
            else if(check[i] == check[a]){
                return false;
            }
        }
        return true;
    }
}

/**
 * 참고 : https://1-7171771.tistory.com/56
 * 런타임 에러 - 고쳐야함
 */
