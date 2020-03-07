package second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов:");
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            map.put(x, i);
        }
        System.out.println("Введите элемент для проверки наличия:");
        int m = scanner.nextInt();
        System.out.println(map.containsKey(m) ? "Есть" : "Нет");

    }
}
