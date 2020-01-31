package ro.vctr.alg7;

import java.io.*;
import java.util.*;

public class dCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(str.nextToken());
        final int M = Integer.parseInt(str.nextToken());

        Map<Integer, Set<Integer>> vertex = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());
            vertex.putIfAbsent(A, new HashSet<>(B));
            vertex.get(A).add(B);
        }

        Set<Integer> repeat = new HashSet<Integer>();
        boolean answer = false;

        for (int i = 0; i < N; i++) {
            if (cycle(vertex, i, repeat)) {
                answer = true;
                break;
            }
            repeat.clear();
        }
        if (answer) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

     static boolean cycle(Map<Integer, Set<Integer>> vertex, int index, Set<Integer> repeat) {
        Set<Integer> edges = vertex.get(index);
        if (edges == null) return false;
        if (!repeat.add(index)) return true;
        if (edges.containsAll(repeat)) return true;
        for (Integer integer : edges) {
            if (cycle(vertex, integer, repeat)) return true;
        }
        return false;
     }
}
