package ro.vctr.alg7;

import java.io.*;
import java.util.*;

public class aGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final byte N = Byte.parseByte(str.nextToken());
        final int M = Integer.parseInt(str.nextToken());

        Map<Byte, Set<Byte>> vertex = new HashMap<Byte, Set<Byte>>();

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(in.readLine());
            byte A = Byte.parseByte(str.nextToken());
            byte B = Byte.parseByte(str.nextToken());
            vertex.putIfAbsent(A, new HashSet<Byte>(B));
            vertex.get(A).add(B);
        }

        str = new StringTokenizer(in.readLine());
        if (Integer.parseInt(str.nextToken()) == 1) {
            matrix(N, vertex);
        } else {
            list(N, vertex);
        }
    }

     static void matrix(byte N, Map<Byte, Set<Byte>> vertex) {

        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                if (vertex.get(i) == null) {
                    System.out.print("0 ");
                } else if (vertex.get(i).contains(j)) {
                    System.out.print("1 ");
                } else System.out.print("0 ");
            }
            System.out.println();
        }
     }

     static void list(byte N, Map<Byte, Set<Byte>> vertex) {

         for (byte i = 0; i < N; i++) {
             for (byte j = 0; j < N; j++) {
                 if (vertex.get(i) == null) {
                     System.out.print("-1 ");
                     break;
                 } else if (vertex.get(i).contains(j)) {
                     System.out.print(j + " ");
                 }
             }
             System.out.println();
         }
     }
}
