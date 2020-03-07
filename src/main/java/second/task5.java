package second;

import java.util.ArrayList;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементтов:");
        int n = scanner.nextInt();
        System.out.println("Введите элементы:");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }
        System.out.println("Введите элемент для поиска:");
        int x = scanner.nextInt();
        System.out.println(list.contains(x) ? "да" : "нет");

    }
}
