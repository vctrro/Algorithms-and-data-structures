package ro.vctr.alg6;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        final int SIZE = 20000000;
        final int MAX = 50000000;

        Random random = new Random();
        int[] data = new int[SIZE];
        BinaryTree bt1 = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        BinaryTree bt3 = new BinaryTree();
        long start;
        long end;

        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(MAX);
        }
        double k = 0;


        //Заполняем дерево
        for (int n=0; n<3; n++) {
            start = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                bt1.root = bt1.newNode(bt1.root, data[i]);
            }
            //if (bt1.equalCounter == 0) System.out.println(0);
            end = System.nanoTime();
            k += (end-start);
            bt1 = new BinaryTree();
        }
        System.out.printf("%n%nДерево заполнено за %f секунды", ((k/3) / 1000000000.0));

        k = 0;
        for (int n=0; n<3; n++) {
            start = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                bt2.root = bt2.newNode1(bt2.root, data[i]);
            }
            //if (bt2.equalCounter == 0) System.out.println(0);
            end = System.nanoTime();
            k += (end-start);
            bt2 = new BinaryTree();
        }
        System.out.printf("%n%nДерево заполнено за %f секунды", ((k/3) / 1000000000.0));

        k=0;
        for (int n=0; n<3; n++) {
            start = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                bt3.root = bt3.newNode2(bt3.root, data[i]);
            }
            //if (bt3.equalCounter == 0) System.out.println(0);
            end = System.nanoTime();
            k += (end-start);
            bt3 = new BinaryTree();
        }
        System.out.printf("%n%nДерево заполнено за %f секунды", ((k/3) / 1000000000.0));

        k = 0;
        for (int n=0; n<3; n++) {
            start = System.nanoTime();
            for (int i = 0; i < SIZE; i++) {
                bt1.root = bt1.newNode(bt1.root, data[i]);
            }
            //if (bt1.equalCounter == 0) System.out.println(0);
            end = System.nanoTime();
            k += (end-start);
            bt1 = new BinaryTree();
        }
        System.out.printf("%n%nДерево заполнено за %f секунды", ((k/3) / 1000000000.0));


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
        int gf = 0;

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
                gf++;//System.out.print(counter + " ");
            }

            return current;
        }

        Node newNode1(Node current, int x) {
            if (current == null) {
                counter++;
                return new Node(x);
            } else if (x < current.value) {
                current.left = newNode(current.left, x);

            } else if (x > current.value) {
                current.right = newNode(current.right, x);
            } else if (x == current.value) {
                equalCounter++;
                counter++;
                if(equalCounter != 0) {
                    gf++;
                }
                else{
                    gf++;
                }

            }
            return current;
        }

        Node newNode2(Node current, int x) {
            if (current == null) {
                counter++;
                return new Node(x);
            } else if (x < current.value) {
                current.left = newNode(current.left, x);

            } else if (x > current.value) {
                current.right = newNode(current.right, x);
            } else {
                equalCounter++;
                counter++;
                gf++;
            }
            return current;
        }
    }
}
