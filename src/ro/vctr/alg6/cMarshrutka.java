package ro.vctr.alg6;

import java.io.*;
import java.util.*;

public class cMarshrutka {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer str;

        str = new StringTokenizer(in.readLine());
        final int TIME = Integer.parseInt(str.nextToken());
        int busNumber;
        int maxTime = 0;
        Map<Integer, Integer> bus = new HashMap<Integer, Integer>();
        //long start;
        //long end;

        str = new StringTokenizer(in.readLine());

        //Заполняем map значениями
        //start = System.nanoTime();
        for (int i = 0; i < TIME; i++) {
            busNumber = Integer.parseInt(str.nextToken());
            bus.putIfAbsent(busNumber, i);
            int v = bus.put(busNumber, i);
             if (maxTime < i-v) {
                 maxTime = i-v;
             }
        }
        //end = System.nanoTime();
        //System.out.printf("Выполнено за %f секунды", ((end - start) / 1000000000.0));

        System.out.println(maxTime);

    }
}
