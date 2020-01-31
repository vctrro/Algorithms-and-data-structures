package ro.vctr.alg7;

import java.io.*;
import java.util.*;

public class aGraph_ {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final byte N = Byte.parseByte(str.nextToken());
        final int M = Integer.parseInt(str.nextToken());

        byte[][] vertex = new byte[N][N];
        //заполняем нулями
        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                vertex[i][j] = 0;
            }
        }

        //если есть путь пишем единицу
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(in.readLine());
            byte A = Byte.parseByte(str.nextToken());
            byte B = Byte.parseByte(str.nextToken());
            vertex[A][B] = 1;
        }

        str = new StringTokenizer(in.readLine());
        if (Integer.parseInt(str.nextToken()) == 1) {
            matrix(vertex, N);
        } else {
            list(vertex, N);
        }
    }

    static void matrix(byte[][] vertex, byte N) {
        //просто выводим матрицу
        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                System.out.print(vertex[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void list(byte[][] vertex, byte N) {
        //если единица, выводим значение вершины и ставим метку (empty), что не пусто
        for (byte i = 0; i < N; i++) {
            boolean empty = true;
            for (byte j = 0; j < N; j++) {
                if (vertex[i][j] == 1) {
                    System.out.print(j + " ");
                    empty = false;
                }
            }
            //если ниразу не попалась единица, выводим -1
            if(empty) System.out.print("-1");
            System.out.println();
        }
    }
}
