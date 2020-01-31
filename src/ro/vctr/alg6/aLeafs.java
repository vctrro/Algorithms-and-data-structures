package ro.vctr.alg6;

import java.io.*;
import java.util.*;

public class aLeafs {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final int SIZE = Integer.parseInt(str.nextToken());

        BinaryTree bt1 = new BinaryTree();
        //long start;
        //long end;

        str = new StringTokenizer(in.readLine());

        //Заполняем дерево значениями
        //start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            bt1.root = bt1.newNode(bt1.root, Integer.parseInt(str.nextToken()));
        }
        //end = System.nanoTime();
        //System.out.printf("Дерево заполнено за %f секунды%n%n", ((end - start) / 1000000000.0));

        //Печатаем листья
        //start = System.nanoTime();
        bt1.leafPrinter(bt1.root);
        //end = System.nanoTime();
        //System.out.printf("%n%nКоличество листьев найдено за %f секунды", ((end - start) / 1000000000.0));

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

        //Распределяем узлы по значению (бинарное дерево поиска)
        Node newNode(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }
            if (value < current.value) {
                current.left = newNode(current.left, value);
            }
            if (value > current.value) {
                current.right = newNode(current.right, value);
            }
            return current;
        }

        //Печать листьев ---------------------------------------------!!
        void leafPrinter(Node current) {
            if (current == null) {
                return;
            }
            if (current.left == null && current.right == null) {
                System.out.print(current.value + " ");
                return;
            }
            leafPrinter(current.left);
            leafPrinter(current.right);
        }
    }
}