package ro.vctr.alg6;

import java.io.*;
import java.util.*;

public class bValidator {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final int SIZE = Integer.parseInt(str.nextToken());

        BinaryTree bt1 = new BinaryTree();
        long start;
        long end;

        str = new StringTokenizer(in.readLine());

        //Заполняем дерево значениями
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            bt1.root = bt1.newNode(bt1.root, Integer.parseInt(str.nextToken()));
        }
        if (bt1.equalCounter == 0) System.out.println(0);
        end = System.nanoTime();
        System.out.printf("%n%nДерево заполнено за %f секунды", ((end - start) / 1000000000.0));

    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    static class BinaryTree {

        Node root;
        int counter = 0;
        int equalCounter = 0;

        //Распределяем узлы по значению (бинарное дерево поиска)
        Node newNode(Node current, int value) {

            if (current == null) {
                counter++;
                return new Node(value);
            }
            if (value < current.value) {
                current.left = newNode(current.left, value);
            }
            if (value > current.value) {
                current.right = newNode(current.right, value);
            }
            if (value == current.value) {
                equalCounter++;
                counter++;
                System.out.print(counter + " ");
            }

            return current;
        }
    }
}
