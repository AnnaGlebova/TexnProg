package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементтов:");
        int n = scanner.nextInt();
        System.out.println("Введите элементы:");
        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }
        list.sort(Collections.reverseOrder());
        list.forEach(System.out::println);
    }
}
