//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.*;
//import java.util.Stack;
//import java.util.StringTokenizer;
//// 자료구조 시간 때 배웠던 지식으로 오랜만에 1트라이만에 끝난 문제. 클래스를 이용하고 재귀를 요리조리 이용하면은 잘 풀 수 있는 문제였다.
//class Node {
//
//    public String mData;
//    public String left;
//    public String right;
//
//    public Node(String mData, String left, String right) {
//        this.mData = mData;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//public class B1991_samgashyeong {
//
//    static StringBuilder sb = new StringBuilder();
//    static ArrayList<Node> arr = new ArrayList<>();
//
//
//    //노드의 데이터가 어느 위치에 있는지 보는 함수
//    static int findData(String a) {
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i).mData.equals(a)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    static void dfs(int index) {
//        System.out.print(arr.get(index).mData);
//        if (!arr.get(index).left.equals(".")) {
//            int findIdx = findData(arr.get(index).left);
//            dfs(findIdx);
//        }
//
//        if (arr.get(index).right.equals(".")) {
//            return;
//        }
//
//        int findIdx = findData(arr.get(index).right);
//        dfs(findIdx);
//
//    }
//
//    static void inOrder(int index) {
//
//        if (!arr.get(index).left.equals(".")) {
//            int findIdx = findData(arr.get(index).left);
//            inOrder(findIdx);
//        }
//
//        System.out.print(arr.get(index).mData);
//
//        if (arr.get(index).right.equals(".")) {
//            return;
//        }
//
//        int findIdx = findData(arr.get(index).right);
//        inOrder(findIdx);
//
//    }
//
//    static void post(int index) {
//
//        if (!arr.get(index).left.equals(".")) {
//            int findIdx = findData(arr.get(index).left);
//            post(findIdx);
//        }
//
//        if (!arr.get(index).right.equals(".")) {
//            int findIdx = findData(arr.get(index).right);
//            post(findIdx);
//        }
//
//        System.out.print(arr.get(index).mData);
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            arr.add(new Node(st.nextToken(), st.nextToken(), st.nextToken()));
//        }
//
//        dfs(0);
//        System.out.print("\n");
//        inOrder(0);
//        System.out.println();
//        post(0);
//    }
//}