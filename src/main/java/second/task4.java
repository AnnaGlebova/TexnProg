package second;

import java.util.LinkedList;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов:");
        int n = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            System.out.println("Вставить в начало - 1, в конец - 2:");
            int c = scanner.nextInt();
            if (c == 1) {
                list.addFirst(x);
            }
            else {
                list.addLast(x);
            }
        }
        list.forEach(System.out::println);
    }
}
