package ro.vctr.alg7;

import java.io.*;
import java.util.*;

public class bKeys {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final byte N = Byte.parseByte(str.nextToken());
        final byte M = Byte.parseByte(str.nextToken());
        final byte K = Byte.parseByte(str.nextToken());

        Map<Byte, SortedSet<Byte>> vertex = new HashMap<>();
        Set<Byte> visited = new HashSet<Byte>();

        //создаём Map для хранения записок
        for (byte i=1; i<=N; i++) {
            vertex.put(i, new TreeSet<>(new HashSet<>()));
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(in.readLine());
            byte A = Byte.parseByte(str.nextToken());
            byte B = Byte.parseByte(str.nextToken());
            vertex.get(A).add(B);
        }

        for (byte i=1; i<=N; i++) {
            if (search(vertex, visited, K, i)) break;
        }

//        System.out.println(vertex);
//        System.out.println(visited);
    }

    static boolean search(Map<Byte, SortedSet<Byte>> vertex, Set<Byte> visited, byte K, byte i) {

        if (i == K) {
            System.out.println("Keys found!");
            return true;
        }
        System.out.println("Mark " + i + " as visited");
        visited.add(i);
        for (byte j : vertex.get(i)) {
            if (visited.contains(j)) {
                System.out.println(j + " is already visited");
            } else {
                System.out.println("Go to " + j);
                if (search(vertex, visited, K, j)) return true;}
        }
        System.out.println("Return back");
        return false;
    }
}